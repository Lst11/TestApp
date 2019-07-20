package com.example.domain.usecases;

import com.example.domain.entity.Person;
import com.example.domain.executor.PostExecutorThread;
import com.example.domain.repositories.PeopleRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetPeopleByAgeUseCase extends BaseUseCase {
    private PeopleRepository peopleRepository;

    @Inject
    public GetPeopleByAgeUseCase(PeopleRepository peopleRepository, PostExecutorThread postExecutorThread) {
        super(postExecutorThread.getScheduler());
        this.peopleRepository = peopleRepository;
    }

    public Observable<ArrayList<Person>> getAll() {
        return peopleRepository.getAllByAge()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread);
    }
}