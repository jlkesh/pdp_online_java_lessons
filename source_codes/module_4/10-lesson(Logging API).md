
````java
package uz.pdp.logging;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SimpleLoggingExample {
    static {
        String file = SimpleLoggingExample.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", file);
    }

    private static Logger logger = Logger.getLogger("MyLogger");

    public static void main(String[] args) throws IOException {
        LogRecord logRecord = new LogRecord(Level.INFO, "Hello this is simple warning log");
        logger.log(logRecord);

    }
}
````


````java
package uz.pdp.logging;

import uz.pdp.logging.a.A;

import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelegramAlarmExample {

    static {
        String file = TelegramAlarmExample.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", file);
    }

    private static Logger logger = Logger.getLogger(TelegramAlarmExample.class.getSimpleName());

    public static void main(String[] args) {
        try {
            if ( new Random().nextBoolean() )
                throw new RuntimeException("Runtime Exception For alarm testing");
            else new A().a();
        } catch (RuntimeException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Error Message For Telegram", e);
        }
    }
}
````


````java
package uz.pdp.logging;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class TelegramAlarmFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return record.getLevel().intValue() == Level.SEVERE.intValue();
    }
}
````


````java
package uz.pdp.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class TelegramAlarmFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        String stackTrace = "\n";
        Throwable thrown = record.getThrown();
        if ( thrown != null ) {
            StringWriter out = new StringWriter();
            PrintWriter printWriter = new PrintWriter(out);
            thrown.printStackTrace(printWriter);
            stackTrace += out.toString();
        }
        return "%s :: [%d] :: %s :: [%s] %s".
                formatted(record.getLevel(),
                        record.getLongThreadID(),
                        record.getLoggerName(),
                        record.getMessage(),
                        stackTrace);
    }
}
````
````java
package uz.pdp.logging;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class TelegramAlarmHandler extends StreamHandler {
    public TelegramAlarmHandler() {
        super.setFilter(new TelegramAlarmFilter());
        super.setFormatter(new TelegramAlarmFormatter());
    }

    @Override
    public synchronized void publish(LogRecord record) {
        if ( isLoggable(record) ) {
            try {
                String formattedMEssage = getFormatter().format(record);
                String bodyMessage = """
                        {
                            "chat_id":"%s",
                            "text":"%s"
                        }""".formatted(Secrets.chatId, formattedMEssage);

                HttpClient httpClient = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(bodyMessage))
                        .uri(URI.create(Secrets.sendMessage))
                        .header("Content-Type", "application/json")
                        .build();
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return getFilter().isLoggable(record);
    }
}
````
````java
package uz.pdp.logging;

public class Secrets {
    public static String token = "bot_token";
    public static String chatId = "chat_id";
    // updates => https://api.telegram.org/botBOT_TOKEN/getUpdates
    public static String sendMessage = "https://api.telegram.org/bot5977319195:AAFSjV2l_6KBuJ5XLmn3WWFPzHSVRNzjfK8/sendMessage";
}
````


````java
package uz.pdp.logging.a;

import uz.pdp.logging.a.b.B;

public class A {
    public void a(){
        new B().b();
    }
}
````
````java
package uz.pdp.logging.a.b;

public class B {
    public void b() {
        System.out.println(12 / 0);
    }
}
````