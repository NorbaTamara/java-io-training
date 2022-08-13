package practicing.io.function.utils;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexHelper {
    public static String getFileExtensionFromFileName(String fileName){
        // add validation format of the file name
        Pattern pattern = Pattern.compile("\\..*");
        List regexResult = pattern.matcher(fileName)
                .results()
                .map(mr -> mr.group(0).substring(1))
                .collect(Collectors.toList());
        return (String) regexResult.get(0);
    }
}
