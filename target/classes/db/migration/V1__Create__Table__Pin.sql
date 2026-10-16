CREATE TABLE IF NOT EXISTS `pins` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,

    `latitude` DOUBLE NOT NULL,
    `longitude` DOUBLE NOT NULL,
    `name` VARCHAR(100) NOT NULL,

    `location_type` VARCHAR(50),
    `is_safe` BOOLEAN,
    `easy_access` BOOLEAN,
    `star_visibility` VARCHAR(50),

    `uap_sighting` BOOLEAN,
    `uap_sighting_datetime` DATETIME,

    `significant_moment` TEXT,

    `created_at` DATETIME NOT NULL,

    PRIMARY KEY (`id`)
);