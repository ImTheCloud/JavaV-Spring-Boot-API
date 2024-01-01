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
    }

    // Test to delete a crew
    @Test
    public void testDeleteCrew() {
        Long latestId = crewRepository.findMaxId();

        given()
                .when()
                .delete("/api/crews/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("Crew deleted successfully!"));
    }
}
