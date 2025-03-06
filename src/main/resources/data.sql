INSERT INTO rotondas (id, name) VALUES (1, 'Rotonda 1');
INSERT INTO rotondas (id, name) VALUES (2, 'Rotonda 2');
INSERT INTO rotondas (id, name) VALUES (3, 'Rotonda 3');
INSERT INTO rotondas (id, name) VALUES (4, 'Rotonda 4');

INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (1, 'Vertice 1.1', 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (2, 'Vertice 1.2', 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (3, 'Vertice 1.3', 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (4, 'Vertice 1.4', 1);

INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (5, 'Vertice 2.1', 2);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (6, 'Vertice 2.2', 2);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (7, 'Vertice 2.3', 2);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (8, 'Vertice 2.4', 2);

INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (9, 'Vertice 3.1', 3);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (10, 'Vertice 3.2', 3);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (11, 'Vertice 3.3', 3);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (12, 'Vertice 3.4', 3);

INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (13, 'Vertice 4.1', 4);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (14, 'Vertice 4.2', 4);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (15, 'Vertice 4.3', 4);
INSERT INTO vertices_rotonda (id, name, rotonda_id) VALUES (16, 'Vertice 4.4', 4);

INSERT INTO aristas (id, origen_id, destino_id, distancia) VALUES (1, 4, 6, 10);
INSERT INTO aristas (id, origen_id, destino_id, distancia) VALUES (2, 5, 11, 100);
INSERT INTO aristas (id, origen_id, destino_id, distancia) VALUES (3, 10, 16, 200);
INSERT INTO aristas (id, origen_id, destino_id, distancia) VALUES (4, 15, 1, 300);