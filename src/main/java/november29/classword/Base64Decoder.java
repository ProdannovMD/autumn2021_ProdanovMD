package november29.classword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64Decoder {

    public static void decode(Path inputPath, Path outputPath) throws IOException {
        byte[] bytes = Files.readAllBytes(inputPath);
        byte[] decoded = Base64.getDecoder().decode(bytes);
        Files.write(outputPath, decoded);
    }

    public static void decodeBulk(Path inputPath, Path outputPath) throws IOException {
        Files.list(outputPath).forEach(path -> {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Files.walk(inputPath).forEach(
                path -> {
                    if (Files.isRegularFile(path)) {
                        Path output = outputPath.resolve(path.getFileName() + ".png");
                        try {
                            decode(path, output);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

    public static void main(String[] args) {
        try {
            decodeBulk(
                    Paths.get("src/main/resources/november29/input"),
                    Paths.get("src/main/resources/november29/output")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
