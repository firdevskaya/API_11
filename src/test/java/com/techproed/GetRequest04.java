package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetRequest04 {
/*
    When I send a GET Request to
    http://dummy.restapiexample.com/api/v1/employees
    And Accept type  “application/JSON” olsun
            Then
    HTTP Status Code 200 olsun
    And Response'in format "application/JSON" olsun
    And 24 employees olsun
    And "Ashton Cox" employee'lerden biri olsun
    And 21, 61, ve 23 employee yaslarindan biri olsun*/
@Test
    public void get01() {


    String url = "http://dummy.restapiexample.com/api/v1/employees";
    Response response = given().accept("application/JSON")
            .when().get(url);
    response.prettyPrint();
    response.then().assertThat().statusCode(200).contentType(ContentType.JSON);


    response.then().assertThat().body("data.id", Matchers.hasSize(24),
            "data.employee_name", Matchers.hasItem("Ashton Cox"),
            "data.employee_age", Matchers.hasItems("21", "61", "23"));


}


    @Test
            public void tekrar2(){



     //   String url ="http://dummy.restapiexample.com/api/v1/employees";
        Response response= given().when()
                .accept("application/JSON")
                .get("http://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();
response.then()
        .assertThat()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("data.id",Matchers.hasSize(24),
                "data.employee_name",Matchers.hasItem("Ashton Cox"),
             "data.employee_age", Matchers.hasItems("21", "61", "23") );

    }

}









