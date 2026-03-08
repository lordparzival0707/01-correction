TRUNCATE TABLE
t_notes_finales,
t_notes,
t_parametres,
t_differences,
t_resolutions,
t_operateurs,
t_correcteurs,
t_matieres,
t_etudiants RESTART IDENTITY;

INSERT INTO t_etudiants (nom, prenom) VALUES
('Rabeson', 'Yako');

INSERT INTO t_matieres (nom, coefficient) VALUES
('Maths', 6.0);


INSERT INTO t_correcteurs (nom, prenom) VALUES
('Rakoto', 'Jean'),
('Randria', 'Bruno'),
('Randria', 'Bruno');

INSERT INTO t_operateurs (libelle) VALUES
('superieur'),
('inferieur'),
('egal');

INSERT INTO t_resolutions (libelle) VALUES
('plus_grand'),
('plus_petit'),
('moyenne');

INSERT INTO t_differences (matiere_id, valeur) VALUES
(1, 5.0);

INSERT INTO t_parametres (difference_id, operateur_id, resolution_id) VALUES
(1, 1, 1),
(1, 2, 2),
(1, 3, 3);

INSERT INTO t_notes (etudiant_id, correcteur_id, matiere_id, valeur) VALUES
(1, 1, 1, 14.5),
(1, 2, 1, 16.0),
(1, 3, 1, 16.0);