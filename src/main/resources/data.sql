INSERT INTO grafos(id, name) VALUES (1, 'Grafo A');

-- Insertar Rotondas
INSERT INTO rotondas (id, name) VALUES (1, 'Rotonda A');
INSERT INTO rotondas (id, name) VALUES (2, 'Rotonda B');
INSERT INTO rotondas (id, name) VALUES (3, 'Rotonda C');
INSERT INTO rotondas (id, name) VALUES (4, 'Rotonda D');

-- Insertar Vértices
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (1, 'V1A', 1, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (2, 'V2A', 1, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (3, 'V3A', 1, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (4, 'V4A', 1, 1);

INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (5, 'V1B', 2, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (6, 'V2B', 2, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (7, 'V3B', 2, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (8, 'V4B', 2, 1);

INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (9, 'V1C', 3, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (10, 'V2C', 3, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (11, 'V3C', 3, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (12, 'V4C', 3, 1);

INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (13, 'V1D', 4, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (14, 'V2D', 4, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (15, 'V3D', 4, 1);
INSERT INTO vertices_rotonda (id, name, rotonda_id, grafo_id) VALUES (16, 'V4D', 4, 1);


-- Insertar Aristas (Conexiones)
INSERT INTO aristas (id, origen_id, destino_id, distancia, grafo_id) VALUES (1, 3, 5, 10.0, 1);
INSERT INTO aristas (id, origen_id, destino_id, distancia, grafo_id) VALUES (2, 6, 12, 12.0, 1);
INSERT INTO aristas (id, origen_id, destino_id, distancia, grafo_id) VALUES (3, 9, 15, 15.0, 1);
INSERT INTO aristas (id, origen_id, destino_id, distancia, grafo_id) VALUES (4, 16, 2, 20.0, 1);