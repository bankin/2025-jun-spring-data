package bg.softuni._23_workshop.controllers;


import bg.softuni._23_workshop.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final CompanyService companyService;

    public HomeController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        boolean areImported = companyService.isDataImported();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("areImported", areImported);

        return modelAndView;
    }

    @GetMapping("/helloWorld")
    public String indexPage() {
        return "hello";
    }

    @GetMapping("/world")
    public String worldPage() {
        return "world";
    }
}
