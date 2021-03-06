package com.techproed;

import TestBase.TestBaseJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.TodosPojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRequestWithPojo01  extends TestBaseJsonPlaceHolder {


/*
	 POJO'da olmasi gerekenler;

	 1)JSON'da key olanlar icin variable olusturun ve variable'larin access modifier'larini private yapin
	 2)Her variable icin getter ve setter method'lari olustrurn
	 3)Parametresiz constructor olusturun (
	 4)Olusturdugunuz variable'lari parametre kabul eden parametreli constructor olustrun
	 5)toString() methodu olusturun
	*/


/*
	 	When
	 		I send POST Request to the URL https://jsonplaceholder.typicode.com/todos
	 		with Post Request body  {
									    "userId": 21,
									    "id": 201,
									    "title": "Tidy your room",
									    "completed": false
									  }
	 	Then
	 		Status code is 201
	 		And response body is like {
									    "userId": 21,
									    "id": 201,
									    "title": "Tidy your room",
									    "completed": false
									  }

	 */




    public void postPojo01(){
        // Url i olustur
        spec01.pathParam("todosPath","todos");
        // ExpectedDatayı olustur
        TodosPojo expectedPojoData = new TodosPojo(21,201,"Tidy your room",false);
        // Requesti gonder
        Response response = given().
                contentType(ContentType.JSON).
                spec(spec01).
                body(expectedPojoData).
                when().
                post("/{todosPath}");
        //  response.prettyPrint();

        // Assert
        // 1. yol-- body-- Pojo
        response.
                then().
                assertThat().
                statusCode(201).
                body("userId", equalTo(expectedPojoData.getUserID()),
                        "id",equalTo(expectedPojoData.getId()),
                        "title",equalTo(expectedPojoData.getTitle()),
                        "completed",equalTo(expectedPojoData.isCompleted()));

        // 2. yol -- jsonPath ve pojos
        // 3. yol Gson- Pojos
        TodosPojo actualTodosData = response.as(TodosPojo.class);
        System.out.println(actualTodosData);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTodosData.getUserID(),expectedPojoData.getUserID());
        softAssert.assertEquals(actualTodosData.getId(),expectedPojoData.getId());
        softAssert.assertEquals(actualTodosData.getTitle(),expectedPojoData.getTitle());
        softAssert.assertEquals(actualTodosData.isCompleted(),expectedPojoData.isCompleted());
        softAssert.assertAll();

    }
}




