package com.shchekotov.wmservice.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class WashMachine implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String modelName;

    private WashMachineState washMachineStateHistory;

    private WashCycle washCycle;

    public WashMachine() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public WashMachineState getWashMachineState() {
        return washMachineStateHistory;
    }

    public void setWashMachineState(WashMachineState washMachineStateHistory) {
        this.washMachineStateHistory = washMachineStateHistory;
    }

    public WashCycle getWashCycle() {
        return washCycle;
    }

    public void setWashCycle(WashCycle washCycle) {
        this.washCycle = washCycle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WashMachine that = (WashMachine) o;
        return id == that.id &&
                Objects.equals(modelName, that.modelName) &&
                Objects.equals(washMachineStateHistory, that.washMachineStateHistory) &&
                Objects.equals(washCycle, that.washCycle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelName, washMachineStateHistory, washCycle);
    }
}
