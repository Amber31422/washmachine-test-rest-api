package com.shchekotov.wmservice.service.impl;

import com.shchekotov.wmservice.model.WashMachine;
import com.shchekotov.wmservice.model.WashMachineRunningState;
import com.shchekotov.wmservice.model.WashMachineState;
import com.shchekotov.wmservice.service.WashMachineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WashMachineServiceImpl implements WashMachineService {

    private List<WashMachine> washMachines = new ArrayList<>();

    public WashMachineServiceImpl() {
        WashMachine washMachine = new WashMachine();
        washMachine.setId(1L);
        WashMachineState washMachineState = new WashMachineState();
        washMachineState.setRunningState(WashMachineRunningState.TURNED_ON);
        washMachine.setWashMachineState(washMachineState);
        washMachine.setModelName("EFLS627UTT");

        WashMachine washMachine2 = new WashMachine();
        washMachine2.setId(2L);
        WashMachineState washMachineState2 = new WashMachineState();
        washMachineState2.setRunningState(WashMachineRunningState.TURNED_ON);
        washMachine2.setWashMachineState(washMachineState2);
        washMachine2.setModelName("EFLS627UTT");
        washMachines.add(washMachine);
        washMachines.add(washMachine2);
    }

    @Override
    public Optional<WashMachine> getWashMachineById(long id) {
        return washMachines.stream().filter(w -> w.getId() == id).findFirst();
    }

    @Override
    public void saveWashMachine(WashMachine machine) {
        washMachines.add(machine);
    }

    @Override
    public void deleteWashMachine(long id) {
        washMachines.removeIf(w -> w.getId() == id);
    }

    @Override
    public List<WashMachine> findAll() {
        return washMachines;
    }
}
