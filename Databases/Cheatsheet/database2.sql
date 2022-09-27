create dbo.Schule
GO
use dbo.Schule
GO

create table tbl_Klasse
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT pk_tbl_Klasse PRIMARY KEY
        CONSTRAINT DF_tbl_Klasse_rowguid DEFAULT newid(),
    Klassenname nvarchar(50) NOT NULL,
)
GO

CREATE TABLE tbl_Faecher
(
    rowguid uniqueidentifier not null
        CONSTRAINT PK_tbl_Faecher PRIMARY KEY
        CONSTRAINT DF_tbl_Faecher_rowguid DEFAULT newid(),
    Fachname nvarchar(50) not null,
)
GO

CREATE TABLE tbl_Lehrer
(
    rowguid uniqueidentifier not null
        CONSTRAINT PK_tbl_Lehrer PRIMARY KEY
        CONSTRAINT DF_tbl_Lehrer_rowguid DEFAULT newid(),
    Vorname nvarchar(50) not null,
    Nachname nvarchar(50) not null,
    Geburtsdatum date not null,
)
GO

CREATE TABLE tbl_Schueler
(
    rowguid uniqueidentifier not null
        CONSTRAINT PK_tbl_Schueler PRIMARY KEY
        CONSTRAINT DF_tbl_Schueler_rowguid DEFAULT newid(),
    Vorname nvarchar(50) not null,
    Nachname nvarchar(50) not null,
    Geburtsdatum date not null,
)
GO

CREATE TABLE tbl_Klasse_besucht_Faecher
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT pk_tbl_Klasse_besucht_Faecher PRIMARY KEY
        CONSTRAINT DF_tbl_Klasse_besucht_Faecher_rowguid DEFAULT newid(),
    FK_KlasseID UNIQUEIDENTIFIER NOT NULL,
    FK_FaecherID UNIQUEIDENTIFIER NOT NULL,
    CONSTRAINT fk_tbl_Klasse_besucht_Faecher_tbl_Klasse FOREIGN KEY (FK_KlasseID) REFERENCES tbl_Klasse (rowguid),
    CONSTRAINT fk_tbl_Klasse_besucht_Faecher_tbl_Faecher FOREIGN KEY (FK_FaecherID) REFERENCES tbl_Faecher (rowguid)
)
GO

CREATE TABLE tbl_Schueler_haben_Lehrer_in_Faecher
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT pk_tbl_Schueler_haben_Lehrer_in_Faecher PRIMARY KEY
        CONSTRAINT DF_tbl_Schueler_haben_Lehrer_in_Faecher_rowguid DEFAULT newid(),
    FK_SchuelerID UNIQUEIDENTIFIER NOT NULL,
    FK_LehrerID UNIQUEIDENTIFIER NOT NULL,
    FK_FaecherID UNIQUEIDENTIFIER NOT NULL,
    CONSTRAINT fk_tbl_Schueler_haben_Lehrer_in_Faecher_tbl_Schueler FOREIGN KEY (FK_SchuelerID) REFERENCES tbl_Schueler (rowguid),
    CONSTRAINT fk_tbl_Schueler_haben_Lehrer_in_Faecher_tbl_Lehrer FOREIGN KEY (FK_LehrerID) REFERENCES tbl_Lehrer (rowguid),
    CONSTRAINT fk_tbl_Schueler_haben_Lehrer_in_Faecher_tbl_Faecher FOREIGN KEY (FK_FaecherID) REFERENCES tbl_Faecher (rowguid)
)
GO

CREATE VIEW view_Klasse
WITH SCHEMABINDING
AS
SELECT rowguid, Klassenname FROM dbo.tbl_Klasse
GO

CREATE VIEW view_Faecher
WITH SCHEMABINDING
AS
SELECT rowguid, Fachname FROM dbo.tbl_Faecher
GO

CREATE VIEW view_Lehrer
WITH SCHEMABINDING
AS
SELECT rowguid, Vorname, Nachname, Geburtsdatum FROM dbo.tbl_Lehrer
GO

CREATE VIEW view_Schueler
WITH SCHEMABINDING
AS
SELECT rowguid, Vorname, Nachname, Geburtsdatum FROM dbo.tbl_Schueler
GO

CREATE VIEW view_Klasse_besucht_Faecher
WITH SCHEMABINDING
AS
SELECT rowguid, FK_KlasseID, FK_FaecherID FROM dbo.tbl_Klasse_besucht_Faecher
GO

CREATE VIEW view_Schueler_haben_Lehrer_in_Faecher
WITH SCHEMABINDING
AS
SELECT rowguid, FK_SchuelerID, FK_LehrerID, FK_FaecherID FROM dbo.tbl_Schueler_haben_Lehrer_in_Faecher
GO




