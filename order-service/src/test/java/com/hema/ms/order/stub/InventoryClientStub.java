package com.hema.ms.order.stub;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryClientStub {

    public static void stubInventoryCall(String skuCode, Integer quantity) {

        MappingBuilder api = get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity));

        ResponseDefinitionBuilder response = aResponse()
                .withStatus(200)
                .withHeader("content-type", "application/json")
                .withBody("true");

        stubFor(api.willReturn(response));
    }
}
