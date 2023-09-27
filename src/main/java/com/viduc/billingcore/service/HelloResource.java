package com.viduc.billingcore.service;

import com.viduc.billingcore.dto.request.sales.DteRequestDto;
import com.viduc.billingcore.repository.sale.DteGeneratorRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.time.LocalDateTime;

@RequestScoped
@Path("/hello-world")
public class HelloResource {

    @Inject
    private DteGeneratorRepository dteGeneratorRepository;

    @GET
    @Produces("text/plain")
    public String hello() {

        /*var request = DteRequestDto.builder()
                .companyId(1)
                .posId(2)
                .documentType(2)
                .documentNumber(278915)
                .date(LocalDateTime.parse("2022-10-07T16:27:21.000"))
                .build();

        dteGeneratorRepository.generate(request);*/
        //dteGeneratorRepository.dteIdentificationGenerator();
        return "Hello, World!";
    }
}