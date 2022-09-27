CREATE DATABASE Friseursalon
GO

USE Friseursalon
GO

CREATE TABLE tbl_Lieferfirma
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Lieferfirma PRIMARY KEY
    CONSTRAINT DF_tbl_Lieferfirma_rowguid DEFAULT (newid()),
    Firmenname NVARCHAR(50) NOT NULL,
    Artikel VARCHAR(50) NOT NULL,
    Preis DECIMAL(10,2) NOT NULL,
)
GO

CREATE TABLE tbl_Artikel
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Artikel PRIMARY KEY
    CONSTRAINT DF_tbl_Artikel_rowguid DEFAULT (newid()),
    Artikelname NVARCHAR(50) NOT NULL,
    Preis DECIMAL(10,2) NOT NULL,
    Lieferfirma UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Artikel_tbl_Lieferfirma FOREIGN KEY (Lieferfirma) REFERENCES tbl_Lieferfirma(rowguid)
)
GO

CREATE TABLE tbl_Dienstleistung
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Dienstleistung PRIMARY KEY
    CONSTRAINT DF_tbl_Dienstleistung_rowguid DEFAULT (newid()),
    Dienstleistungname NVARCHAR(50) NOT NULL,
    Preis DECIMAL(10,2) NOT NULL,
)
GO

CREATE TABLE tbl_Abonnements
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Abonnements PRIMARY KEY
    CONSTRAINT DF_tbl_Abonnements_rowguid DEFAULT (newid()),
    Abonnementname NVARCHAR(50) NOT NULL,
    Preis DECIMAL(10,2) NOT NULL,
    Dienstleistung UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Abonnements_tbl_Dienstleistung FOREIGN KEY (Dienstleistung) REFERENCES tbl_Dienstleistung(rowguid)
)
GO



CREATE TABLE tbl_Mitarbeiter
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Mitarbeiter PRIMARY KEY
    CONSTRAINT DF_tbl_Mitarbeiter_rowguid DEFAULT (newid()),
    Vorname NVARCHAR(50) NOT NULL,
    Nachname NVARCHAR(50) NOT NULL,
    Aufgabe NVARCHAR(50) NOT NULL,
)
GO

CREATE TABLE tbl_Kunde
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Kunde PRIMARY KEY
    CONSTRAINT DF_tbl_Kunde_rowguid DEFAULT (newid()),
    Vorname NVARCHAR(50) NOT NULL,
    Nachname NVARCHAR(50) NOT NULL,
    Telefonnummer NVARCHAR(50) NOT NULL,
    EMail NVARCHAR(50) NOT NULL,
    Geburtsdatum DATE NOT NULL,
    Adresse NVARCHAR(50) NOT NULL,
    PLZ NVARCHAR(50) NOT NULL,
    Ort NVARCHAR(50) NOT NULL,
    StylistID UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Kunde_tbl_Mitarbeiter FOREIGN KEY (StylistID) REFERENCES tbl_Mitarbeiter(rowguid)
)
GO

CREATE TABLE tbl_Chemie
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Chemie PRIMARY KEY
    CONSTRAINT DF_tbl_Chemie_rowguid DEFAULT (newid()),
    ChemieName NVARCHAR(50) NOT NULL,
    Preis DECIMAL(10,2) NOT NULL,
)
GO

CREATE TABLE tbl_Auspraegung
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Auspraegung PRIMARY KEY
    CONSTRAINT DF_tbl_Auspraegung_rowguid DEFAULT (newid()),
    AuspraegungName NVARCHAR(50) NOT NULL,
    Preis DECIMAL(10,2) NOT NULL,
)
GO

CREATE TABLE tbl_Anwesenheit
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Termin PRIMARY KEY
    CONSTRAINT DF_tbl_Termin_rowguid DEFAULT (newid()),
    Datum DATE NOT NULL,
    Uhrzeit TIME NOT NULL,
    Dauer TIME NOT NULL,
)
GO

CREATE TABLE tbl_Assistent
(
    rowguid UNIQUEIDENTIFIER PRIMARY KEY NOT NULL
        FOREIGN KEY (rowguid) REFERENCES tbl_Mitarbeiter(rowguid),   
)
GO

CREATE TABLE tbL_Stylist
(
    rowguid UNIQUEIDENTIFIER PRIMARY KEY NOT NULL
        FOREIGN KEY (rowguid) REFERENCES tbl_Mitarbeiter(rowguid),
)
GO

CREATE TABLE tbl_Kunde_kauft_Artikel
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Kunde_kauft_Artikel PRIMARY KEY
        CONSTRAINT DF_tbl_Kunde_kauft_Artikel_rowguid DEFAULT (newid()),
    Kunde UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Kunde_kauft_Artikel_tbl_Kunde FOREIGN KEY (Kunde) REFERENCES tbl_Kunde(rowguid),
    Artikel UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Kunde_kauft_Artikel_tbl_Artikel FOREIGN KEY (Artikel) REFERENCES tbl_Artikel(rowguid),
)
GO

