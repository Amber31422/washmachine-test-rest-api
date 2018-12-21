package com.shchekotov.wmservice.service;

import com.shchekotov.wmservice.model.WashMachine;

import java.util.List;
import java.util.Optional;

public interface WashMachineService {

    Optional<WashMachine> getWashMachineById(long id);

    void saveWashMachine(WashMachine machine);

    void deleteWashMachine(long id);

    List<WashMachine> findAll();
}
