package com.shchekotov.wmservice.service;

import com.shchekotov.wmservice.model.WashCycle;
import com.shchekotov.wmservice.model.WashMachineState;

public interface WashMachineControlService {

    WashMachineState start(long id);

    WashMachineState setUpWashCycle(long id, WashCycle washCycle);

    WashMachineState pause(long id);

}