CREATE TABLE tbl_Kunde_bezieht_tbl_Dienstleistung_durch_tbl_Stylist
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Kunde_bezieht_tbl_Dienstleistung PRIMARY KEY
        CONSTRAINT DF_tbl_Kunde_bezieht_tbl_Dienstleistung_rowguid DEFAULT (newid()),
    Kunde UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Kunde_bezieht_tbl_Dienstleistung_tbl_Kunde FOREIGN KEY (Kunde) REFERENCES tbl_Kunde(rowguid),
    Dienstleistung UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Kunde_bezieht_tbl_Dienstleistung_tbl_Dienstleistung FOREIGN KEY (Dienstleistung) REFERENCES tbl_Dienstleistung(rowguid),
    Stylist UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Kunde_bezieht_tbl_Dienstleistung_tbl_Stylist FOREIGN KEY (Stylist) REFERENCES tbl_Stylist(rowguid),
)
GO

CREATE TABLE tbl_Kunde_erwirbt_tbl_Abonnements
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Kunde_erwirbt_tbl_Abonnements PRIMARY KEY
        CONSTRAINT DF_tbl_Kunde_erwirbt_tbl_Abonnements_rowguid DEFAULT (newid()),
    Kunde UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Kunde_erwirbt_tbl_Abonnements_tbl_Kunde FOREIGN KEY (Kunde) REFERENCES tbl_Kunde(rowguid),
    Abonnement UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Kunde_erwirbt_tbl_Abonnements_tbl_Abonnements FOREIGN KEY (Abonnement) REFERENCES tbl_Abonnements(rowguid),
)
GO

CREATE TABLE tbl_Stylist_hat_tbl_Assistent
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Stylist_hat_tbl_Assistent PRIMARY KEY
        CONSTRAINT DF_tbl_Stylist_hat_tbl_Assistent_rowguid DEFAULT (newid()),
    Stylist UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Stylist_hat_tbl_Assistent_tbl_Stylist FOREIGN KEY (Stylist) REFERENCES tbl_Stylist(rowguid),
    Assistent UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Stylist_hat_tbl_Assistent_tbl_Assistent FOREIGN KEY (Assistent) REFERENCES tbl_Assistent(rowguid),
)
GO

CREATE TABLE tbl_Mitarbeiter_haben_tbl_Anwesenheit
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Mitarbeiter_haben_tbl_Anwesenheit PRIMARY KEY
        CONSTRAINT DF_tbl_Mitarbeiter_haben_tbl_Anwesenheit_rowguid DEFAULT (newid()),
    Mitarbeiter UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Mitarbeiter_haben_tbl_Anwesenheit_tbl_Mitarbeiter FOREIGN KEY (Mitarbeiter) REFERENCES tbl_Mitarbeiter(rowguid),
    Anwesenheit UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Mitarbeiter_haben_tbl_Anwesenheit_tbl_Anwesenheit FOREIGN KEY (Anwesenheit) REFERENCES tbl_Anwesenheit(rowguid),
)
GO

CREATE TABLE tbl_Dienstleistung_braucht_tbl_Chemie
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Dienstleistung_braucht_tbl_Chemie PRIMARY KEY
        CONSTRAINT DF_tbl_Dienstleistung_braucht_tbl_Chemie_rowguid DEFAULT (newid()),
    Dienstleistung UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Dienstleistung_braucht_tbl_Chemie_tbl_Dienstleistung FOREIGN KEY (Dienstleistung) REFERENCES tbl_Dienstleistung(rowguid),
    Chemie UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Dienstleistung_braucht_tbl_Chemie_tbl_Chemie FOREIGN KEY (Chemie) REFERENCES tbl_Chemie(rowguid),
)
GO

CREATE TABLE tbl_Dienstleistung_hat_Auspraegung
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Dienstleistung_hat_Auspraegung PRIMARY KEY
        CONSTRAINT DF_tbl_Dienstleistung_hat_Auspraegung_rowguid DEFAULT (newid()),
    Dienstleistung UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Dienstleistung_hat_Auspraegung_tbl_Dienstleistung FOREIGN KEY (Dienstleistung) REFERENCES tbl_Dienstleistung(rowguid),
    Auspraegung UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT FK_tbl_Dienstleistung_hat_Auspraegung_tbl_Auspraegung FOREIGN KEY (Auspraegung) REFERENCES tbl_Auspraegung(rowguid),
)
GO

CREATE PROCEDURE sp_Update_Artikel
@rowguid UNIQUEIDENTIFIER,
@Artikelname NVARCHAR(50),
@Preis DECIMAL(10,2),
@Lieferfirma NVARCHAR(50),
AS 
BEGIN
    INSERT INTO tbl_Artikel (rowguid, Artikelname, Preis, Lieferfirma)
    VALUES (@rowguid, @Artikelname, @Preis, @Lieferfirma)
END
GO

ALTER TABLE tbl_Kunde add deleteDate datetime;
GO

CREATE trigger trig_Bin_Kunde on tbl_Kunde
INSTEAD of DELETE
AS
BEGIN
    UPDATE tbl_Kunde
    SET deleteDate = GETDATE()
    WHERE rowguid = (SELECT rowguid
    FROM deleted)
END
GO


create view view_kunde
as
select * from tbl_Kunde
where deleteDate is null
GO
CREATE CLUSTERED INDEX IX_tbl_Kunde ON tbl_Kunde (rowguid)
GO



