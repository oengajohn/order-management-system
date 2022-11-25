package io.jotech.classicmodels.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jotech.classicmodels.entity.Payment;
import io.jotech.classicmodels.service.PaymentService;
import io.jotech.classicmodels.vm.GridResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/payments")
public class Payments {
    @Inject
    private PaymentService paymentService;

    @GET
    public Response getAllPayments() {
        var allPayments = paymentService.getAllPayments();
        var res = GridResponse.<Payment>builder()
                .rows(allPayments)
                .success(true)
                .totalCount(allPayments.size())
                .build();
        return Response.ok().entity(res).build();

    }
}

