package practicing.io.function;

import java.io.IOException;
import java.nio.file.*;

public class InputProcessor {
    public InputProcessor(){}

    public String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }
}
