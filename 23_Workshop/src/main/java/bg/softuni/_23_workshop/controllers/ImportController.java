package bg.softuni._23_workshop.controllers;

import bg.softuni._23_workshop.services.CompanyService;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ImportController {

    private final CompanyService companyService;

    public ImportController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("import/xml")
    public ModelAndView importHome() {
        boolean[] areImported = {
                this.companyService.isDataImported(),
                false,
                false
        };

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("xml/import-xml");
        modelAndView.addObject("areImported", areImported);

        return modelAndView;
    }

    @GetMapping("import/companies")
    public ModelAndView importCompaniesView() throws IOException {
        String companiesXmlContent = companyService.getXmlContent();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("xml/import-companies");
        modelAndView.addObject("companies", companiesXmlContent);

        return modelAndView;
    }

    @PostMapping("import/companies")
    public String doImportCompanies() throws IOException, JAXBException {
        boolean success = companyService.importData();

        if (!success) {
            return "redirect:/import/companies";
        }

        return "redirect:/import/xml";
    }
}
