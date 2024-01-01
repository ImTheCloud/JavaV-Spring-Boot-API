package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.FightTactics;
import be.helb.cpopadiuc.repository.FightTacticsRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FightTacticsControllerIntegrationTest {

    @Autowired
    private FightTacticsRepository fightTacticsRepository;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    // Test to get all fight tactics
    @Test
    public void testGetAllFightTactics() {
        given()
                .when()
                .get("/api/fight-tactics")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    // Test to add a fight tactics
    @Test
    public void testAddFightTactics() {
        FightTactics fightTacticsToAdd = new FightTactics();
        fightTacticsToAdd.setNameTactics("TestFightTactics");
        fightTacticsToAdd.setType("TestType");

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(fightTacticsToAdd)
                .when()
                .post("/api/fight-tactics/add")
                .then()
                .statusCode(200)
                .body(equalTo("FightTactics added successfully!"));
    }

    // Test to delete a fight tactics
    @Test
    public void testDeleteFightTactics() {
        Long latestId = fightTacticsRepository.findMaxId();

        given()
                .when()
                .delete("/api/fight-tactics/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("FightTactics deleted successfully!"));
    }
}
