package io.jotech.classicmodels.rest;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.jotech.classicmodels.entity.Customer;
import io.jotech.classicmodels.service.CustomerService;
import io.jotech.classicmodels.vm.FormResponse;
import io.jotech.classicmodels.vm.GridResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/customers")
public class Customers {
    @Inject
    private CustomerService customerService;

    @GET
    public Response getAllCustomers() {

        var allCustomers = customerService.getAllCustomers();
        var res = GridResponse.<Customer>builder()
                .rows(allCustomers)
                .success(true)
                .totalCount(allCustomers.size())
                .build();
        return Response.ok().entity(res).build();
    }

    @GET
    @Path("/{customerNumber}")
    public Response getCustomer(@PathParam("customerNumber") Integer customerNumber) {
        var customer = customerService.getCustomer(customerNumber);
        var res = FormResponse.<Customer>builder()
                .data(customer)
                .success(true).build();
        return Response.ok().entity(res).build();
    }

    @POST
    public Response createCustomer(@Valid Customer customer, @Context UriInfo uriInfo) {
        var savedCustomer = customerService.createCustomer(customer);
       var  res = FormResponse.<Customer>builder()
                .data(savedCustomer)
                .success(true).build();
        return Response
                .created(uriInfo.getAbsolutePathBuilder()
                        .path(savedCustomer.getCustomerNumber().toString())
                        .build()
                )
                .entity(res)
                .build();

    }

    @PUT
    public Response updateCustomer(@Valid Customer customer) {
        var updatedCustomerAccount = customerService.updateCustomer(customer);
        var res = FormResponse.<Customer>builder()
                .data(updatedCustomerAccount)
                .success(true).build();
        return Response
                .ok()
                .entity(res)
                .build();

    }

    @DELETE
    @Path("/{customerNumber}")
    public Response deleteCustomer(@PathParam("customerNumber") Integer customerNumber) {
        boolean deleted = customerService.deleteCustomer(customerNumber);
        return Response
                .ok()
                .entity(FormResponse.<Boolean>builder()
                        .success(deleted)
                        .build()
                )
                .build();

    }

}
