#### Ma'lumot yaratib olish uchun
````shell
java -jar seeder.jar
````
#### Bun esa server application [bu yerdan](https://github.com/jlkesh/pdp_online_java_lessons/blob/main/jars/demo_for_httclient-0.0.1-SNAPSHOT.jar) uni yuklab olib quyidagi command bilan iwga tushirish kerak
````shell
java -jar demo_for_httclient-0.0.1-SNAPSHOT.jar
````


### APIs
* **username : user** 
* **password : password**
----
* BASE_URL = http://localhost:8080
* (GET) - /current-time
* (GET) - /posts/
* (DELETE , requires auth) - /post/delete/{id}
* (UPDATE , requires auth) - /post/update/
* (POST) - /post/create/
* (GET) - /timeout/request/
* (GET) - /file/upload/?file=filename

````java
public class UrlAndUrlConnectionExample {
    public static void main(String[] args) throws IOException, Exception {
        URL url = new URL("https://kun.uz");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
        while ( scanner.hasNextLine() ) {
            System.out.println(scanner.nextLine());
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}
````

````java
public class Post {

    @Expose
    private String body;
    @Expose
    private String createdAt;
    @Expose
    private String id;
    @Expose
    private String title;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "body='" + body + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
````

````java
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Base64;
import java.util.List;

public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = HttpClient.newBuilder()
                /*.authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("user", "password".toCharArray());
                    }
                })*/
                .build();

        // simpleGetRequest(httpClient);
        // simplePostRequest(httpClient);
        // simpleTimeoutRequest(httpClient);

        //
        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create("http://localhost:8080/post/delete/9d989ca2-9bc8-4bc0-bb85-02145d0562b0"))
                .DELETE()
                .headers("Authorization","Basic "+ Base64.getEncoder().encodeToString("user:password".getBytes()))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse);
        System.out.println(httpResponse.body());
    }

    private static void simpleTimeoutRequest(HttpClient httpClient) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create("http://localhost:8080/timeout/request/"))
                .GET()
                .timeout(Duration.ofSeconds(1))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse);
        System.out.println(httpResponse.body());
    }

    private static void simplePostRequest(HttpClient httpClient) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create("http://localhost:8080/post/create/"))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("""
                        {
                            "id":"123qwsdfwe3141rfdsfdsf132",
                            "body": "Maxime dolor qui ex. Occaecati odio eligendi laudantium cupiditate rerum dicta id. Quidem ipsum fugiat et eos. Omnis qui est cupiditate sed quaerat nihil.Delectus ut eaque culpa non vel provident illo. Quaerat autem qui in veritatis consequatur. Ut enim ad et qui et in. Nemo voluptatem architecto. Error voluptas eum illo aut qui accusantium.Et quas ipsa qui sit. Tenetur inventore sit et omnis quia voluptate. Enim odit unde. Aperiam ut praesentium. Sunt officiis et qui.Facilis consequatur dolorem. Perferendis magni voluptas nihil. Aut voluptatum ut itaque.Unde harum modi saepe quae numquam in. Facere ducimus rerum eius dolorem ea. Laboriosam hic labore.Molestias explicabo fugiat sed. Perferendis accusantium consequatur ut sequi et omnis. Odio consectetur aut voluptatem possimus error eius.Alias nihil omnis exercitationem. Laborum aut quia ea et consequuntur nobis perspiciatis. Ut labore doloremque temporibus occaecati et sequi perspiciatis. Voluptas quo excepturi dolore saepe voluptatem iusto.",
                            "title": "voluptatemdolorab"
                          }"""))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse);
        System.out.println(httpResponse.body());
    }

    private static void simpleGetRequest(HttpClient httpClient) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                //.newBuilder(URI.create("http://localhost:8080/current-time"))
                .newBuilder(URI.create("http://localhost:8080/posts/"))
                .GET()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.uri());
        System.out.println(httpResponse.version());
        System.out.println(httpResponse.statusCode());
        String body = httpResponse.body();
        Type type = TypeToken.getParameterized(List.class, Post.class).getType();
        Gson gson = new Gson();
        List<Post> posts = gson.fromJson(body, type);
        posts.forEach(System.out :: println);
    }
}
    
````
