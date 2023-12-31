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

        // delete it :
        Long latestId = fightTacticsRepository.findMaxId();

        given()
                .when()
                .delete("/api/fight-tactics/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("FightTactics deleted successfully!"));
    }


    //  test to get a specific fight tactics by ID
    @Test
    public void testGetFightTacticsById() {
        Long latestId = fightTacticsRepository.findMaxId();

        given()
                .when()
                .get("/api/fight-tactics/getByID/" + latestId)
                .then()
                .statusCode(200);
    }

    //  test to update a fight tactics by ID
    @Test
    public void testUpdateFightTactics() {
        Long latestId = fightTacticsRepository.findMaxId();

        FightTactics updatedFightTactics = new FightTactics();
        updatedFightTactics.setNameTactics("UpdatedTestFightTactics");
        updatedFightTactics.setType("UpdatedTestType");

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(updatedFightTactics)
                .when()
                .put("/api/fight-tactics/put/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("FightTactics updated successfully!"));
    }
}
