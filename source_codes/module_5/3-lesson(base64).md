````java
import java.io.IOException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        // simpleBase64();
        // urlBase64();
        // mimeBase64();
    }

    private static void simpleBase64() throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encode = encoder.encode("hello".getBytes());
        System.out.println(new String(encode));
        System.out.println(new String(decoder.decode(encode)));
        /*
        byte[] bytes = Files.readAllBytes(Path.of("1.mp3"));
        Files.writeString(Path.of("1.txt"), encoder.encodeToString(bytes));
        */
        /*
        String data = Files.readString(Path.of("1.txt"));
        Files.write(Path.of("1.mp3"), decoder.decode(data));
        */
    }

    private static void mimeBase64() {
        Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
        Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
        String data = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores et facere incidunt modi molestiae molestias odio officiis optio perspiciatis porro, quam quisquam vero voluptate. A commodi cupiditate deserunt ea est fugit ipsam ipsum molestias nam natus officiis porro possimus, provident saepe, suscipit ullam unde. At aut culpa eaque illum impedit ipsum nisi odio omnis, provident repellat rerum sint unde veniam! Consectetur cumque delectus fuga in perspiciatis quasi quidem quod repellendus saepe soluta. Accusamus aliquid architecto at doloremque earum explicabo facilis, fugiat inventore iure libero magnam nostrum perferendis, reiciendis sit tenetur unde vel. Atque eius nesciunt praesentium quibusdam quidem repudiandae voluptatibus. A aliquid asperiores commodi consequatur dignissimos doloribus eaque enim eos eum harum laudantium, minus mollitia natus non obcaecati odio omnis pariatur perspiciatis quae quia quidem quisquam reprehenderit saepe sit temporibus, unde velit veniam! Commodi eius enim nobis optio voluptatum. Ad aut, commodi excepturi facilis minima, pariatur perferendis quibusdam quidem recusandae sed sunt tempore voluptates? A beatae cupiditate dicta ducimus eius et incidunt, ipsam molestiae necessitatibus omnis quo quod sed soluta tenetur ullam, velit vero voluptatum. Ab aliquid architecto blanditiis culpa deserunt dicta, ea eligendi ex modi molestiae, nam nesciunt quisquam repellat repellendus saepe? A ad aliquam amet, at cum esse exercitationem fugiat harum incidunt ipsam maxime nulla omnis perferendis perspiciatis porro, possimus quam quidem rerum tempore, tenetur unde vitae voluptatem. Laboriosam nobis obcaecati praesentium! Dolores ducimus eligendi eos ipsa iure necessitatibus nesciunt omnis quaerat reiciendis vero! A architecto beatae cum dolores inventore maxime porro, repudiandae vel? Deleniti dignissimos illo molestiae provident vel veniam veritatis voluptate voluptatum. Architecto consequatur esse hic in inventore laborum maxime nam, nesciunt nobis tempora! Ad aliquam dicta in iure molestias nulla obcaecati officia, quae quas sunt? Accusamus accusantium, alias atque aut commodi consequatur cum deleniti dolore est eum fuga impedit in minima nemo officiis optio possimus.";
        String encodeToString = mimeEncoder.encodeToString(data.getBytes());
        System.out.println(encodeToString);
        System.out.println(new String(mimeDecoder.decode(encodeToString)));
    }

    private static void urlBase64() {
        Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        String encodeToString = urlEncoder.encodeToString("\"a?".getBytes());
        System.out.println(encodeToString);
        System.out.println(new String(urlDecoder.decode(encodeToString)));
    }
}

````