package com.shchekotov.wmservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class WashCycle implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private List<WashCycleElement> washCycleElementList = new ArrayList<>();

    public WashCycle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<WashCycleElement> getWashCycleElementList() {
        return washCycleElementList;
    }

    public void setWashCycleElementList(List<WashCycleElement> washCycleElementList) {
        this.washCycleElementList = washCycleElementList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WashCycle washCycle = (WashCycle) o;
        return id == washCycle.id &&
                Objects.equals(washCycleElementList, washCycle.washCycleElementList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, washCycleElementList);
    }
}
