package practicing.io;

import com.google.inject.Guice;
import com.google.inject.Injector;
import practicing.io.service.InputDialogue.Dialogue;
import practicing.io.config.DataIOModule;
import practicing.io.handler.DataHandler;

// check all exceptions
// add constant file
// add lombok +-
// add logs +-
// solve marshall for xml format and remove kostyl'
// replace new to inject +-
// solve news in xml marshaller
// remove or refactor Output processor and write marshalled value to a file directly
// add versions in pom to properties

public class App {
    public static void main( String[] args ) throws Exception {
        Injector injector = Guice.createInjector(new DataIOModule());
        DataHandler dataHandler = injector.getInstance(DataHandler.class);

        dataHandler.handle(Dialogue.readFileNameFromInput());
    }
}

//we can add external classes by guice ? (eg. not ObjectMapper of jackson)
//logs in lambdas
//context? Sow it in number of classes
//new that we should use in the method
//importance of no args constructor annotation
