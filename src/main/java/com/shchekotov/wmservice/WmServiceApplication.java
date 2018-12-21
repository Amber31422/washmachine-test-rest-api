package com.shchekotov.wmservice;

import com.shchekotov.wmservice.model.WashCycle;
import com.shchekotov.wmservice.model.WashMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class WmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmServiceApplication.class, args);
    }

}

