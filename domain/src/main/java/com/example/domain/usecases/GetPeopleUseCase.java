package com.example.domain.usecases;

import com.example.domain.entity.Person;
import com.example.domain.executor.PostExecutorThread;
import com.example.domain.repositories.PeopleRepository;

import java.util.ArrayList;

import javax.inject.Inject;

public class GetPeopleUseCase implements BaseUseCase {

    private PeopleRepository peopleRepository;
    private PostExecutorThread postExecutorThread;

    @Inject
    public GetPeopleUseCase(PeopleRepository peopleRepository, PostExecutorThread postExecutorThread) {
        this.peopleRepository = peopleRepository;
        this.postExecutorThread = postExecutorThread;
    }

    public ArrayList<Person> getAll(){
        return peopleRepository.getAll();
    }

}
