package com.shchekotov.wmservice.controller;

public class WashCycleElementRequest {

    private Integer id;

    private String name;

    public WashCycleElementRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
