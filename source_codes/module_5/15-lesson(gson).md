### test uchun json ma'lumotlar ni [bu yerdan](https://github.com/jlkesh/pdp_online_java_lessons/blob/main/jars/Books.json) olasiz 

````java
@Data
@Builder
public class Book {

    @Expose
    @SerializedName("id")
    private Integer bookId;

    @Expose(deserialize = false)
    @SerializedName("title")
    protected String bookTitle;

    @Expose
    @SerializedName("author")
    private String bookAuthor;

    @Since(1.0)
    @Expose
    private volatile Date bookDate;
    @Expose
    private LocalDate publishedDate;
}
````
````java
public class LocalDateSerializer implements JsonSerializer<LocalDate> {
    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}
````

````java
public class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String locadateAsString = json.getAsString();
        return LocalDate.parse(locadateAsString);
    }
}
````

````java
public class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {
    @Override
    public void write(JsonWriter out, LocalDate value) throws IOException {
        if ( value == null )
            out.nullValue();
        else
            out.value(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        if ( in.peek() == JsonToken.NULL )
            return null;
        else
            return LocalDate.parse(in.nextString());
    }
}
````

````java
public class Main {
    private static String booksListAsStringJSON;

    static {
        try {
            String file = Main.class.getClassLoader().getResource("Books.json").getFile();
            booksListAsStringJSON = Files.readString(Path.of(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello PDP!");
        // defaultConfiguration();
        Gson gson = new GsonBuilder()
                //.registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                //.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .serializeNulls()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CASE_WITH_UNDERSCORES)
                // .excludeFieldsWithoutExposeAnnotation()
                // .excludeFieldsWithModifiers(Modifier.VOLATILE, Modifier.PROTECTED)
                .setVersion(1.2)
                .create();

        Stream.generate(UUID ::randomUUID).limit(50).forEach(System.out::println);


        Book book = Book.builder()
                .bookId(1)
                .bookTitle("Reactive Spring")
                .bookAuthor("Josh Long")
                .publishedDate(LocalDate.of(2021, 1, 1))
                .build();

        String jsonDATA = gson.toJson(book);
        System.out.println(jsonDATA);
        Book fromJson = gson.fromJson(jsonDATA, Book.class);
        System.out.println(fromJson);

    }

    private static void cuntomConfiguration(Gson gson) {
        Type type = new TypeToken<List<Book>>() {
        }.getType();
        List<Book> books = gson.fromJson(booksListAsStringJSON, type);
        books.forEach(System.err :: println);
    }

    private static void defaultConfiguration() {
        Gson gson = new Gson();
        Book book = Book.builder()
                .bookId(1)
                .bookTitle("Reactive Spring")
                .bookAuthor("Josh Long")
                //.publishedDate(LocalDate.of(2021, 1, 1))
                .build();
        String jsonDATA = gson.toJson(book);
        String jsonDATA2 = "{\"id\":1,\"title\":\"Reactive Spring\",\"author\":\"Josh Long\"}";
        System.out.println(jsonDATA);
        Book fromJsonBook = gson.fromJson(jsonDATA2, Book.class);
        System.out.println(fromJsonBook);
        // System.out.println(booksListAsStringJSON);
        Type type = new TypeToken<List<Book>>() {
        }.getType();
        List<Book> books = gson.fromJson(booksListAsStringJSON, type);
        books.forEach(System.err :: println);
    }
}
````
