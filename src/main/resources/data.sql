-- -----------------------------------------------------
-- Data Insertions
-- -----------------------------------------------------

-- Table Usuario --
INSERT INTO
usuario (rut, nombre, apellido_paterno, apellido_materno, correo, carrera, facultad, ingreso, rol)
VALUES
('17982236-2',"benjamin","sepulveda","campo","benja.sepulveda@usach.cl","civil electrica","ingenieria",2013,1),
('18945812-0',"arturo","longton","pendragon","arturo.longton@usach.cl","civil obras civiles","ingenieria",2012,1),
('19246385-6',"shaquito","mota","naco","shaquito.mota@usach.cl","civil metalurgia","ingenieria",2011,1),
('19655316-9',"elsa","pato","roto","elsa.pato@usach.cl","civil industrial","ingenieria",2010,1),
('18967512-k',"ariel","cloro","serrano","ariel.cloro@usach.cl","civil informatica","ingenieria",2014,1);

-- Table Enunciado --
INSERT INTO
enunciado (enunciado)
VALUES
("Mestre por pantalla el texto, oe que ordinario"),
("Muestre la summatoria de los 10 primeros numeros naturales de forma iterativa"),
("Realice la funcion de fibonacci con 1 parametro de entrada"),
("Realice una funcion que calcule el factorial de 5"),
("Genere una funcion que al pasar los lados de un triangulo, calcule su area")

-- Table Coordinacion --
INSERT INTO
coordinacion (id_coordinacion)
VALUES
(1),
(2),
(3),
(4),
(5),
(6)

-- Table Prueba --
INSERT INTO
prueba (argumento, resultado, id_enunciado)
VALUES
("mensajePorPantalla()", "oe que ordinario", 1),
("sumatoria(10)", "55", 2),
("fibonacci(4)", "3", 3),
("factorial(5)", "120", 4),
("area(2, 2)", "2", 5)
