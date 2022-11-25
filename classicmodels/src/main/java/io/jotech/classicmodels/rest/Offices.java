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

import io.jotech.classicmodels.entity.Office;
import io.jotech.classicmodels.service.OfficeService;
import io.jotech.classicmodels.vm.FormResponse;
import io.jotech.classicmodels.vm.GridResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/offices")
public class Offices {
    @Inject
    private OfficeService officeService;

    @GET
    public Response getAllOffices() {

        var allOffices = officeService.getAllOffices();
        var res = GridResponse.<Office>builder()
                .rows(allOffices)
                .success(true)
                .totalCount(allOffices.size())
                .build();
        return Response.ok().entity(res).build();
    }

    @GET
    @Path("/{officeCode}")
    public Response getOffice(@PathParam("officeCode") String officeCode) {
        var office = officeService.getOffice(officeCode);
        var res = FormResponse.<Office>builder()
                .data(office)
                .success(true).build();
        return Response.ok().entity(res).build();
    }

    @POST
    public Response createOffice(@Valid Office office, @Context UriInfo uriInfo) {
        var savedOffice = officeService.createOffice(office);
        var  res = FormResponse.<Office>builder()
                .data(savedOffice)
                .success(true).build();
        return Response
                .created(uriInfo.getAbsolutePathBuilder()
                        .path(savedOffice.getOfficeCode().toString())
                        .build()
                )
                .entity(res)
                .build();

    }

    @PUT
    public Response updateOffice(@Valid Office office) {
        var updatedOfficeAccount = officeService.updateOffice(office);
        var res = FormResponse.<Office>builder()
                .data(updatedOfficeAccount)
                .success(true).build();
        return Response
                .ok()
                .entity(res)
                .build();

    }

    @DELETE
    @Path("/{officeCode}")
    public Response deleteOffice(@PathParam("officeCode") String officeCode) {
        boolean deleted = officeService.deleteOffice(officeCode);
        return Response
                .ok()
                .entity(FormResponse.<Boolean>builder()
                        .success(deleted)
                        .build()
                )
                .build();

    }
}
