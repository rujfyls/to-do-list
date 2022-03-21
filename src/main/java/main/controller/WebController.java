package main.controller;

import main.entity.Case;
import main.service.CaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class WebController {

    private final CaseService caseService;

    public WebController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cases", caseService.getAllCases());
        return "index";
    }

    @GetMapping("/addCase")
    public String addNewCase(Model model) {
        Case c = new Case();
        model.addAttribute("case", c);
        return "caseInfo";
    }

    @PostMapping("/addCase")
    public String saveNewCase(@ModelAttribute("case") Case c) {
        c.setDate(new Date());
        caseService.addNewCase(c);
        return "redirect:/";
    }

    @PostMapping("/caseUpdateToEdit")
    public String empUpdateEdit(@ModelAttribute("case") Case c) {
        return "caseInfo";
    }

    @PostMapping("/deleteCase")
    public String deleteCase(@ModelAttribute("case") Case c) {
        caseService.deleteCase(c.getId());
        return "redirect:/";
    }
}
