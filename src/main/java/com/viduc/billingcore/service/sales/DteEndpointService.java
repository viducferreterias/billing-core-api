package com.viduc.billingcore.service.sales;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viduc.billingcore.dto.request.sales.DteRequestDto;
import com.viduc.billingcore.dto.response.DteApiProcessingResultResponseDte;
import com.viduc.billingcore.repository.sale.DteGeneratorRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Getter;

import javax.print.attribute.standard.Media;
import java.time.LocalDateTime;
import java.util.List;

@Path(value = "/dte")
@RequestScoped
public class DteEndpointService {

    @Inject
    private DteGeneratorRepository dteGeneratorRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response generate(@QueryParam(value = "posId") Integer posId , @QueryParam(value = "documentType") Integer documentType , @QueryParam(value = "documentNumber") Integer documentNumber , @QueryParam(value = "documentDate") String documentDate , @QueryParam(value = "companyId") Integer companyId , @QueryParam(value = "warehouseOrigin") Integer warehouseOrigin) throws Exception {

        var request = DteRequestDto.builder()
                .companyId(companyId)
                .posId(posId)
                .documentType(documentType)
                .documentNumber(documentNumber)
                .date(LocalDateTime.parse(documentDate))
                .warehouseOrigin(warehouseOrigin)
                .build();

            return Response.ok().entity(dteGeneratorRepository.generate(request)).build();

    }

    @GET
    @Path(value = "/invalidate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response invalidate(@QueryParam(value = "posId") Integer posId , @QueryParam(value = "documentType") Integer documentType , @QueryParam(value = "documentNumber") Integer documentNumber , @QueryParam(value = "documentDate") String documentDate , @QueryParam(value = "companyId") Integer companyId , @QueryParam(value = "warehouseOrigin") Integer warehouseOrigin) throws Exception {

        var request = DteRequestDto.builder()
                .companyId(companyId)
                .posId(posId)
                .documentType(documentType)
                .documentNumber(documentNumber)
                .date(LocalDateTime.parse(documentDate))
                .warehouseOrigin(warehouseOrigin)
                .build();

        return Response.ok().entity(dteGeneratorRepository.invalidateDocument(request)).build();
    }

}
