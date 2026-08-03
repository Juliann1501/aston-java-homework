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
                .body("args.isUnban", equalTo("true"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("url", equalTo("https://postman-echo.com"));
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
                .body("json.text", equalTo("Hello Aston!"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("url", equalTo("https://postman-echo.com"));
    }

    @Test
    @DisplayName("Тест 3 - Проверка метода PUT")
    void testPutMethod() {
        String jsonBody = "{\n" +
                "  \"status\": \"updated\"\n" +
                "}";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.status", equalTo("updated"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("url", equalTo("https://postman-echo.com"));
    }

    @Test
    @DisplayName("Те.ст 4 - Проверка метода PATCH")
    void testPatchMethod() {
        String jsonBody = "{\n" +
                "  \"role\": \"admin\"\n" +
                "}";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("json.role", equalTo("admin"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("url", equalTo("https://postman-echo.com"));
    }

    @Test
    @DisplayName("Тест 5 - Проверка метода DELETE")
    void testDeleteMethod() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("url", equalTo("https://postman-echo.com"));
    }
}
