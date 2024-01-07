package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Fight;
import be.helb.cpopadiuc.repository.FightRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FightControllerIntegrationTest {

    @Autowired
    private FightRepository fightRepository;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
    }

    // Test to get all fights
// Test to get all fights
    @Test
    public void testGetAllFights() {
        given()
                .when()
                .get("/fights/getAllFights")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(0));
    }


    // Test to add a fight
    @Test
    public void testAddFight() {
        Fight fightToAdd = new Fight();
        fightToAdd.setNameFighter1("Luffy");
        fightToAdd.setNameFighter2("Shanks");
        fightToAdd.setWinner("Luffy");

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(fightToAdd)
                .when()
                .post("/fights/addFight")
                .then()
                .statusCode(201)
                .body(equalTo("Fight added successfully!"));

        // Delete it
        Long latestId = fightRepository.findMaxId();

        given()
                .when()
                .delete("/fights/deleteFight/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("Fight deleted successfully!"));
    }

    // Test to get a specific fight by ID
    @Test
    public void testGetFightById() {
        given()
                .when()
                .get("/fights/findFight/" + 1)
                .then()
                .statusCode(200);
    }
}
