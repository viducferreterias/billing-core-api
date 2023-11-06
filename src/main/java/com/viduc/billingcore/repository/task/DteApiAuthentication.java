package com.viduc.billingcore.repository.task;

import com.viduc.billingcore.repository.configuration.DteApiRepository;
import com.viduc.billingcore.repository.configuration.GlobalVariables;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import lombok.extern.java.Log;

@Log
@Singleton
public class DteApiAuthentication {

    @Inject
    private DteApiRepository dteApiRepository;

    @Inject
    private GlobalVariables globalVariables;

    @PostConstruct
    @Schedule(hour = "00")
    private void authenticate() throws Exception {

        log.info("solicitando renovacion de token a ministerio de hacienda ......");
        dteApiRepository.authenticate();
        log.info("token: " + globalVariables.getToken());

    }

}
