package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.dto.FightDto;
import be.helb.cpopadiuc.dataAccess.DataAccessFight;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FightControllerIntegrationTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void testGetAllFights() {
        // Perform GET request to /fights/getAllFights
        List<FightDto> fights = given()
                .when()
                .get("/fights/getAllFights")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList(".", FightDto.class);

        // Validate the response
        given()
                .contentType("application/json")
                .when()
                .get("/fights/getAllFights")
                .then()
                .statusCode(200)
                .body("$", hasSize(equalTo(fights.size())));
    }
}
