import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Sample {
    public static void main(String... args) {
        String s = "localhost";
        String path = "/etc/hosts";

        try {
            long count = Files.lines(Paths.get(path))
                    .filter(line -> line.contains(s))
                    .count();

            System.out.println("Word " + s + " occurred " + count + " times");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
