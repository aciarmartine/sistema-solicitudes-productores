CREATE DATABASE sistema_solicitudes;

USE sistema_solicitudes;

CREATE TABLE solicitudes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productor VARCHAR(100),
    descripcion VARCHAR(255),
    estado VARCHAR(50)
);
