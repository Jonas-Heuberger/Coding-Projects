USE Friseursalon
GO

INSERT INTO tbl_Kunde (Vorname, Nachname, Geburtsdatum, Telefonnummer, Email, Adresse, PLZ, Ort, )
VALUES ('Max', 'Mustermann', '1990-01-01', '0123456789', '', 'email 1', '12345', 'Musterstadt')

INSERT INTO tbl_Kunde (Vorname, Nachname, Geburtsdatum, Telefonnummer, Email, Adresse, PLZ, Ort)
VALUES ('Max', 'Mustermann', '1990-02-01', '0123452389', '', 'email 1', '126745', 'Musterstadt')

INSERT INTO tbl_Kunde (Vorname, Nachname, Geburtsdatum, Telefonnummer, Email, Adresse, PLZ, Ort)
VALUES ('Max', 'Mustermann', '1990-03-01', '0123456789', '', 'email 1', '12345', 'Musterstadt')

INSERT INTO tbl_Dienstleistung (Name, Dauer, Preis, Beschreibung)
VALUES ('Dienstleistung 1', '1', '1', 'Beschreibung 1')

INSERT INTO tbl_Dienstleistung (Name, Dauer, Preis, Beschreibung)
VALUES ('Dienstleistung 2', '2', '2', 'Beschreibung 2')

INSERT INTO tbl_Dienstleistung (Name, Dauer, Preis, Beschreibung)
VALUES ('Dienstleistung 3', '3', '3', 'Beschreibung 3')

INSERT INTO tbl_Mitarbeiter (Vorname, Nachname, Aufgabe)
VALUES ('Mitarbeiter 1', 'Mitarbeiter 1', 'Assistent')

INSERT INTO tbl_Mitarbeiter (Vorname, Nachname, Aufgabe)
VALUES ('Mitarbeiter 2', 'Mitarbeiter 2', 'Stylist')

INSERT INTO tbl_Mitarbeiter (Vorname, Nachname, Aufgabe)
VALUES ('Mitarbeiter 3', 'Mitarbeiter 3', 'Assistent')