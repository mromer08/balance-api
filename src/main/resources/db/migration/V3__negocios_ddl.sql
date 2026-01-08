CREATE TABLE negocios (
    id UUID PRIMARY KEY,
    razon_social TEXT NOT NULL,
    contribuyente_id UUID NOT NULL,
    actividad_economica TEXT NOT NULL,
    estado TEXT NOT NULL DEFAULT 'ABIERTO',
    CONSTRAINT negocios_contribuyente_fk
        FOREIGN KEY (contribuyente_id) REFERENCES contribuyentes(id) ON DELETE CASCADE
);
