INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES(1, 'admin@gmail.com', 'Admin', 'Adminov', null, 1, '5dbb16b7397c2b5d7ef050a85c80cbfa8b838a1be91cce72657bb6ad8341ce8fa977787e3fc3c892');

INSERT INTO brands(id, name)
VALUES (1, 'Ford'), (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES  (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/1200px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg'),
        (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL_1.jpg'),
        (3, 'Yaris', 'CAR', 1999, null, 2, 'https://upload.wikimedia.org/wikipedia/commons/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg')
