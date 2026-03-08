-- Table des étudiants
CREATE TABLE t_etudiants (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL
);

-- Table des correcteurs
CREATE TABLE t_correcteurs (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL
);

-- Table des matières
CREATE TABLE t_matieres (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    coefficient NUMERIC(5,2) NOT NULL
);

-- Table des résolutions
CREATE TABLE t_resolutions (
    id SERIAL PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL
);

-- Table des opérateurs
CREATE TABLE t_operateurs (
    id SERIAL PRIMARY KEY,
    libelle VARCHAR(10) NOT NULL
);

-- Table des différences
CREATE TABLE t_differences (
    id SERIAL PRIMARY KEY,
    matiere_id INT NOT NULL,
    valeur NUMERIC(10,2) NOT NULL,
    
    CONSTRAINT fk_differences_matiere
        FOREIGN KEY (matiere_id)
        REFERENCES t_matieres(id)
);

-- Table des paramètres
CREATE TABLE t_parametres (
    id SERIAL PRIMARY KEY,
    difference_id INT NOT NULL,
    operateur_id INT NOT NULL,
    resolution_id INT NOT NULL,

    CONSTRAINT fk_param_diff
        FOREIGN KEY (difference_id)
        REFERENCES t_differences(id),

    CONSTRAINT fk_param_oper
        FOREIGN KEY (operateur_id)
        REFERENCES t_operateurs(id),

    CONSTRAINT fk_param_res
        FOREIGN KEY (resolution_id)
        REFERENCES t_resolutions(id)
);

-- Table des notes
CREATE TABLE t_notes (
    id SERIAL PRIMARY KEY,
    etudiant_id INT NOT NULL,
    correcteur_id INT NOT NULL,
    matiere_id INT NOT NULL,
    valeur NUMERIC(5,2) NOT NULL,

    CONSTRAINT fk_notes_etudiant
        FOREIGN KEY (etudiant_id)
        REFERENCES t_etudiants(id),

    CONSTRAINT fk_notes_correcteur
        FOREIGN KEY (correcteur_id)
        REFERENCES t_correcteurs(id),

    CONSTRAINT fk_notes_matiere
        FOREIGN KEY (matiere_id)
        REFERENCES t_matieres(id)
);

-- Table des notes finales
CREATE TABLE t_notes_finales (
    id SERIAL PRIMARY KEY,
    etudiant_id INT NOT NULL,
    matiere_id INT NOT NULL,
    valeur NUMERIC(5,2) NOT NULL,

    CONSTRAINT fk_finale_etudiant
        FOREIGN KEY (etudiant_id)
        REFERENCES t_etudiants(id),

    CONSTRAINT fk_finale_matiere
        FOREIGN KEY (matiere_id)
        REFERENCES t_matieres(id)
);