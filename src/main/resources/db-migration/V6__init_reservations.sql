INSERT INTO reservation (customer_id, car_id, rent_date, return_date, from_department_id, to_department_id, rent_worker_id, receive_worker_id, reservation_status, total_cost, version)
VALUES
(1, 15, NOW()+INTERVAL 3 DAY, NOW()+INTERVAL 10 DAY, 1, 1, 2, 3, 'CREATED', 100, 1),
(2, 2, NOW()+INTERVAL 3 DAY, NOW()+INTERVAL 10 DAY, 1, 2, 3, 6, 'CREATED', 101, 1),
(3, 14, NOW()+INTERVAL 3 DAY, NOW()+INTERVAL 10 DAY, 2, 2, 5, 6, 'CREATED', 102, 1),
(4, 6, NOW()+INTERVAL 3 DAY, NOW()+INTERVAL 10 DAY, 2, 3, 6, 8, 'CREATED', 103, 1),
(5, 10, NOW()+INTERVAL 3 DAY, NOW()+INTERVAL 10 DAY, 3, 3, 8, 8, 'CREATED', 104, 1),
(6, 20, NOW()+INTERVAL 3 DAY, NOW()+INTERVAL 10 DAY, 3, 4, 9, 11, 'CREATED', 105, 1),
(7, 18, NOW()+INTERVAL 3 DAY, NOW()+INTERVAL 10 DAY, 4, 4, 12, 12, 'CREATED', 106, 1),
(8, 17, NOW()+INTERVAL 3 DAY, NOW()+INTERVAL 10 DAY, 4, 5, 11, 14, 'CREATED', 107, 1),
(9, 8, NOW()+INTERVAL 3 DAY, NOW()+INTERVAL 10 DAY, 5, 5, 15, 14, 'CREATED', 108, 1),
(10, 4, NOW()+INTERVAL 3 DAY, NOW()+INTERVAL 10 DAY, 4, 2, 11, 5, 'CREATED', 109, 1);