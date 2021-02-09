package com.techproed;

import TestBase.TestBaseHerOkuApp;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GetRequest07 extends TestBaseHerOkuApp {

    /*
     * When I send a GET request to REST API URL
     * https://restful-booker.herokuapp.com/booking/5
     * Then HTTP Status Code should be 200
     * And response content type is “application/JSON”
     * And response body should be like;
     * {"firstname": "Sally",
     *   "lastname": "Ericsson",
     *   "totalprice": 111,
     *   "depositpaid": false,
     *   "bookingdates": { "checkin": "2017-05-23",
     *                     "checkout":"2019-07-02" }
     * }
     */


    @Test
    public void get01() {
        // Url olusturmak
        spec02.pathParam("bookingid", 5);

        //Request olusturmak
        Response response = given().
                spec(spec02).
                when().
                get("/{bookingid}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);
        //jsonPath ();
        // response un icerisinde hareket edebilmezi ve degerlere ulasabilmemizi saglar.

        JsonPath jsonPath = response.jsonPath();
        System.out.println("First name " + jsonPath.getString("firstname"));
        Assert.assertEquals("Firstname istenilen gibi degil", "Mary", jsonPath.getString("firstname"));
        System.out.println("Last name " + jsonPath.getString("lastname"));
        Assert.assertEquals("Lastname istenilen gibi degil", "Ericsson", jsonPath.getString("lastname"));
        System.out.println("Total price " + jsonPath.getInt("totalprice"));
        Assert.assertEquals("Totalprice istenilen gibi degil ", 558, jsonPath.getInt("totalprice"));
        System.out.println("DEposit paid " + jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals("Deposit paid beklenen gibi degil ", true, jsonPath.getBoolean("depositpaid"));
        System.out.println("Check in tarihi " + jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals("Check in tarihi istenilen gibi degil ", "2019-10-20", jsonPath.getString("bookingdates.checkin"));
        System.out.println("Check out tarihi " + jsonPath.getString("bookingdates.checkout"));
        Assert.assertEquals("Check out tarihi istenilen gibi degil ", "2020-08-25", jsonPath.getString("bookingdates.checkout"));


    }


 //   @Test
//    public void get02(){

     //   response.prettyPrint();
//
     //   response.
      //          then().
         //       assertThat().
           //     statusCode(200).
            //    contentType(ContentType.JSON).
            //    body("firstname", equalTo("Sally"),
                 //       "lastname", equalTo("Jackson"),
                 //       "totalprice",equalTo(111),
                   //     "depositpaid",equalTo(false),
                   //     "bookingdates.checkin",equalTo("2017-05-23"),
                   //     "bookingdates.checkout",equalTo("2019-07-02");
                   //
    //}




   // }
}