package bg.softuni._23_workshop.dtos.imports;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "companies")
public class ImportRootCompanyDTO {

    @XmlElement(name = "company")
    private List<ImportCompanyDTO> companies;

    public ImportRootCompanyDTO() {}

    public List<ImportCompanyDTO> getCompanies() {
        return companies;
    }
}
