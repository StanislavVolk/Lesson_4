package Lesson_4_DZ;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;


public class AddToShoppingList {
    @BeforeAll
    static void beforeAll(){
        RestAssured.baseURI = "https://api.spoonacular.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addParam("apiKey","ffd7edd0a1a94e50abebf2aee2be91ca")
                .addParam("username","dsky")
                .build();
    }


    @Test
    void addToShoppingList(){

       String actually = RestAssured.given()
                .param("username", "dsky")
                .param("hash", "ipsum ea proident amet occaecat")
                .log()
                .uri()
                .expect()
               // .statusCode(200)
                .time(lessThanOrEqualTo(5000L))
               .body("status",hasToString("failure"))
               .body("code", is(401))
                .log()
                .body()
                .when()
                .get("/mealplanner/:username/shopping-list")
                .body()
                .asPrettyString();
        System.out.println("Никак не могу авторизоваться");


    }
}
