package practicing.io.function;

import java.io.IOException;
import java.nio.file.*;

public class OutputProcessor {
    public void writeFile(String filePath, CharSequence content) throws IOException {
        Path path = Paths.get(filePath);
        Files.writeString(path, content);
    }
}
