### javafaker
````
 <dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
````
### lombok 
````
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>compile</scope>
</dependency>
````
### Seeder Application
````java
@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"fieldName", "fieldType"})
public class Field {
private final String fieldName;
private final FieldType fieldType;
private final BiFunction<Integer, Integer, Object> func;
private int min;
private int max;

    public Field(String fieldName, FieldType fieldType, int min, int max) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.func = FakerApplicationService.functions.get(fieldType);
        this.min = min;
        this.max = max;
    }

    public String getPatternAsJson() {
        return fieldType.getRowAsJson(fieldName, func.apply(min, max));
    }

    @Override
    public String toString() {
        return "\033[1;92m%s : %s \033[0m\n".formatted(fieldName, fieldType.name());
    }
}
````

````java
public enum FieldType {
    ID(""),
    UUID("\""),
    BOOK_TITLE("\""),
    BOOT_AUTHOR("\""),
    POST_TITLE("\""),
    POST_BODY("\""),
    FIRSTNAME("\""),
    LASTNAME("\""),
    USERNAME("\""),
    FULLNAME("\""),
    BLOOD_GROUP("\""),
    EMAIL("\""),
    GENDER("\""),
    PHONE("\""),
    LOCAlDATE("\""),
    AGE(""),
    COUNTRY_CODE("\""),
    COUNTRY_ZIP_CODE("\""),
    CAPITAL("\""),
    WORD("\""),
    WORDS("\""),
    PARAGRAPH("\""),
    PARAGRAPHS("\""),
    LETTERS("\""),
    RANDOM_INT("");

    private final String i;

    FieldType(String i) {
        this.i = i;
    }
    
    public String getRowAsJson(String fieldName, Object data) {
        return ( "\"" + fieldName + "\" : " + i + data + i );
    }
}
````
````java
public enum FileType {
    JSON,
    CSV, 
    SQL;
    public static FileType findByName(String name) {
        for ( FileType fileType : values() )
            if ( fileType.name().equalsIgnoreCase(name) )
                return fileType;
        return FileType.JSON;
    }
}
````
````java
public class FakerApplicationService {

    private static final Scanner scanner = new Scanner(System.in);
    private static final AtomicLong id = new AtomicLong(1);
    private static final Faker faker = new Faker();
    private static final Country country = faker.country();
    private static final Address address = faker.address();
    private static final Book book = faker.book();
    private static final Name name = faker.name();
    private static final Lorem lorem = faker.lorem();
    private static final RandomService random = faker.random();
    private static final PhoneNumber phoneNumber = faker.phoneNumber();
    
    public static final Map<FieldType, BiFunction<Integer, Integer, Object>> functions = new HashMap<>() {{
        put(ID, (a, b) -> id.incrementAndGet());
        put(UUID, (a, b) -> java.util.UUID.randomUUID());
        put(BOOK_TITLE, (a, b) -> book.title());
        put(BOOT_AUTHOR, (a, b) -> book.author());
        put(POST_TITLE, (a, b) -> String.join(" ", lorem.words(random.nextInt(a, b))));
        put(POST_BODY, (a, b) -> String.join("", lorem.paragraphs(random.nextInt(a, b))));
        put(FIRSTNAME, (a, b) -> name.firstName());
        put(LASTNAME, (a, b) -> name.lastName());
        put(USERNAME, (a, b) -> name.username());
        put(FULLNAME, (a, b) -> name.fullName());
        put(BLOOD_GROUP, (a, b) -> name.bloodGroup());
        put(EMAIL, (a, b) -> name.username() + "@" + ( random.nextBoolean() ? "gmail.com" : "mail.ru" ));
        put(GENDER, (a, b) -> random.nextBoolean() ? "MALE" : "FEMALE");
        put(PHONE, (a, b) -> phoneNumber.cellPhone());
        put(LOCAlDATE, (a, b) -> {
            int year = random.nextInt(1900, Year.now().getValue() - 1);
            int month = random.nextInt(1, 12);
            YearMonth yearMonth = YearMonth.of(year, month);
            int day = random.nextInt(1, yearMonth.getMonth().length(yearMonth.isLeapYear()));
            return LocalDate.of(year, month, day);
        });
        put(COUNTRY_CODE, (a, b) -> country.countryCode3());
        put(COUNTRY_ZIP_CODE, (a, b) -> address.zipCode());
        put(CAPITAL, (a, b) -> country.capital());
        put(WORD, (a, b) -> lorem.word());
        put(WORDS, (a, b) -> lorem.words(random.nextInt(a, b)));
        put(PARAGRAPH, (a, b) -> lorem.paragraph());
        put(PARAGRAPHS, (a, b) -> lorem.paragraphs(random.nextInt(a, b)));
        put(AGE, random :: nextInt);
        put(RANDOM_INT, random :: nextInt);
        put(LETTERS, (a, b) -> lorem.characters(a, b, true));
    }};

    public static final List<FieldType> BLACK_LIST = List.of(AGE, WORDS, PARAGRAPHS, RANDOM_INT, POST_TITLE, POST_BODY, LETTERS);

