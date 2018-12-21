package com.shchekotov.wmservice.model;

import java.io.Serializable;
import java.util.Objects;

public class WashCycleElement implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    public WashCycleElement() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WashCycleElement that = (WashCycleElement) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
