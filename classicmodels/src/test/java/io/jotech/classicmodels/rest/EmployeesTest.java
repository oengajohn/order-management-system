package io.jotech.classicmodels.rest;

import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.Filters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import io.jotech.classicmodels.util.ArquillianWarUtils;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ExtendWith(ArquillianExtension.class)
public class EmployeesTest {

    @Deployment
    public static Archive<?> createDeployment() {

        return ArquillianWarUtils
                .getBasicWebArchive("OfficesTest.war")
                .addPackages(
                        true,
                        Filters.exclude(
                                OfficesTest.class,
                                EmployeesTest.class
                        ),
                        "io.jotech"
                );
    }

    @ArquillianResource
    private URL base;

    @Test
    @DisplayName("testAllEmployees")
    @Order(1)
    void testAllEmployees() {
        given()//prerequisites
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .log()
                .all()
                .when()//describes the action to take
                .get(base + "api/employees/")
                .then()//Describe the expected result
                .log().all()
                .assertThat()
                .statusCode(Response.Status.OK.getStatusCode())
                .header("Content-Type", "application/json")
                .body("rows.size()", greaterThan(0))

        ;

    }

}