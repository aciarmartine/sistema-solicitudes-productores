-- Base de datos del Sistema de Gestión de Solicitudes y Certificados
-- para Productores de Seguros

DROP DATABASE IF EXISTS sistema_solicitudes_productores;
CREATE DATABASE sistema_solicitudes_productores;

USE sistema_solicitudes_productores;

-- Tabla de usuarios del sistema
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    tipo_usuario VARCHAR(30) NOT NULL
);

-- Tabla de productores de seguros
CREATE TABLE productores (
    id_productor INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(50) NOT NULL,
    organizacion VARCHAR(100),
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Tabla de solicitudes realizadas por productores
CREATE TABLE solicitudes (
    id_solicitud INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    id_productor INT NOT NULL,
    id_operador INT,
    FOREIGN KEY (id_productor) REFERENCES productores(id_productor),
    FOREIGN KEY (id_operador) REFERENCES usuarios(id_usuario)
);

-- Tabla de historial de cambios de solicitudes
CREATE TABLE historial_solicitudes (
    id_historial INT AUTO_INCREMENT PRIMARY KEY,
    fecha_cambio DATETIME NOT NULL,
    observacion VARCHAR(255) NOT NULL,
    id_solicitud INT NOT NULL,
    FOREIGN KEY (id_solicitud) REFERENCES solicitudes(id_solicitud)
);

-- Inserción de usuarios de prueba
INSERT INTO usuarios (nombre, email, password, tipo_usuario)
VALUES 
('Juan Pérez', 'juan.perez@mail.com', '123456', 'PRODUCTOR'),
('María Gómez', 'maria.gomez@empresa.com', '123456', 'OPERADOR'),
('Carlos López', 'carlos.lopez@empresa.com', '123456', 'ADMINISTRADOR');

-- Inserción de productor de prueba
INSERT INTO productores (matricula, organizacion, id_usuario)
VALUES 
('MAT-001', 'Productores Asociados SRL', 1);

-- Inserción de solicitud de prueba
INSERT INTO solicitudes (fecha, descripcion, estado, id_productor, id_operador)
VALUES 
(NOW(), 'Solicitud de emisión de certificado de cobertura.', 'PENDIENTE', 1, 2);

-- Inserción de historial de solicitud
INSERT INTO historial_solicitudes (fecha_cambio, observacion, id_solicitud)
VALUES 
(NOW(), 'Solicitud registrada correctamente en el sistema.', 1);

-- Consulta de solicitudes registradas
SELECT 
    s.id_solicitud,
    s.fecha,
    u.nombre AS productor,
    s.descripcion,
    s.estado,
    op.nombre AS operador
FROM solicitudes s
INNER JOIN productores p ON s.id_productor = p.id_productor
INNER JOIN usuarios u ON p.id_usuario = u.id_usuario
LEFT JOIN usuarios op ON s.id_operador = op.id_usuario;

-- Borrado de registro de prueba del historial
DELETE FROM historial_solicitudes
WHERE id_historial = 1;

-- Consulta final para verificar registros restantes
SELECT * FROM usuarios;
SELECT * FROM productores;
SELECT * FROM solicitudes;
SELECT * FROM historial_solicitudes;
