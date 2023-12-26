package be.helb.cpopadiuc.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import be.helb.cpopadiuc.model.Character;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

// Annotation to specify the Spring Boot test configuration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CharacterControllerIntegrationTest {

    // Setup method to configure RestAssured before running tests
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    // Test to get all characters
    @Test
    public void testGetAllCharacters() {
        given()
                .when()
                .get("/api/characters")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    // Test to add a character
    @Test
    public void testAddCharacter() {
        // Create a Character object to be added in your test
        Character characterToAdd = new Character();
        characterToAdd.setName("TestCharacter");
        characterToAdd.setRank("TestRank");
        characterToAdd.setJob("TestJob");
        characterToAdd.setBounty(1000000L); // Set an appropriate bounty value
        characterToAdd.setImageUrl("http://example.com/test_image.jpg");

        given()
                .contentType("application/json")
                .body(characterToAdd)
                .when()
                .post("/api/characters/add")
                .then()
                .statusCode(200)
                .body(equalTo("Character added successfully!"));
    }

    // Test to delete a character
    @Test
    public void testDeleteCharacter() {
        // Execute the add character test to have a character to delete
        testAddCharacter();

        given()
                .when()
                .delete("/api/characters/53")
                .then()
                .statusCode(200)
                .body(equalTo("Character deleted successfully!"));
    }

    // Test to get characters by crew
    @Test
    public void testGetCharactersByCrew() {
        given()
                .when()
                .get("/api/characters/byCrew/{crewId}", 1)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    // Test to get characters by job
    @Test
    public void testGetCharactersByJob() {
        given()
                .when()
                .get("/api/characters/byJob/{job}", "TestJob")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    // Test to get characters by rank
    @Test
    public void testGetCharactersByRank() {
        given()
                .when()
                .get("/api/characters/byRank/{rank}", "TestRank")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    // Test to get characters with high bounty and no Devil Fruit
    @Test
    public void testGetCharactersWithHighBountyAndNoDevilFruit() {
        given()
                .when()
                .get("/api/characters/highBountyAndNoDevilFruit")
                .then()
                .statusCode(200)
                .body("size()", equalTo(1));
    }
}
