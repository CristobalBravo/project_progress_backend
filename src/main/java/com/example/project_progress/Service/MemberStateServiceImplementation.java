package com.example.project_progress.Service;

import com.example.project_progress.Model.MemberState;
import com.example.project_progress.Model.Profession;
import com.example.project_progress.Repository.MemberStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberStateServiceImplementation implements MemberStateService{

    @Autowired
    private MemberStateRepository memberStateRepository;
    @Override
    public List<MemberState> getAll() {
        return memberStateRepository.findAll();
    }

    @Override
    public MemberState save(MemberState memberState) {
        return memberStateRepository.save(memberState);
    }

    @Override
    public MemberState findById(Long id) {
        Optional<MemberState> memberStateOptional = memberStateRepository.findById(id);
        return memberStateOptional.orElse(null);
    }

    @Override
    public void delete(MemberState memberState) {
        memberStateRepository.delete(memberState);
    }

}
