package com.example.domain.usecases;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

abstract class BaseUseCase{

    Scheduler postExecutorThread;
    Scheduler workExecutorThread = Schedulers.io();

    public BaseUseCase(Scheduler postExecutorThread) {
        this.postExecutorThread = postExecutorThread;
    }

    public BaseUseCase(Scheduler postExecutorThread, Scheduler workExecutorThread) {
        this.postExecutorThread = postExecutorThread;
        this.workExecutorThread = workExecutorThread;
    }
}
