package com.techproed;

import TestBase.TestBaseJsonPlaceHolder;
import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PatchRequest01  extends TestBaseJsonPlaceHolder {


/*
    When
    I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
    with the PUT Request body like {
        "title": "Tidy your room",
    }
    Then
    Status code is 200
    And response body is like  {
        "userId": 10,
                "title": "Tidy your room",
                "completed": true,
                "id": 198
    }
   */



@Test
    public void patch(){


    spec01.pathParams("todos","todos",
            "id",198);
    JsonPlaceHolderTestData expectedObj= new JsonPlaceHolderTestData();
    Map<String,Object>expectedDataMap= expectedObj.setUpPatchDataByUsingMap();
    Response response= given()
            .contentType(ContentType.JSON)
            .spec(spec01)
           . when()
            .patch("/{todos}/{id}");
    response.prettyPrint();

}



}
