package spoobaculiar;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import net.javacrumbs.jsonunit.JsonAssert;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

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

        String actually = RestAssured.given()
                .param("number",3)
                .param("query","kale")
                .param("cuisine", "Japanese")
                //.log()
                //.all()
                .expect()
                .statusCode(200)
                .time(lessThanOrEqualTo(5000L))
                .body("totalResults", is(62))
                .body("results", hasSize(3))
                //.log()
               // .all()
                .when()
                .get("/recipes/complexSearch")
                .body()
                .prettyPrint();

        String expected = readResourceAsString("expected.json");
        JsonAssert.assertJsonEquals(expected,actually,JsonAssert.when(Option.IGNORING_ARRAY_ORDER));
        System.err.println(expected);
    }

    private String readResourceAsString(String resourceName)  {
        String path = getClass().getSimpleName()+ FileSystems.getDefault()
                .getSeparator() + resourceName;
       try(InputStream inputStream = getClass().getResourceAsStream(path)){
           assert inputStream != null;
          byte[] data = inputStream.readAllBytes();
           return  new String(data, StandardCharsets.UTF_8);

       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }

}
