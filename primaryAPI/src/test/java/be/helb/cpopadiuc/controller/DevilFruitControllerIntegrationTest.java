package be.helb.cpopadiuc.controller;

import be.helb.cpopadiuc.model.DevilFruit;
import be.helb.cpopadiuc.repository.DevilFruitRepository;
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
public class DevilFruitControllerIntegrationTest {

    @Autowired
    private DevilFruitRepository devilFruitRepository;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

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
        // delete it

        Long latestId = devilFruitRepository.findMaxId();

        given()
                .when()
                .delete("/api/devil-fruits/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("DevilFruit deleted successfully!"));
    }



    //  test to get a specific devil fruit by ID
    @Test
    public void testGetDevilFruitById() {
        Long latestId = devilFruitRepository.findMaxId();

        given()
                .when()
                .get("/api/devil-fruits/getByID/" + latestId)
                .then()
                .statusCode(200);
    }

    //  test to update a devil fruit by ID
    @Test
    public void testUpdateDevilFruit() {
        Long latestId = devilFruitRepository.findMaxId();

        DevilFruit updatedDevilFruit = new DevilFruit();
        updatedDevilFruit.setNameFruit("UpdatedTestDevilFruit");
        updatedDevilFruit.setAbilities("UpdatedTestAbilities");
        updatedDevilFruit.setType("UpdatedTestType");

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(updatedDevilFruit)
                .when()
                .put("/api/devil-fruits/put/" + latestId)
                .then()
                .statusCode(200)
                .body(equalTo("DevilFruit updated successfully!"));
    }
}
