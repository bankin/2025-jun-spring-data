package bg.softuni._23_workshop.dtos.imports;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCompanyDTO {
    @XmlAttribute
    private String name;

    public ImportCompanyDTO() {}

    public String getName() {
        return name;
    }
}
