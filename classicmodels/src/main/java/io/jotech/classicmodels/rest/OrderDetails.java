package io.jotech.classicmodels.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.jotech.classicmodels.entity.OrderDetail;
import io.jotech.classicmodels.service.OrderDetailService;
import io.jotech.classicmodels.vm.GridResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/orderdetails")
public class OrderDetails {


    @Inject
    private OrderDetailService orderDetailService;

    @GET
    public Response getAllOrderDetails() {

        var allOrderDetails = orderDetailService.getAllOrderDetails();
        var res = GridResponse.<OrderDetail>builder()
                .rows(allOrderDetails)
                .success(true)
                .totalCount(allOrderDetails.size())
                .build();
        return Response.ok().entity(res).build();


    }
}
