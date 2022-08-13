package practicing.io.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import practicing.io.handler.DataHandler;
import practicing.io.function.model.Output;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlUnmarshallService implements UnmarshallService {

    private DocumentBuilderFactory documentBuilderFactory;

    XmlUnmarshallService(){
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
    }

    @Override
    public <T> T unmarshall(String stringToUnmarshall, Class<T> type) {
        try{
            //security?
            documentBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            JAXBContext jaxbInputContext = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = jaxbInputContext.createUnmarshaller();

            StringBuffer xmlStringBuffer = new StringBuffer(stringToUnmarshall);
            T unmarshalled = (T) unmarshaller.unmarshal(  new StringReader( xmlStringBuffer.toString() ) );
            return unmarshalled;


        } catch (ParserConfigurationException e) {
            // think about exceptions
            throw new RuntimeException(e.getMessage());
        } catch (JAXBException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String marshall(Object objectToMarshall) {
      try {
            JAXBContext jc = JAXBContext.newInstance( Output.class );
            Marshaller m = jc.createMarshaller();

            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
            Document doc = db.newDocument();

            StringWriter stringWriter = new StringWriter();
            m.marshal( objectToMarshall, stringWriter );

            return stringWriter.toString();
    }

      catch (ParserConfigurationException e) {
          // think about exceptions
          throw new RuntimeException(e.getMessage());
        } catch (JAXBException e) {
          throw new RuntimeException(e.getMessage());
        }
    }
}
