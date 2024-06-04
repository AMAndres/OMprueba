--SELECT * FROM OMPRUEBA."ORDER";
--SELECT * FROM OMPRUEBA."ORDER_STATUS_ENUM";
--SELECT * FROM OMPRUEBA."PRODUCT";
--SELECT * FROM OMPRUEBA."ORDER_PRODUCT";

-------------------------------------------------------------------------------

-- ORDER STATUSES
INSERT INTO OMPRUEBA."ORDER_STATUS_ENUM" (STATUS, DESCRIPTION) VALUES
(1, 'PENDIENTE'),
(2, 'COBRADO'),
(3, 'ENVIADO'),
(4, 'RECIBIDO'),
(5, 'ANULADO')
;

-- PRODUCT TEST DATA (from requirements file)
INSERT INTO OMPRUEBA."PRODUCT" (NAME, DESCRIPTION, PRICE) VALUES
('Cemento', 'Saco de cemento Portland para construcción.', 25.00),
('Ladrillos', 'Paquete de ladrillos cerámicos para edificación.', 1.20),
('Madera para construcción', 'Tablones de madera tratada para uso en proyectos de construcción.', 15.00)
;

-- ORDER TEST DATA (from requirements file)
INSERT INTO OMPRUEBA."ORDER" (DATE, ITEMS, BASE_AMOUNT, AMOUNT, STATUS) VALUES
('2024-02-19 12:30:00+00', 2, 67.40, 77.51, 1),
('2024-02-19 14:45:00+00', 1, 1.20, 1.38, 5),
('2024-02-19 16:00:00+00', 3, 44.10, 50.76, 2)
;