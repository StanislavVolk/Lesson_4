package spoonaculiar;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ComplexSearchApiTest {
    @BeforeAll
    static void beforeAll(){
        RestAssured.baseURI = "https://api.spoonacular.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addParam("apiKey","70d82fc726724e858ca58430f20b5b18")
                .build();
    }

    @Test
    void testSearchKale(){

        RestAssured.given()
                .param("number",3)
                .param("query","kale")
                .param("cuisine", "Japanese")
                .log()
                .all()
                .expect()
                .statusCode(200)
                .time(Matchers.lessThanOrEqualTo(2500L))
                .log()
                .all()
                .when()
                .get("/recipes/complexSearch");

    }
}
