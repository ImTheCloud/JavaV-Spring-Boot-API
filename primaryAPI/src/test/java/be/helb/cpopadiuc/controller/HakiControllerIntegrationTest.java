package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.Haki;
import be.helb.cpopadiuc.repository.HakiRepository;
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
public class HakiControllerIntegrationTest {

    @Autowired
    private HakiRepository hakiRepository;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    // Test to get all haki
    @Test
    public void testGetAllHaki() {
        given()
                .when()
                .get("/api/haki")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    // Test to add a haki
    @Test
    public void testAddHaki() {
        Haki hakiToAdd = new Haki();
        hakiToAdd.setNameHaki("TestHaki");
        hakiToAdd.setDescriptionHaki("TestDescription");

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(hakiToAdd)
                .when()
                .post("/api/haki/add")
                .then()
                .statusCode(200)
                .body(equalTo("Haki added successfully!"));
    }

    // Test to delete a haki
    @Test
    public void testDeleteHaki() {
        Long latestId = hakiRepository.findMaxId();

        given()
                .when()
                .delete("/api/haki/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("Haki deleted successfully!"));
    }
    //  test to get a specific Haki by ID
    @Test
    public void testGetHakiById() {
        Long latestId = hakiRepository.findMaxId();

        given()
                .when()
                .get("/api/haki/" + latestId)
                .then()
                .statusCode(200);
    }

    //  test to update a Haki by ID
    @Test
    public void testUpdateHaki() {
        Long latestId = hakiRepository.findMaxId();

        Haki updatedHaki = new Haki();
        updatedHaki.setNameHaki("UpdatedTestHaki");
        updatedHaki.setDescriptionHaki("UpdatedTestDescription");

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(updatedHaki)
                .when()
                .put("/api/haki/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("Haki updated successfully!"));
    }
}
