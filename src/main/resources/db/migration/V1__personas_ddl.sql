CREATE TABLE personas (
    id UUID PRIMARY KEY,
    nit TEXT NOT NULL UNIQUE,
    cui TEXT UNIQUE,
    nombres TEXT NOT NULL,
    apellidos TEXT NOT NULL,
    honorifico TEXT DEFAULT 'NINGUNO',
    genero TEXT DEFAULT 'OTRO',
    telefono TEXT,
    email TEXT,
    fecha_nacimiento DATE
);
