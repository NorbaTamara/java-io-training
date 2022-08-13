package practicing.io.function.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "root")
@Getter
@Setter
@NoArgsConstructor
public class Output {
    private String id;
    private String name;
    private String status;
    private List<String> features = new ArrayList<>();
}
