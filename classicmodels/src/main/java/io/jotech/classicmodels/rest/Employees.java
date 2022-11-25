package io.jotech.classicmodels.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
