package com.hema.ms.inventory.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryControllerTest {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");


    static {
        mySQLContainer.start();
    }

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void testInventory() {

        RestAssured.given()
                .contentType("application/json")
                .param("skuCode", "A")
                .param("quantity", 100)
                .when()
                .get("/api/inventory")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value());
//                .extract().response().as(Boolean.class);

        RestAssured.given()
                .contentType("application/json")
                .param("skuCode", "A")
                .param("quantity", 2)
                .when()
                .get("/api/inventory")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value());
        ;

    }
}