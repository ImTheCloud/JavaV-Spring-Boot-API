package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.*;
import be.helb.cpopadiuc.model.Character;
import be.helb.cpopadiuc.repository.CharacterRepository;
import be.helb.cpopadiuc.repository.CrewRepository;
import be.helb.cpopadiuc.repository.FightTacticsRepository;
import be.helb.cpopadiuc.repository.HakiRepository;
import be.helb.cpopadiuc.repository.DevilFruitRepository;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

// Annotation to specify the Spring Boot test configuration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CharacterControllerIntegrationTest {

    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CrewRepository crewRepository;
    @Autowired
    private HakiRepository hakiRepository;
    @Autowired
    private FightTacticsRepository fightTacticsRepository;
    @Autowired
    private DevilFruitRepository devilFruitRepository;

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
        Long latestId = characterRepository.findMaxId();

        given()
                .when()
                .delete("/api/characters/"+latestId)
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

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TEST CREWS

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
// Test to add a crew
    @Test
    public void testAddCrew() {
        Crew crewToAdd = new Crew();
        crewToAdd.setNameCrew("TestCrew");
        crewToAdd.setShipName("TestShipName");
        crewToAdd.setNumberPirate(5);

        given()
                .contentType("application/json")
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
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        hakiToAdd.setDescriptionHaki("TesstDescription");

        given()
                .contentType("application/json")
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
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Test to get all devil fruits
    @Test
    public void testGetAllDevilFruits() {
        given()
                .when()
                .get("/api/devil-fruits")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    // Test to add a devil fruit
    @Test
    public void testAddDevilFruit() {
        DevilFruit devilFruitToAdd = new DevilFruit();
        devilFruitToAdd.setNameFruit("TestDevilFruit");
        devilFruitToAdd.setAbilities("TestAbilities");
        devilFruitToAdd.setType("TestType");

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(devilFruitToAdd)
                .when()
                .post("/api/devil-fruits/add")
                .then()
                .statusCode(200)
                .body(equalTo("DevilFruit added successfully!"));
    }

    // Test to delete a devil fruit
    @Test
    public void testDeleteDevilFruit() {
        Long latestId = devilFruitRepository.findMaxId();

        given()
                .when()
                .delete("/api/devil-fruits/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("DevilFruit deleted successfully!"));
    }
}
