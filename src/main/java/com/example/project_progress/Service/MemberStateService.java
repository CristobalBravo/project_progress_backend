package com.example.project_progress.Service;

import com.example.project_progress.Model.MemberState;
import com.example.project_progress.Model.Profession;

import java.util.List;

public interface MemberStateService {

    List<MemberState> getAll();
    MemberState save(MemberState memberState);
    MemberState findById(Long id);
    void delete(MemberState memberState);
}
