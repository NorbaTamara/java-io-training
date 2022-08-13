package practicing.io.function.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name="data")
@Getter
@Setter
@NoArgsConstructor
public class Input implements Serializable {
    private int id;
    private String name;
    private List<String> additional = new ArrayList<>();
}
