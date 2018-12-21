package com.shchekotov.wmservice.service.impl;

import com.shchekotov.wmservice.model.*;
import com.shchekotov.wmservice.service.WashMachineControlService;
import com.shchekotov.wmservice.service.WashMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WashMachineControlServiceImpl implements WashMachineControlService {

    @Autowired
    private WashMachineService washMachineService;

    @Override
    public WashMachineState start(long id) {
        Optional<WashMachine> optional = washMachineService.getWashMachineById(id);
        if (optional.isPresent()) {
            WashMachine washMachine = optional.get();
            WashMachineState washMachineState = washMachine.getWashMachineState();
            washMachineState.setRunningState(WashMachineRunningState.RUNNING);
            return washMachineState;
        }
        return null;
    }

    @Override
    public WashMachine setUpWashCycle(long id, WashCycle washCycle) {
        Optional<WashMachine> optional = washMachineService.getWashMachineById(id);
        if (optional.isPresent()) {
            WashMachine washMachine = optional.get();
            washMachine.setWashCycle(washCycle);
            WashMachineState washMachineState = new WashMachineState();
            List<WashCycleElement> washCycleElementList = washCycle.getWashCycleElementList();
            Optional<WashCycleElement> firstElement = washCycleElementList.stream().findFirst();
            firstElement.ifPresent(washMachineState::setActiveWashCycleElement);
            return washMachine;
        }
        return null;
    }

    @Override
    public WashMachineState pause(long id) {
        Optional<WashMachine> optional = washMachineService.getWashMachineById(id);
        if (optional.isPresent()) {
            WashMachine washMachine = optional.get();
            WashMachineState washMachineState = washMachine.getWashMachineState();
            washMachineState.setRunningState(WashMachineRunningState.WAITING);
            return washMachineState;
        }
        return null;
    }

    public WashMachineService getWashMachineService() {
        return washMachineService;
    }

    public void setWashMachineService(WashMachineService washMachineService) {
        this.washMachineService = washMachineService;
    }
}
