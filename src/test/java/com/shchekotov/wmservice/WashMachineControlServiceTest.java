package com.shchekotov.wmservice;

import com.shchekotov.wmservice.model.*;
import com.shchekotov.wmservice.service.WashMachineService;
import com.shchekotov.wmservice.service.impl.WashMachineControlServiceImpl;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class WashMachineControlServiceTest {

    @Mock
    private WashMachineService washMachineService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void setUpWashProgram() {
        WashMachineControlServiceImpl washMachineControlService = new WashMachineControlServiceImpl();
        washMachineControlService.setWashMachineService(washMachineService);

        WashMachine washMachine = new WashMachine();
        washMachine.setId(1L);
        WashMachineState washMachineState = new WashMachineState();
        washMachineState.setRunningState(WashMachineRunningState.TURNED_ON);
        washMachine.setWashMachineState(washMachineState);
        washMachine.setModelName("EFLS627UTT");


        when(washMachineService.getWashMachineById(1L)).thenReturn(Optional.of(washMachine));
        WashCycle washCycle = new WashCycle();
        washCycle.setId(1);
        WashCycleElement washCycleElement = new WashCycleElement();
        washCycleElement.setName("Washing");
        WashCycleElement washCycleElement2 = new WashCycleElement();
        washCycleElement2.setName("Rinsing");
        WashCycleElement washCycleElement3 = new WashCycleElement();
        washCycleElement3.setName("Spinning");

        washCycle.setWashCycleElementList(Arrays.asList(washCycleElement,washCycleElement2,washCycleElement3));

        WashMachine washMachine1 = washMachineControlService.setUpWashCycle(1L, washCycle);
        assertEquals(washCycle, washMachine1.getWashCycle());
    }

}
