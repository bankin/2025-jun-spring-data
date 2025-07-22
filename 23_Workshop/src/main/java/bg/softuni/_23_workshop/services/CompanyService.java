package bg.softuni._23_workshop.services;

import bg.softuni._23_workshop.dtos.imports.ImportRootCompanyDTO;
import bg.softuni._23_workshop.dtos.imports.jackson.RootCompanyDTO;
import bg.softuni._23_workshop.repositories.CompanyRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CompanyService {
    private final Path IMPORT_XML_FILE_PATH = Path.of("src/main/resources/files/xmls/companies.xml");

    private final Unmarshaller importParser;
    private final CompanyRepository companyRepository;
    private final XmlMapper xmlMapper;

    public CompanyService(
            @Qualifier("importCompany") Unmarshaller importParser,
            CompanyRepository companyRepository,
            XmlMapper xmlMapper
    ) {
        this.importParser = importParser;
        this.companyRepository = companyRepository;
        this.xmlMapper = xmlMapper;
    }

    public boolean isDataImported() {
        return this.companyRepository.count() > 0;
    }

    public String getXmlContent() throws IOException {
        List<String> lines = Files.readAllLines(IMPORT_XML_FILE_PATH);

        return String.join("\n", lines);
    }

    public boolean importData() throws IOException, JAXBException {
        InputStream inputStream = Files.newInputStream(IMPORT_XML_FILE_PATH);
        ImportRootCompanyDTO parsed = (ImportRootCompanyDTO) this.importParser
                .unmarshal(inputStream);

        RootCompanyDTO rootCompanyDTO = this.xmlMapper.readValue(inputStream, RootCompanyDTO.class);

//        List<ImportCompanyDTO> toImport = parsed.getCompanies();
//
//        boolean atLeastOneImported = false;
//        for (ImportCompanyDTO importCompanyDTO : toImport) {
//            if (importCompanyDTO.getName() == null || importCompanyDTO.getName().length() == 0) {
//                System.out.println("Missing company name");
//                continue;
//            }
//
//            Company company = new Company(importCompanyDTO.getName());
//            this.companyRepository.save(company);
//            atLeastOneImported = true;
//        }

        return false;
    }


}
