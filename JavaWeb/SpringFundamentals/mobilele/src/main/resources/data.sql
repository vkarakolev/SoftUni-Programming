INSERT INTO `brands` (`id`, `brand`)
VALUES
    (1, 'Toyota'),
    (2, 'Ford');

INSERT INTO `models` (`id`, `brand_id`,`category`, `name`)
VALUES
    (1, 1, 'CAR', 'Corolla'),
    (2, 1, 'CAR', 'Camry'),
    (3, 2, 'CAR', 'Fiesta'),
    (4, 2, 'CAR', 'Focus');



