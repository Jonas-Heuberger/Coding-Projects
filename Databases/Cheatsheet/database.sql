create database Schule
go

use Schule

create table tbl_Klasse
(
    rowguid UNIQUEIDENTIFIER NOT NULL,
    CONSTRAINT pk_tbl_Klasse PRIMARY KEY,
    CONSTRAINT DF_tbl_Klasse_rowguid DEFAULT newid(),
    Klassenname varchar(50) NOT NULL,
    fk_Schueler_Id UNIQUEIDENTIFIER NOT NULL,
    fk_Lehrer_Id UNIQUEIDENTIFIER NOT NULL
        CONSTRAINT fk_tbl_Klasse_tbl_Schueler FOREIGN KEY (fk_Schueler_Id) REFERENCES tbl_Schueler (rowguid),
    CONSTRAINT fk_tbl_Klasse_tbl_Lehrer FOREIGN KEY (fk_Lehrer_Id) REFERENCES tbl_Lehrer (rowguid)

)
GO

create table tbl_Schueler
(
    rowguid uniqueidentifier not null,
    CONSTRAINT PK_tbl_Schueler PRIMARY KEY,
    CONSTRAINT DF_tbl_Schueler_rowguid DEFAULT newid(),
    Vorname nvarchar(50) not null,
    Nachname nvarchar(50) not null,
    Geburtsdatum date not null,
    fk_KlasseID UNIQUEIDENTIFIER not null,
    fk_FaecherID UNIQUEIDENTIFIER not null,
    fk_LehrerID UNIQUEIDENTIFIER not null,
    CONSTRAINT fk_tbl_Schueler_tbl_Klasse FOREIGN KEY (fk_KlasseID) REFERENCES tbl_Klasse (rowguid),
    CONSTRAINT fk_tbl_Schueler_tbl_Faecher FOREIGN KEY (fk_FaecherID) REFERENCES tbl_Faecher (rowguid),
    CONSTRAINT fk_tbl_Schueler_tbl_Lehrer FOREIGN KEY (fk_LehrerID) REFERENCES tbl_Lehrer (rowguid)
)
go

create table tbl_Faecher
(
    rowguid uniqueidentifier not null,
    CONSTRAINT PK_tbl_Faecher PRIMARY KEY,
    CONSTRAINT DF_tbl_Faecher_rowguid DEFAULT newid(),
    Fachname nvarchar(50) not null,
    fk_SchuelerID UNIQUEIDENTIFIER not null,
    fk_LehrerID UNIQUEIDENTIFIER not null,
    CONSTRAINT fk_tbl_Faecher_tbl_Lehrer FOREIGN KEY (fk_LehrerID) REFERENCES tbl_Lehrer (rowguid),
    CONSTRAINT fk_tbl_Faecher_tbl_Schueler FOREIGN KEY (fk_SchuelerID) REFERENCES tbl_Schueler (rowguid)
)
go

create table tbl_Lehrer
(
    rowguid uniqueidentifier not null,
    CONSTRAINT PK_tbl_Lehrer PRIMARY KEY,
    CONSTRAINT DF_tbl_Lehrer_rowguid DEFAULT newid(),
    Vorname nvarchar(50) not null,
    Nachname nvarchar(50) not null,
    Geburtsdatum date not null,
    fk_FaecherID UNIQUEIDENTIFIER not null,
    fk_KlasseID UNIQUEIDENTIFIER not null,
    fk_SchuelerID UNIQUEIDENTIFIER not null,
    CONSTRAINT fk_tbl_Lehrer_tbl_Faecher FOREIGN KEY (fk_FaecherID) REFERENCES tbl_Faecher (rowguid),
    CONSTRAINT fk_tbl_Lehrer_tbl_Klasse FOREIGN KEY (fk_KlasseID) REFERENCES tbl_Klasse (rowguid),
    CONSTRAINT fk_tbl_Lehrer_tbl_Schueler FOREIGN KEY (fk_SchuelerID) REFERENCES tbl_Schueler (rowguid)
)
go



    
