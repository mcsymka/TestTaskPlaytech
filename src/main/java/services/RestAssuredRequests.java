package services;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

import java.net.URI;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredRequests {

    public String executeGet(
            RequestSpecification spec,
            URI uri,
            int statusCode
    ) {
        return given()
                .spec( spec )
                .when()
                .get( uri )
                .then()
                .assertThat()
                .statusCode( statusCode )
                .and()
                .extract()
                .asString();
    }

    public String executePost(
            RequestSpecification spec,
            URI uri,
            Object body,
            int statusCode
    ) {
        return given()
                .spec( spec )
                .contentType( ContentType.JSON )
                .body( body )
                .when()
                .post( uri )
                .then()
                .assertThat()
                .statusCode( statusCode )
                .and()
                .extract()
                .asString();
    }

    public String executePut(
            RequestSpecification spec,
            URI uri,
            Object body,
            int statusCode
    ) {
        return given()
                .spec( spec )
                .contentType( ContentType.JSON )
                .body( body )
                .when()
                .put( uri )
                .then()
                .assertThat()
                .statusCode( statusCode )
                .and()
                .extract()
                .asString();
    }

    public String executeDelete(
            RequestSpecification spec,
            URI uri,
            int statusCode
    ) {
        return given()
                .spec( spec )
                .when()
                .delete( uri )
                .then()
                .assertThat()
                .statusCode( statusCode )
                .and()
                .extract()
                .asString();
    }
}
