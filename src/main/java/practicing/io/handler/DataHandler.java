package practicing.io.handler;

import lombok.extern.slf4j.Slf4j;
import practicing.io.function.utils.PathHelper;
import practicing.io.function.utils.RegexHelper;
import practicing.io.function.InputProcessor;
import practicing.io.function.OutputProcessor;
import practicing.io.function.model.Input;
import practicing.io.function.model.Output;
import practicing.io.service.UnmarshallService;
import practicing.io.function.DataMapper;

import javax.inject.Inject;
import java.util.Map;

@Slf4j
public class DataHandler {
    private String outputFilePath;
    @Inject
    private InputProcessor inputProcessor;
    @Inject
    private OutputProcessor outputProcessor;
    @Inject
    private DataMapper dataMapper;
    @Inject
    private Map<String, UnmarshallService> unmarshallServiceMap;

    public DataHandler(){
        outputFilePath = "C:/Users/t.norba/IdeaProjects/test-project-1/src/main/resources/output.txt";
    }

    public void handle(String fileName) throws Exception {
        String filePath = PathHelper.generatePathByFileName(fileName);
        String readInput = inputProcessor.readFile(filePath);
        String fileExtension = RegexHelper.getFileExtensionFromFileName(fileName);

        UnmarshallService mapService = unmarshallServiceMap.get(fileExtension);
        Input parsedInput = mapService.unmarshall(readInput, Input.class);
        log.info("Received input {}", readInput);

        Output mappedObject = dataMapper.map(parsedInput);

        String marshalledOutput = mapService.marshall(mappedObject);
        log.debug("Mapped output {}", marshalledOutput);

        outputProcessor.writeFile(outputFilePath, marshalledOutput);
    }
}
