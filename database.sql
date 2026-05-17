CREATE DATABASE sistema_solicitudes;

USE sistema_solicitudes;

CREATE TABLE solicitudes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    productor VARCHAR(100),
    descripcion VARCHAR(255),
    estado VARCHAR(50)
);

-- Inserción de datos de prueba

INSERT INTO usuarios (nombre, email, password, tipo_usuario)
VALUES 
('Juan Pérez', 'juan.perez@mail.com', '123456', 'PRODUCTOR'),
('María Gómez', 'maria.gomez@empresa.com', '123456', 'OPERADOR'),
('Carlos López', 'carlos.lopez@empresa.com', '123456', 'ADMINISTRADOR');

INSERT INTO productores (matricula, organizacion, id_usuario)
VALUES 
('MAT-001', 'Productores Asociados SRL', 1);

INSERT INTO solicitudes (fecha, descripcion, estado, id_productor, id_operador)
VALUES 
(NOW(), 'Solicitud de emisión de certificado de cobertura.', 'PENDIENTE', 1, 2);

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


-- Borrado de registro de prueba

DELETE FROM historial_solicitudes
WHERE id_historial = 1;
