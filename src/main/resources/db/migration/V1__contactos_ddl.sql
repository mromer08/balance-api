CREATE TABLE contactos (
    id UUID PRIMARY KEY,
    nombres TEXT NOT NULL,
    apellidos TEXT NOT NULL,
    honorifico TEXT DEFAULT 'NINGUNO',
    genero TEXT DEFAULT 'OTRO',
    telefono TEXT NOT NULL UNIQUE,
    telefono_secundario TEXT,
    email TEXT UNIQUE
);
