package com.shchekotov.wmservice.controller;

import java.util.ArrayList;
import java.util.List;

public class WashCycleRequest {

    private Integer id;

    private List<WashCycleElementRequest> elements = new ArrayList<>();

    public WashCycleRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<WashCycleElementRequest> getElements() {
        return elements;
    }

    public void setElements(List<WashCycleElementRequest> elements) {
        this.elements = elements;
    }
}
