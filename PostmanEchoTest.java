

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoTest {

    @Test
    @DisplayName("Тест 1 - Проверка метода GET")
    void testGetMethod() {
        given()
                .baseUri("https://postman-echo.com")
                .queryParam("userId", "777")
                .queryParam("isUnban", "true")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.userId", equalTo("777"))
                .body("args.isUnban", equalTo("true"));
    }

    @Test
    @DisplayName("Тест 2 - Проверка метода POST")
    void testPostMethod() {
        String jsonBody = "{\n" +
                "  \"text\": \"Hello Aston!\"\n" +
                "}";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.text", equalTo("Hello Aston!"));
    }
}