    public String processRequest(FakerApplicationGenerateRequest fakerApplicationGenerateRequest) {
        var fileType = fakerApplicationGenerateRequest.getFileType();
        var fileName = fakerApplicationGenerateRequest.getFileName() + "." + fileType.name().toLowerCase();
        var rowsCount = fakerApplicationGenerateRequest.getCount();
        var fields = fakerApplicationGenerateRequest.getFields();
        return switch ( fileType ) {
            case JSON -> generateDataAsJson(rowsCount, fileName, fields);
            case CSV -> "Not Supported";
            case SQL -> "Not Supported";
        };
    }


    private String generateDataAsJson(int rowsCount, String fileName, Set<Field> fields) {
        synchronized (FakerApplicationService.class){
            var result = new StringJoiner(",\n", "[", "]");
            for ( int i = 0; i < rowsCount; i++ ) {
                var row = new StringJoiner(", ", "{", "}");
                for ( Field field : fields )
                    row.add(field.getPatternAsJson());
                result.add(row.toString());
            }
            Path path = Path.of(fileName);
            try {
                if ( Files.notExists(path) )
                    Files.createFile(path);
                Files.writeString(path, result.toString(), StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return path.toAbsolutePath().toString();
        }
    }
}
````

````java
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakerApplicationGenerateRequest {
    private String fileName;
    private FileType fileType;
    private int count;
    @Builder.Default
    private Set<Field> fields = new HashSet<>();
}
````

````java
public class FakerApplicationRunner {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scannerInt = new Scanner(System.in);
    private static final Pattern validFieldNamePattern = Pattern.compile("^[a-zA-Z_]+\\d*");
    private static final Pattern validFileNamePattern = Pattern.compile("^([a-zA-Z_]+[0-9]*)$");
    private static final List<FieldType> fields = Collections.synchronizedList(new ArrayList<>());
    private static final int fieldsCount;

    static {
        fields.add(null);
        fields.addAll(Arrays.asList(FieldType.values()));
        fieldsCount = fields.size();
    }


    public static void main(String[] args) {
        var fakerDataGeneratorService = new FakerApplicationService();
        var builder = FakerApplicationGenerateRequest.builder();
        builder.fileName(getValidatedFileName());
        builder.fileType(getValidFileType());
        builder.count(getValidRowCount());
        Set<Field> dataFields = new HashSet<>();
        var choice = "";
        while ( !choice.startsWith("s") ) {
            String fieldName = getValidatedFieldName();
            showFieldTypes();
            FieldType fieldType = getValidatedFieldType();
            int min = 0;
            int max = 0;
            if ( BLACK_LIST.contains(fieldType) ) {
                System.out.print(fieldName + " min value = ");
                min = scannerInt.nextInt();
                System.out.print(fieldName + " max value = ");
                max = scannerInt.nextInt();
            }
            var field = new Field(fieldName, fieldType, min, max);
            dataFields.add(field);
            System.out.println(String.join("", dataFields.stream().map(Field :: toString).toList()));
            System.out.println("Add Field -> y(es)");
            System.out.println("Stop Adding Fields -> s(top)");
            choice = scanner.nextLine();
        }
        builder.fields(dataFields);
        var response = fakerDataGeneratorService.processRequest(builder.build());
        System.out.println(response);
    }

    private static int getValidRowCount() {
        System.out.print("Enter Rows Count : ");
        try {
            int rowCount = Integer.parseInt(scanner.nextLine());
            if ( rowCount < 0 || rowCount > 1_000_000 )
                throw new InputMismatchException();
            return rowCount;
        } catch (InputMismatchException e) {
            System.out.println("Row Count is Invalid");
            return getValidRowCount();
        }
    }

    /**
     * @return if not match to any variant returns
     * {@link  dev.jlkesh.seeder.FileType#JSON};
     */
    private static FileType getValidFileType() {
        System.out.print("Enter File Type (JSON, CSV, SQL) : ");
        return FileType.findByName(scanner.nextLine());
    }

    private static String getValidatedFileName() {
        System.out.print("Enter File Name : ");
        String nextLine = scanner.nextLine();
        Matcher matcher = validFileNamePattern.matcher(nextLine);
        if ( !matcher.matches() ) {
            System.out.printf("File Name Is Not Valid : '%s'%n", nextLine);
            return getValidatedFileName();
        }
        return nextLine;
    }

    private static FieldType getValidatedFieldType() {
        System.out.printf("\nEnter Field Type ID(1-%d) : ", fieldsCount);
        String nextLine = scanner.nextLine();
        try {
            var fieldTypeIndex = Integer.parseInt(nextLine);
            if ( fieldTypeIndex < 1 || fieldTypeIndex > fieldsCount )
                throw new InputMismatchException();
            return fields.get(fieldTypeIndex);
        } catch (InputMismatchException e) {
            System.out.printf("Input must be a number and must be between[1-%d%n]", fieldsCount);
            return getValidatedFieldType();
        }
    }

    private static String getValidatedFieldName() {
        System.out.print("Enter Field Name : ");
        var fieldName = scanner.nextLine();
        Matcher matcher = validFieldNamePattern.matcher(fieldName);
        if ( !matcher.matches() ) {
            System.out.println("Invalid Field Name");
            return getValidatedFieldName();
        }
        return fieldName;
    }

    private static void showFieldTypes() {
        int i = 1;
        for ( FieldType fieldType : FieldType.values() ) {
            System.out.printf("%2d.%-20s", i, fieldType);
            if ( i % 2 == 0 )
                System.out.println();
            i++;
        }
    }
}
````