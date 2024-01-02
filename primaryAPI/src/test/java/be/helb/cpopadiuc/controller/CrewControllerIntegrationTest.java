package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Crew;
import be.helb.cpopadiuc.repository.CrewRepository;
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
public class CrewControllerIntegrationTest {

    @Autowired
    private CrewRepository crewRepository;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    // Test to get all crews
    @Test
    public void testGetAllCrews() {
        given()
                .when()
                .get("/api/crews")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    // Test to add a crew
    @Test
    public void testAddCrew() {
        Crew crewToAdd = new Crew();
        crewToAdd.setNameCrew("TestCrew");
        crewToAdd.setShipName("TestShipName");
        crewToAdd.setNumberPirate(5);

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(crewToAdd)
                .when()
                .post("/api/crews/add")
                .then()
                .statusCode(200)
                .body(equalTo("Crew added successfully!"));

        // Delete it
        Long latestId = crewRepository.findMaxId();

        given()
                .when()
                .delete("/api/crews/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("Crew deleted successfully!"));
    }

    // Test to get a specific crew by ID
    @Test
    public void testGetCrewById() {
        given()
                .when()
                .get("/api/crews/getByID/" + 1)
                .then()
                .statusCode(200);
    }

    // Test to update a crew by ID
    @Test
    public void testUpdateCrew() {
        // Assume there is at least one crew in the database for testing
        Long latestId = crewRepository.findMaxId();

        Crew updatedCrew = new Crew();
        updatedCrew.setNameCrew("UpdatedTestCrew");
        updatedCrew.setShipName("UpdatedTestShipName");
        updatedCrew.setNumberPirate(10);

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(updatedCrew)
                .when()
                .put("/api/crews/put/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("Crew updated successfully!"));
    }
}
