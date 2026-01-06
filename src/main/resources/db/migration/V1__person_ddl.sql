CREATE TABLE person (
    id UUID PRIMARY KEY,
    cui TEXT UNIQUE,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    honorific TEXT NOT NULL DEFAULT 'NONE',
    gender TEXT NOT NULL DEFAULT 'OTHER',
    phone_number TEXT,
    email TEXT,
    birth_date DATE,
    CONSTRAINT person_honorific_check CHECK (honorific IN (
        'NONE',
        'LICENSED_PROFESSIONAL',
        'ENGINEER',
        'DOCTOR',
        'ARCHITECT'
    )),
    CONSTRAINT person_gender_check CHECK (gender IN (
        'MALE',
        'FEMALE',
        'OTHER'
    ))
);
