package com.techproed;

import TestBase.TestBaseJsonPlaceHolder;
import TestData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import java.awt.image.RescaleOp;

import static io.restassured.RestAssured.given;

public class PutRequest01  extends TestBaseJsonPlaceHolder {

	/*
	 	When
	 		I send PUT Requst to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "userId": 21,
										    "title": "Wash the dishes",
										    "completed": false
										   }
	   Then
	   	   Status code is 200
	   	   And response body is like  {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false,
									    "id": 198
									  }


	 */
    @Test
    public void put01(){
spec01.pathParams("todospath","todos","id",198);
JsonPlaceHolderTestData expectedObj= new JsonPlaceHolderTestData();
        JSONObject expectedDataJson= expectedObj.setUpPutRequestByJSONObject();
        Response response = given()
                .contentType(ContentType.JSON)
                .spec(spec01)
                .body(expectedDataJson.toString())
                .when()
                .put("/{todospath}/{id}");
        response.prettyPrint();

  //Assertion





    }



}
