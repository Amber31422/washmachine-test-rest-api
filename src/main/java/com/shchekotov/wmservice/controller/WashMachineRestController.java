package com.shchekotov.wmservice.controller;

import com.shchekotov.wmservice.common.ParamUtils;
import com.shchekotov.wmservice.model.WashCycle;
import com.shchekotov.wmservice.model.WashCycleElement;
import com.shchekotov.wmservice.model.WashMachine;
import com.shchekotov.wmservice.service.WashMachineControlService;
import com.shchekotov.wmservice.service.WashMachineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class WashMachineRestController {

    private static final Logger LOG = LoggerFactory.getLogger(WashMachineRestController.class);

    @Autowired
    private WashMachineService washMachineService;

    @Autowired
    private WashMachineControlService washMachineControlService;

    @RequestMapping(value = "/washmachine/{washMachineId}", method = RequestMethod.GET, produces = "application/json")
    public WashMachine getWashMachineById(@PathVariable Long washMachineId) {
        Optional<WashMachine> washMachineById = washMachineService.getWashMachineById(washMachineId);
        return washMachineById.orElse(new WashMachine());
    }

    @RequestMapping(value = "/washmachines", method = RequestMethod.GET, produces = "application/json")
    public List<WashMachine> getWashMachines() {
        return washMachineService.findAll();
    }

    @RequestMapping(value = "/washmachine/setwashcycle/{washMachineId}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> setUpWashCycleById(@PathVariable Long washMachineId, @RequestBody() WashCycleRequest washCycleRequest) {

        try {
            boolean validated = true;
            Map<String, Object> values = new HashMap<>();
            Map<String, Object> errors = new HashMap<>();

            Integer washCycleId = washCycleRequest.getId();
            List<WashCycleElementRequest> elements = washCycleRequest.getElements();

            if (washMachineId == null || washMachineId <= 0) {
                errors.put("washMachineId", "Appliance Id is not specified");
                validated = false;
            }
            if (washCycleId == null || washCycleId <= 0) {
                errors.put("washCycleId", "Wash cycle id is not specified");
                validated = false;
            }
            if (elements.isEmpty()) {
                errors.put("elements", "Wash program elements aren't defined");
                validated = false;
            }
            if (validated) {
                WashCycle washCycle = new WashCycle();
                washCycle.setId(washCycleId);
                List<WashCycleElement> elementList = new ArrayList<>();
                for (WashCycleElementRequest parameter : elements) {
                    WashCycleElement washCycleElement = new WashCycleElement();
                    washCycleElement.setName(parameter.getName());
                    elementList.add(washCycleElement);
                }
                washCycle.setWashCycleElementList(elementList);
                washMachineControlService.setUpWashCycle(washMachineId, washCycle);
            }

            return ResponseEntity.ok(ParamUtils.result(!validated, values, errors));
        } catch (Exception e) {
            LOG.error(null, e);
        }
        return ResponseEntity.ok(ParamUtils.result(true));
    }

    @RequestMapping(value = "washmachine/start/{washMachineId}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> start(@PathVariable Long washMachineId) {

        try {
            boolean validated = true;
            Map<String, Object> values = new HashMap<>();
            Map<String, Object> errors = new HashMap<>();

            if (washMachineId == null || washMachineId <= 0) {
                errors.put("washMachineId", "Appliance Id is not specified");
                validated = false;
            }

            if (validated) {
                washMachineControlService.start(washMachineId);
            }

            return ResponseEntity.ok(ParamUtils.result(!validated, values, errors));
        } catch (Exception e) {
            LOG.error(null, e);
        }
        return ResponseEntity.ok(ParamUtils.result(true));
    }

    @RequestMapping(value = "washmachine/pause/{washMachineId}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> pause(@PathVariable Long washMachineId) {

        try {
            boolean validated = true;
            Map<String, Object> values = new HashMap<>();
            Map<String, Object> errors = new HashMap<>();

            if (washMachineId == null || washMachineId <= 0) {
                errors.put("washMachineId", "Appliance Id is not specified");
                validated = false;
            }

            if (validated) {
                washMachineControlService.pause(washMachineId);
            }

            return ResponseEntity.ok(ParamUtils.result(!validated, values, errors));
        } catch (Exception e) {
            LOG.error(null, e);
        }
        return ResponseEntity.ok(ParamUtils.result(true));
    }

}
