package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {
/*
	     When I send a GET request to REST API URL
		      https://restful-booker.herokuapp.com/booking/5
	     Then HTTP Status Code 200 olsun
	     And Response content type “application/JSON” olsun
	     And "firstname" "Jim" olsun
	     And "totalprice" 602 olsun
		 And "checkin" "2015-06-12" olsun
	 */


@Test
    public void get04(){
   String url ="https://restful-booker.herokuapp.com/booking/5";
    Response response= given().when().get(url);
response.prettyPrint();
response.then().assertThat().contentType(ContentType.JSON);
response.then().assertThat()
        .body("firstname", Matchers.equalTo("Jim"),
    "totalprice",Matchers.equalTo(602),
        "bookingdates.checkin", Matchers.equalTo("2015-06-12"));


/* response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Mark"),
                    "totalprice",equalTo(821),
                         "bookingdates.checkin",equalTo("2015-05-10"));*/


}



@Test
    public void  tekrar1(){

    Response response= given().when().get("https://restful-booker.herokuapp.com/booking/5");
    response.prettyPrint();
    response.then().contentType(ContentType.JSON)
           .body("firstname",Matchers.equalTo("Mark"),
                   "totalprice",Matchers.equalTo(821),
                   "bookingdates.ckeckin",Matchers.equalTo("2015-05-10"));




}




}
