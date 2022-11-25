package io.jotech.classicmodels.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jotech.classicmodels.entity.Product;
import io.jotech.classicmodels.service.ProductService;
import io.jotech.classicmodels.vm.GridResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/products")
public class Products {
    @Inject
    private ProductService productService;

    @GET
    public Response getAllProducts() {
        var allProducts = productService.getAllProducts();
        var res = GridResponse.<Product>builder()
                .rows(allProducts)
                .success(true)
                .totalCount(allProducts.size())
                .build();
        return Response.ok().entity(res).build();

    }
}
