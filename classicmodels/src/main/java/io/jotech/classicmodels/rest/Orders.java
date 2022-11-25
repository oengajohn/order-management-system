package io.jotech.classicmodels.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jotech.classicmodels.entity.Order;
import io.jotech.classicmodels.service.OrderService;
import io.jotech.classicmodels.vm.GridResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/orders")
public class Orders {
    @Inject
    private OrderService orderService;

    @GET
    public Response getAllOrders() {
        var allOrderDetails = orderService.getAllOrders();
        var res = GridResponse.<Order>builder()
                .rows(allOrderDetails)
                .success(true)
                .totalCount(allOrderDetails.size())
                .build();
        return Response.ok().entity(res).build();

    }
}
