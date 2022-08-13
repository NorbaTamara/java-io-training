package practicing.io.function;

import practicing.io.function.utils.UuidGenerator;
import practicing.io.function.model.Input;
import practicing.io.function.model.Output;

import java.util.List;
import java.util.stream.Collectors;

public class DataMapper {
    private Output outputObject;

    public DataMapper(){
        outputObject = new Output();
    }
    public Output map(Input inputObject) {
        // add exception to check if data to map is correct
        outputObject.setId(UuidGenerator.generateUuid());
        outputObject.setName(inputObject.getName());
        // save mapped as constants
        outputObject.setStatus("MAPPED");
        List<String> additionals = inputObject.getAdditional().stream().filter(add -> add.contains("1"))
                .map(add -> add.toUpperCase() + " Updated").collect(Collectors.toList());
        outputObject.setFeatures(additionals);
        return outputObject;
    };
};
