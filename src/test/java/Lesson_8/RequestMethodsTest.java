package Lesson_8;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RequestMethodsTest {
    @BeforeAll
    public static void setUp() {
        baseURI = "https://postman-echo.com";
    }

    @Test
    @Disabled
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
    @Disabled
    public void postRequestWithRawText() {
        String requestText = "{\n" +
                "    \"test\": \"Hello world!\"\n" +
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
    public void postRequestWithFormData() {

    }

    @Test
    @Disabled
    public void putRequest() {

    }

    @Test
    @Disabled
    public void patchRequest() {

    }

    @Test
    @Disabled
    public void deleteRequest() {

    }
}