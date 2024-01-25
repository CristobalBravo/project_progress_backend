package com.example.project_progress.Service;

import com.example.project_progress.Model.Profession;

import java.util.List;

public interface ProfessionService {

    List<Profession> getAll();
    Profession save(Profession profession);
    Profession findById(Long id);
    void delete(Profession profession);
}
