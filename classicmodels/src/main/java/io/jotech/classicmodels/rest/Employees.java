package io.jotech.classicmodels.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.jotech.classicmodels.entity.Employee;
import io.jotech.classicmodels.service.EmployeeService;
import io.jotech.classicmodels.vm.GridResponse;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/employees")
public class Employees {
    @Inject
    private EmployeeService employeeService;

    @GET
    public Response getEmployees(){
        var allEmployees = employeeService.getAllEmployees();
        var res = GridResponse.<Employee>builder()
                .rows(allEmployees)
                .success(true)
                .totalCount(allEmployees.size())
                .build();
        return Response.ok().entity(res).build();
    }
}
