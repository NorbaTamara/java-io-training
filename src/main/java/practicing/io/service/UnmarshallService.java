package practicing.io.service;

import jakarta.xml.bind.JAXBException;

public interface UnmarshallService {
    <T> T unmarshall(String stringToUnmarshall, Class<T> type);
    <T> T marshall(Object objectToMarshall);
}
