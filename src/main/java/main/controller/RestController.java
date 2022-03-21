package main.controller;

import main.entity.Case;
import main.service.CaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final CaseService caseService;

    public RestController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping("/cases")
    public List<Case> getAllCases() {
        return caseService.getAllCases();
    }

    @GetMapping("/cases/{id}")
    public Case getCase(@PathVariable int id) {
        return caseService.getCase(id);
    }

    @PostMapping("/cases")
    public void addNewCase(@Valid @RequestBody Case c, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("input error");
            return;
        }
        c.setDate(new Date());
        caseService.addNewCase(c);
    }

    @PostMapping("/cases/{id}")
    public ResponseEntity addNewCaseForId(@PathVariable int id) {
        return ResponseEntity.badRequest().body(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PutMapping("/cases")
    public void updateCase(@RequestBody Case c) {
        caseService.updateCase(c);
    }


    @DeleteMapping("/cases")
    public void deleteAllCases() {
        caseService.deleteAllCases();
    }

    @DeleteMapping("/cases/{id}")
    public void deleteCase(@PathVariable int id) {
        caseService.deleteCase(id);
    }
}
