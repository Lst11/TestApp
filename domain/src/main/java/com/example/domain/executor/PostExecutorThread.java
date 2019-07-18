package com.example.domain.executor;

import io.reactivex.Scheduler;

public interface PostExecutorThread {

    Scheduler getScheduler();

}
