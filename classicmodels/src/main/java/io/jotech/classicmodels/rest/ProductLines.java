package io.jotech.classicmodels.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jotech.classicmodels.entity.ProductLine;
import io.jotech.classicmodels.service.ProductLineService;
import io.jotech.classicmodels.vm.GridResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/productlines")
public class ProductLines {
    @Inject
    private ProductLineService productLineService;

    @GET
    public Response getAllProductLines() {
        var allProductLines = productLineService.getAllProductLines();
        var res = GridResponse.<ProductLine>builder()
                .rows(allProductLines)
                .success(true)
                .totalCount(allProductLines.size())
                .build();
        return Response.ok().entity(res).build();

    }
}
