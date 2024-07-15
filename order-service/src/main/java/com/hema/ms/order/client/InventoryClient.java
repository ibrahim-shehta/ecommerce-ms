package com.hema.ms.order.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

//@FeignClient(name = "inventory-client", url = "${application.ms.base.urls.inventory}")
public interface InventoryClient {

//    @GetMapping("/api/inventory")
    @GetExchange("/api/inventory")
    @CircuitBreaker(name="inventory", fallbackMethod = "inventoryFallBack")
    @Retry(name = "inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);


    default boolean inventoryFallBack(String skuCode, Integer quantity, Throwable throwable) {
        System.out.println("api: /api/inventory does not response because of " + throwable.getMessage());
        return false;
    }
}
