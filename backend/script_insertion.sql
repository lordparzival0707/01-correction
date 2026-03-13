TRUNCATE TABLE
t_notes_finales,
t_notes,
t_parametres,
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
('<'),
('<='),
('>'),
('>=');

INSERT INTO t_resolutions (libelle) VALUES
('plus_petit'),
('plus_grand'),
('moyenne');

INSERT INTO t_parametres (matiere_id, seuil, operateur_id, resolution_id) VALUES
(1, 5, 3, 2),
(1, 10, 1, 1);

INSERT INTO t_notes (etudiant_id, correcteur_id, matiere_id, valeur) VALUES
(1, 1, 1, 10),
(1, 2, 1, 17);