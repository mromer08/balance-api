CREATE TABLE contribuyentes (
    id UUID PRIMARY KEY,
    nit TEXT NOT NULL UNIQUE,
    nombre TEXT NOT NULL,
    tipo TEXT NOT NULL,
    regimen TEXT NOT NULL,
    tipo_empresa TEXT,
    estado TEXT NOT NULL DEFAULT 'ACTIVO',
    contacto_id UUID NOT NULL,
    fecha_nacimiento DATE,
    CONSTRAINT contribuyentes_contacto_fk
        FOREIGN KEY (contacto_id) REFERENCES contactos(id) ON DELETE SET NULL
);
