CREATE TABLE `inventory` (
     `id` bigint NOT NULL AUTO_INCREMENT,
     `quantity` int DEFAULT NULL,
     `sku_code` varchar(255) DEFAULT NULL,
     PRIMARY KEY (`id`)
)