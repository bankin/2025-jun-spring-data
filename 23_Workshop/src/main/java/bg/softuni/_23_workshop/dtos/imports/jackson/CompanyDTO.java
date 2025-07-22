package bg.softuni._23_workshop.dtos.imports.jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public record CompanyDTO(
    @JacksonXmlProperty(isAttribute = true) String name) {
}
