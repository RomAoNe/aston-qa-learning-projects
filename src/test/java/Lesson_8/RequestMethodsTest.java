package Lesson_8;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RequestMethodsTest {
    @BeforeAll
    public static void setUp() {
        baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("GET с query параметрами")
    public void getRequestWithQueryParams() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")

                .when()
                .get("/get")

                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("POST с raw text")
    public void postRequestWithRawText() {
        String requestText = "{\n" +
                "    \"test\": \"value\"\n" +
                "}";

        given()
                .contentType("text/plain")
                .body(requestText)

                .when()
                .post("/post")

                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("data", equalTo(requestText));
    }

    @Test
    @DisplayName("POST с form-data")
    public void postRequestWithFormData() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")

                .when()
                .post("/post")

                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    @DisplayName("PUT с текстовым телом")
    public void putRequest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    @DisplayName("PATCH с текстовым телом")
    public void patchRequest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    @DisplayName("DELETE с текстовым телом")
    public void deleteRequest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}