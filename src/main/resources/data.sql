-- Initial dataload into h2 
INSERT INTO item (id, name, description, price, reviews_quantity)
VALUES (1, 'Item1', 'Items1 description', 10.2, 5),
    (2, 'Item2', 'Items2 description', 5, 10),
    (3, 'Item3', 'Items3 description', 12.5, 7),
    (4, 'Item4', 'Items4 description', 18.0, 3),
    (5, 'Item5', 'Items5 description', 9.75, 12),
    (6, 'Item6', 'Items6 description', 22.0, 8),
    (7, 'Item7', 'Items7 description', 14.99, 6),
    (8, 'Item8', 'Items8 description', 7.5, 15),
    (9, 'Item9', 'Items9 description', 25.0, 4),
    (10, 'Item10', 'Items10 description', 16.25, 9),
    (
        11,
        'Laptop Pro 14',
        'Ultra-light business laptop with 14-inch display',
        1299.99,
        24
    ),
    (
        12,
        'Wireless Headphones',
        'Noise-cancelling over-ear headphones with deep bass',
        199.5,
        41
    ),
    (
        13,
        'Smart Watch X',
        'Fitness and health tracking smartwatch with AMOLED display',
        249.0,
        19
    ),
    (
        14,
        'Coffee Grinder',
        'Premium burr grinder for fresh coffee every morning',
        89.99,
        13
    ),
    (
        15,
        'Gaming Mouse',
        'RGB gaming mouse with adjustable DPI settings',
        59.0,
        36
    ),
    (
        16,
        'Bluetooth Speaker',
        'Portable waterproof speaker with rich surround sound',
        79.95,
        27
    ),
    (
        17,
        'Desk Lamp',
        'Modern LED lamp with touch dimming and USB charging',
        45.75,
        18
    ),
    (
        18,
        'Travel Backpack',
        'Water-resistant backpack with laptopcompartment',
        119.0,
        22
    );