create DATABASE Schule
GO
use Schule
GO

create table tbl_Klasse
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Klasse PRIMARY KEY
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
    KlasseID uniqueidentifier not null
        CONSTRAINT FK_tbl_Schueler_tbl_Klasse 
        FOREIGN KEY (KlasseID) 
        REFERENCES tbl_Klasse(rowguid),
)
GO

CREATE TABLE tbl_Klasse_besucht_Faecher
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_tbl_Klasse_besucht_Faecher PRIMARY KEY
        CONSTRAINT DF_tbl_Klasse_besucht_Faecher_rowguid DEFAULT newid(),
    FK_KlasseID UNIQUEIDENTIFIER NOT NULL,
    FK_FaecherID UNIQUEIDENTIFIER NOT NULL,
    CONSTRAINT fk_tbl_Klasse_besucht_Faecher_tbl_Klasse FOREIGN KEY (FK_KlasseID) REFERENCES tbl_Klasse (rowguid),
    CONSTRAINT fk_tbl_Klasse_besucht_Faecher_tbl_Faecher FOREIGN KEY (FK_FaecherID) REFERENCES tbl_Faecher (rowguid)
)
GO

CREATE TABLE Lehrer_unterrichtet_Faecher
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_Lehrer_unterrichtet_Faecher PRIMARY KEY
        CONSTRAINT DF_Lehrer_unterrichtet_Faecher_rowguid DEFAULT newid(),
    FK_LehrerID UNIQUEIDENTIFIER NOT NULL,
    FK_FaecherID UNIQUEIDENTIFIER NOT NULL,
    CONSTRAINT fk_Lehrer_unterrichtet_Faecher_tbl_Lehrer FOREIGN KEY (FK_LehrerID) REFERENCES tbl_Lehrer (rowguid),
    CONSTRAINT fk_Lehrer_unterrichtet_Faecher_tbl_Faecher FOREIGN KEY (FK_FaecherID) REFERENCES tbl_Faecher (rowguid)
)
GO


CREATE TABLE Logging
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT PK_Logging PRIMARY KEY
        CONSTRAINT DF_Logging_rowguid DEFAULT newid(),
    Action nvarchar(max) NOT NULL,
    LogDate datetime not null DEFAULT (getdate()),
    LogUser nvarchar(50) not null DEFAULT (suser_name()),
)
GO





















