CREATE TABLE `orders` (
          `id` bigint NOT NULL AUTO_INCREMENT,
          `order_number` varchar(255) DEFAULT NULL,
          `price` decimal(38,2) DEFAULT NULL,
          `quantity` int DEFAULT NULL,
          `sku_code` varchar(255) DEFAULT NULL,
          PRIMARY KEY (`id`)
);