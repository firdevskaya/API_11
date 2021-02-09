package com.techproed;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

      /*
       Given: Baslangıc icin gereklilikleri ifade eder.
       When: Kullanicinin aksiyonunu ifade eder.
       Then: Ciktilari ifade eder-- Assert ler genelde burada yapilir
       And: Herhangi iki coklu adim arasinda kullanilabilir.
        Positive Scenario
     When I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
     Then
     HTTP Status code should be 200
     And  Content type should be Json
     And  Status Line should be HTTP/1.1 200 OK
    */


    @Test
    public void get01() {

        String url = "https://restful-booker.herokuapp.com/booking/3";
        Response response = given().accept("application/json")
.when().get(url);
        response.prettyPrint();

        response.then().
                assertThat().statusCode(200).
                contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.statusLine());
        System.out.println(response.time());

    }

   // tekrar cozumu
    @Test
           public void  tekrar1() {


        String url = "https://restful-booker.herokuapp.com/booking/3";
        Response response = given().accept("application/json")
                .when().get(url);
        response.prettyPrint();
        response.then().assertThat().contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK").statusCode(200);
        response.then().assertThat()
                .body("firstname", Matchers.equalTo("Sally"),
        "lastname",Matchers.equalTo("Wilson"),
        "totalprice",Matchers.equalTo(375),
        "depositpaid",Matchers.equalTo(false),
        "bookingdates.checkin",Matchers.equalTo("2018-03-25"));


    }

}