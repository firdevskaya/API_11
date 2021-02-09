package com.techproed;

import TestBase.TestBaseJsonPlaceHolder;
import TestData.JsonPlaceHolderTestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest03 extends TestBaseJsonPlaceHolder {
/*
	 	When
	  		I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
	  		with the request body {
								    "userId": 55,
								    "title": "Tidy your room",
								    "completed": false
								   }
		Then
			Status code is 200
			And response body is like {
									    "userId": 55,
									    "title": "Tidy your room",
									    "completed": false,
									    "id": 201
									   }
	 */

    @Test
    public void put01(){
        // 1. Url olusturma
        spec01.pathParams("todosPath","todos",
                "id",198);
        // ReqBody olusturmak
        JsonPlaceHolderTestData expectedObj = new JsonPlaceHolderTestData();
        JSONObject expectedDataJSON  = expectedObj.setUpPutRequestByJSONObject();
        // Request olusturma

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                body(expectedDataJSON.toString()).
                when().
                put("/{todosPath}/{id}");
        response.prettyPrint();

        // Assertion
        // 1. yol odev--- body ve JsonObject
        // 2. yol odev--- jsonPath ve JsonObject
        // 3. yol Gson ve JsonObject
        response.then().
                assertThat().
                statusCode(200);


        Map<String,Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);
        Assert.assertEquals(expectedDataJSON.getBoolean("completed"),actualDataMap.get("completed"));
        Assert.assertEquals(expectedDataJSON.getString("title"),actualDataMap.get("title"));
        Assert.assertEquals(expectedDataJSON.getInt("userId"),actualDataMap.get("userId"));

    }}
