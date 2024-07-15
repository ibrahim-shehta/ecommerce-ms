package com.hema.ms.order.controller;

import com.hema.ms.order.stub.InventoryClientStub;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderControllerTest {

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
    void testInsertOrder() {

        String body = """
                {
                       "orderNumber": "22.00",
                       "price": 2000.0,
                       "quantity": 10,
                       "skuCode": "A"
                     }
                """;

        InventoryClientStub.stubInventoryCall("A", 10);

        RestAssured.given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("/api/order")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("id", Matchers.equalTo(1))
                .log().all();
        ;

    }
}