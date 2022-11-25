package io.jotech.classicmodels.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
