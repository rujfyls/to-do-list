package main.service;

import main.entity.Case;
import main.exeption_handling.EntityNotFoundException;
import main.repository.CaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;

    public CaseServiceImpl(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    @Override
    public Case getCase(int id) {
        return caseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Дела с id = " + id + " не существует!"));
    }

    @Override
    public void addNewCase(Case c) {
        caseRepository.save(c);
    }

    @Override
    public void updateCase(Case c) {
        caseRepository.save(c);
    }

    @Override
    public void deleteAllCases() {
        caseRepository.deleteAll();
    }

    @Override
    public void deleteCase(int id) {
        caseRepository.deleteById(id);
    }
}
