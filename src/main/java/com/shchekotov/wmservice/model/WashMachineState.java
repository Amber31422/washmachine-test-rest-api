package com.shchekotov.wmservice.model;

import java.io.Serializable;
import java.util.Objects;


public class WashMachineState implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private int spin;
    private int temperature;
    private WashMachineRunningState runningState;

    private WashCycleElement activeWashCycleElement;


    public WashMachineState() {
    }

    public int getSpin() {
        return spin;
    }

    public void setSpin(int spin) {
        this.spin = spin;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public WashCycleElement getActiveWashCycleElement() {
        return activeWashCycleElement;
    }

    public WashMachineRunningState getRunningState() {
        return runningState;
    }

    public void setRunningState(WashMachineRunningState runningState) {
        this.runningState = runningState;
    }

    public void setActiveWashCycleElement(WashCycleElement activeWashCycleElement) {
        this.activeWashCycleElement = activeWashCycleElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WashMachineState that = (WashMachineState) o;
        return id == that.id &&
                spin == that.spin &&
                temperature == that.temperature &&
                Objects.equals(activeWashCycleElement, that.activeWashCycleElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spin, temperature, activeWashCycleElement);
    }
}
