package com.example.domain.usecases;


import com.example.domain.entity.Person;
import com.example.domain.executor.PostExecutorThread;
import com.example.domain.repositories.PeopleRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetPeopleByNameUseCase extends BaseUseCase {
    private PeopleRepository peopleRepository;

    @Inject
    public GetPeopleByNameUseCase(PeopleRepository peopleRepository, PostExecutorThread postExecutorThread) {
        super(postExecutorThread.getScheduler());
        this.peopleRepository = peopleRepository;
    }

    public Observable<ArrayList<Person>> getAll() {
        return peopleRepository.getAllByName()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread);
    }
}