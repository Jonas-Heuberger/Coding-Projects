create database Schule
go

use dbo.Schule

create table tbl_Klasse
(
    rowguid UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT pk_tbl_Klasse PRIMARY KEY
        CONSTRAINT DF_tbl_Klasse_rowguid DEFAULT newid(),
    Klassenname varchar(50) NOT NULL,
    

)
GO

create table tbl_Faecher
(
    rowguid uniqueidentifier not null
        CONSTRAINT PK_tbl_Faecher PRIMARY KEY
        CONSTRAINT DF_tbl_Faecher_rowguid DEFAULT newid(),
    Fachname nvarchar(50) not null,
)
go

create table tbl_Lehrer
(
    rowguid uniqueidentifier not null
    CONSTRAINT PK_tbl_Lehrer PRIMARY KEY
    CONSTRAINT DF_tbl_Lehrer_rowguid DEFAULT newid(),
    Vorname nvarchar(50) not null,
    Nachname nvarchar(50) not null,
    Geburtsdatum date not null,
    fk_FaecherID UNIQUEIDENTIFIER not null,
    fk_KlasseID UNIQUEIDENTIFIER not null,
    CONSTRAINT fk_tbl_Lehrer_tbl_Faecher FOREIGN KEY (fk_FaecherID) REFERENCES tbl_Faecher (rowguid),
    CONSTRAINT fk_tbl_Lehrer_tbl_Klasse FOREIGN KEY (fk_KlasseID) REFERENCES tbl_Klasse (rowguid),
)
go

create table tbl_Schueler
(
    rowguid uniqueidentifier not null
    CONSTRAINT PK_tbl_Schueler PRIMARY KEY
    CONSTRAINT DF_tbl_Schueler_rowguid DEFAULT newid(),
    Vorname nvarchar(50) not null,
    Nachname nvarchar(50) not null,
    Geburtsdatum date not null,
    fk_KlasseID UNIQUEIDENTIFIER not null,
    fk_LehrerID UNIQUEIDENTIFIER not null,
    fk_FaecherID UNIQUEIDENTIFIER not null,
    CONSTRAINT fk_tbl_Schueler_tbl_Klasse FOREIGN KEY (fk_KlasseID) REFERENCES tbl_Klasse (rowguid),
    CONSTRAINT fk_tbl_Schueler_tbl_Lehrer FOREIGN KEY (fk_LehrerID) REFERENCES tbl_Lehrer (rowguid),
    CONSTRAINT fk_tbl_Schueler_tbl_Faecher FOREIGN KEY (fk_FaecherID) REFERENCES tbl_Faecher (rowguid)
)
go


    
