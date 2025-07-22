package bg.softuni._23_workshop.config;

import bg.softuni._23_workshop.dtos.ImportRootProjectDTO;
import bg.softuni._23_workshop.dtos.imports.ImportRootCompanyDTO;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfiguration {

    @Bean
    public XmlMapper getMapper() {
        return new XmlMapper();
    }

    @Bean("importCompany")
    public Unmarshaller getCompanyUnmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ImportRootCompanyDTO.class);
        return jaxbContext.createUnmarshaller();
    }

    @Bean("importProject")
    public Unmarshaller getProjectUnmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ImportRootProjectDTO.class);
        return jaxbContext.createUnmarshaller();
    }
}
