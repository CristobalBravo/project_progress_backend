package com.example.project_progress.Service;

import com.example.project_progress.Model.Profession;
import com.example.project_progress.Model.ProjectType;
import com.example.project_progress.Repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionServiceImplementation implements ProfessionService{

    @Autowired
    private ProfessionRepository professionRepository;
    @Override
    public List<Profession> getAll() {
        return professionRepository.findAll();
    }

    @Override
    public Profession save(Profession profession) {
        return professionRepository.save(profession);
    }

    @Override
    public Profession findById(Long id) {
        Optional<Profession> professionOptional = professionRepository.findById(id);
        return professionOptional.orElse(null);
    }

    @Override
    public void delete(Profession profession) {
        professionRepository.delete(profession);
    }
}
