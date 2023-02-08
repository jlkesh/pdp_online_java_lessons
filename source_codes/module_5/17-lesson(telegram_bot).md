

````java
package dev.jlkesh.java_telegram_bots;

import com.pengrad.telegrambot.ExceptionHandler;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramException;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TelegramBot bot = new TelegramBot("6119464761:AAGBu2CIA-6dgbadAdlrF3umC19UqM3iYgo");
        /*SendMessage sendMessage = new SendMessage("5270439889", "Hello From Simple Test Bot");
        KeyboardButton contact = new KeyboardButton(" ☎️ Contact");
        contact.requestContact(true);
        KeyboardButton[] row1 = {
                contact,
                new KeyboardButton("Location")
        };
        ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup(row1);
        replyMarkup.addRow(new KeyboardButton("Settings"));
        sendMessage.replyMarkup(replyMarkup);
        replyMarkup.resizeKeyboard(true);
        bot.execute(sendMessage);*/
        /*SendPhoto sendPhoto = new SendPhoto("5270439889", Files.readAllBytes(Path.of("/home/jlkesh/Documents/avatar_woman.jpg")));
        SendAudio sendAudio = new SendAudio("5270439889", Files.readAllBytes(Path.of("/home/jlkesh/Documents/sherali-jorayev-gulbadan.mp3")));
        bot.execute(sendPhoto);
        bot.execute(sendAudio);
        */
        bot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> updates) {
                for ( Update update : updates ) {
                    Message message = update.message();
                    Chat chat = message.chat();
                    Long chatID = chat.id();
                    String text = message.text();
                    SendMessage sendMessage = new SendMessage(chatID, "Replied to : " + text);
                    bot.execute(sendMessage);
                }
                return CONFIRMED_UPDATES_ALL;
            }
        }, new ExceptionHandler() {
            @Override
            public void onException(TelegramException e) {

            }
        });
    }
}
````



````java
package dev.jlkesh.java_telegram_bots;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;

import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TelegramBotRunner {
    private static final ResourceBundle settings = ResourceBundle.getBundle("settings");
    private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final ThreadLocal<TelegramBotUpdateHandler> telegramBotUpdateHandlerThreadLocal = ThreadLocal.withInitial(TelegramBotUpdateHandler :: new);

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(settings.getString("bot.token"));
        bot.setUpdatesListener((updates) -> {
                    for ( Update update : updates )
                        CompletableFuture.runAsync(() ->
                                        telegramBotUpdateHandlerThreadLocal.get().handle(update),
                                executorService);
                    return UpdatesListener.CONFIRMED_UPDATES_ALL;
                },
                Throwable :: printStackTrace);
    }
}
````



````java
package dev.jlkesh.java_telegram_bots;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.AnswerCallbackQuery;
import com.pengrad.telegrambot.request.DeleteMessage;
import com.pengrad.telegrambot.request.SendDocument;
import com.pengrad.telegrambot.request.SendMessage;
import dev.jlkesh.seeder.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class TelegramBotUpdateHandler {

    private final TelegramBot bot = new TelegramBot(ResourceBundle.getBundle("settings").getString("bot.token"));
    private final static ConcurrentHashMap<Long, State> usersState = new ConcurrentHashMap<>();
    private final static ConcurrentHashMap<Long, FakerApplicationGenerateRequest> generateDataRequest = new ConcurrentHashMap<>();

    public void handle(Update update) {
        var message = update.message();
        var callbackQuery = update.callbackQuery();
        if ( message != null ) {
            var chat = message.chat();
            var chatID = chat.id();
            var text = message.text();
            if ( text.equals("/start") ) {
                var sendMessage = new SendMessage(chatID, "Welcome To OUR @FakerBot\n\nTo generate data send /generate command");
                bot.execute(sendMessage);
            } else if ( text.equals("/generate") ) {
                var sendMessage = new SendMessage(chatID, "Send File Name");
                bot.execute(sendMessage);
                usersState.put(chatID, State.FILE_NAME);
                generateDataRequest.put(chatID, new FakerApplicationGenerateRequest());
            } else if ( State.FILE_NAME.equals(usersState.get(chatID)) ) {
                var sendMessage = new SendMessage(chatID, "Send Row Count");
                bot.execute(sendMessage);
                usersState.put(chatID, State.ROW_COUNT);
                generateDataRequest.get(chatID).setFileName(text);
            } else if ( State.ROW_COUNT.equals(usersState.get(chatID)) ) {
                var sendMessage = new SendMessage(chatID, "Choose Fields");
                sendMessage.replyMarkup(getInlineMarkupKeyboard());
                bot.execute(sendMessage);
                usersState.put(chatID, State.FIELDS);
                generateDataRequest.get(chatID).setCount(Integer.parseInt(text));
                generateDataRequest.get(chatID).setFileType(FileType.JSON);
            } else {
                var deleteMessage = new DeleteMessage(chatID, message.messageId());
                bot.execute(deleteMessage);
            }
        } else {
            FieldType[] fieldTypes = FieldType.values();
            String data = callbackQuery.data();
            Message message1 = callbackQuery.message();
            Chat chat = message1.chat();
            Long chatID = chat.id();
            if ( data.equals("g") ) {
                FakerApplicationService fakerApplicationService = new FakerApplicationService();
                String path = fakerApplicationService.processRequest(generateDataRequest.get(chatID));
                try {
                    SendDocument sendDocument = new SendDocument(chatID, Files.readAllBytes(Path.of(path)));
                    bot.execute(sendDocument);
                    bot.execute(new DeleteMessage(chatID, message1.messageId()));
                } catch (IOException e) {
                    AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery(callbackQuery.id());
                    answerCallbackQuery.text("\uD83D\uDFE5 Error: Please retry again later");
                    answerCallbackQuery.showAlert(true);
                    bot.execute(answerCallbackQuery);
                }
            } else {
                FieldType fieldType = fieldTypes[Integer.parseInt(data)];
                generateDataRequest.get(chatID).getFields().add(new Field(fieldType.name().toLowerCase(), fieldType, 0, 0));
            }
        }
    }

    private Keyboard getInlineMarkupKeyboard() {
        FieldType[] fieldTypes = FieldType.values();
        InlineKeyboardButton[][] buttons = new InlineKeyboardButton[12][2];
        for ( int i = 0; i < fieldTypes.length / 2; i++ ) {
            InlineKeyboardButton button1 = new InlineKeyboardButton(fieldTypes[i * 2].name());
            InlineKeyboardButton button2 = new InlineKeyboardButton(fieldTypes[i * 2 + 1].name());
            button1.callbackData("" + i * 2);
            button2.callbackData("" + ( i * 2 + 1 ));
            buttons[i][0] = button1;
            buttons[i][1] = button2;
        }
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup(buttons);
        InlineKeyboardButton generate = new InlineKeyboardButton("✅ Generate");
        generate.callbackData("g");
        inlineKeyboardMarkup.addRow(generate);
        return inlineKeyboardMarkup;
    }
}

enum State {
    FILE_NAME,
    ROW_COUNT,
    FIELDS
}
````

