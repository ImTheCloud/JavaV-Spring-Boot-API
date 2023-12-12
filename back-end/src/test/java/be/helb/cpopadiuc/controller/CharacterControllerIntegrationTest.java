package be.helb.cpopadiuc.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import be.helb.cpopadiuc.model.Character;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CharacterControllerIntegrationTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void testGetAllCharacters() {
        given()
                .when()
                .get("/api/characters")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

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

    @Test
    public void testDeleteCharacter() {
        testAddCharacter();

        given()
                .when()
                .delete("/api/characters/10")
                .then()
                .statusCode(200)
                .body(equalTo("Character deleted successfully!"));
    }
}
