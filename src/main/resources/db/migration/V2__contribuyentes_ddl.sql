CREATE TABLE contribuyentes (
    id UUID PRIMARY KEY,
    nit TEXT NOT NULL UNIQUE,
    razon_social TEXT NOT NULL,
    tipo TEXT NOT NULL,
    regimen TEXT NOT NULL,
    tipo_empresa TEXT,
    estado TEXT NOT NULL,
    renta_bruta TEXT NOT NULL,
    representante_id UUID NOT NULL,
    fecha_apertura DATE,
    CONSTRAINT contribuyentes_representante_fk
        FOREIGN KEY (representante_id) REFERENCES personas(id) ON DELETE SET NULL
);
