package practicing.io.function.utils;

public class PathHelper {
    private static final String basePath = "C:/Users/t.norba/IdeaProjects/test-project-1/src/main/resources/input/";
    public static String generatePathByFileName(String fileName){
        return basePath + fileName;
    }
}
