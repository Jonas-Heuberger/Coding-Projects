USE Friseursalon
GO

INSERT INTO Kunde (Vorname, Nachname, Geburtsdatum, Geschlecht, Telefonnummer, Email, Adresse, PLZ, Ort, Land)
VALUES ('Max', 'Mustermann', '1990-01-01', 'm', '0123456789', '', 'email 1', '12345', 'Musterstadt', 'Deutschland')

INSERT INTO Kunde (Vorname, Nachname, Geburtsdatum, Geschlecht, Telefonnummer, Email, Adresse, PLZ, Ort, Land)
VALUES ('Max', 'Mustermann', '1990-02-01', 'w', '0123452389', '', 'email 1', '126745', 'Musterstadt', 'Deutschland')

INSERT INTO Kunde (Vorname, Nachname, Geburtsdatum, Geschlecht, Telefonnummer, Email, Adresse, PLZ, Ort, Land)
VALUES ('Max', 'Mustermann', '1990-03-01', 'm', '0123456789', '', 'email 1', '12345', 'Musterstadt', 'Deutschland')

INSERT INTO Dienstleistung (Name, Dauer, Preis, Beschreibung)
VALUES ('Dienstleistung 1', '1', '1', 'Beschreibung 1')

INSERT INTO Dienstleistung (Name, Dauer, Preis, Beschreibung)
VALUES ('Dienstleistung 2', '2', '2', 'Beschreibung 2')

INSERT INTO Dienstleistung (Name, Dauer, Preis, Beschreibung)
VALUES ('Dienstleistung 3', '3', '3', 'Beschreibung 3')

INSERT INTO Mitarbeiter (Vorname, Nachname, Aufgabe)
VALUES ('Mitarbeiter 1', 'Mitarbeiter 1', 'Assistent')

INSERT INTO Mitarbeiter (Vorname, Nachname, Aufgabe)
VALUES ('Mitarbeiter 2', 'Mitarbeiter 2', 'Stylist')

INSERT INTO Mitarbeiter (Vorname, Nachname, Aufgabe)
VALUES ('Mitarbeiter 3', 'Mitarbeiter 3', 'Assistent')