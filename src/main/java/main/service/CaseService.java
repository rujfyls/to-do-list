package main.service;

import main.entity.Case;

import java.util.List;

public interface CaseService {

    List<Case> getAllCases();

    Case getCase(int id);

    void addNewCase(Case c);

    void updateCase(Case c);

    void deleteAllCases();

    void deleteCase(int id);
}
