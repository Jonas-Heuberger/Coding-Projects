Create Database Allwissende_Frau

Use Allwissende_Frau

GO

CREATE TABLE tbl_Relevanz
(
	relevanz_stufe Int IDENTITY(1,1) not null
		CONSTRAINT PK_tbl_Relevanz PRIMARY KEY,
	[Name] nvarchar(60) not null,
)
GO

CREATE TABLE tbl_Hausarzt
(
	rowguid uniqueidentifier not null
		CONSTRAINT PK_tbl_Hausarzt PRIMARY KEY
		CONSTRAINT DF_tbl_Hausarzt_rowguid DEFAULT newid(),
	[Name] nvarchar(60) not null,
	Vorname nvarchar(60) not null,
	Praxis nvarchar(60) not null,
	email nvarchar(60) not null,
)
GO

CREATE TABLE tbl_Relevanzarzt
(
	rowguid uniqueidentifier not null
		CONSTRAINT PK_tbl_Relevanzarzt PRIMARY KEY
		CONSTRAINT DF_tbl_Relevanzarzt_rowguid DEFAULT newid(),
	[Name] nvarchar(60) not null,
	Vorname nvarchar(60) not null,
	email nvarchar(60) not null,
)
go

CREATE TABLE tbl_fall
(
	rowguid uniqueidentifier not null
		CONSTRAINT PK_tbl_fall PRIMARY KEY
		CONSTRAINT DF_tbl_fall_rowguid DEFAULT newid(),
	Datum DateTime not null
		CONSTRAINT DF_tbl_fall_Datum DEFAULT CURRENT_TIMESTAMP,
	Medikament nvarchar(60) not null,
	Mitteilung text not null,

	FK_Hausarzt_Id uniqueidentifier not null,
	FK_Relevanzarzt_Id uniqueidentifier not null,
	FK_Relevanz_Id Int not null,

	CONSTRAINT FK_tbl_fall_tbl_Hausarzt
	FOREIGN KEY (FK_Hausarzt_Id)
	REFERENCES tbl_Hausarzt (rowguid),

	CONSTRAINT FK_tbl_fall_tbl_Relevanzart
	FOREIGN KEY (FK_Relevanzarzt_Id)
	REFERENCES tbl_Relevanzarzt (rowguid),

	CONSTRAINT FK_tbl_fall_tbl_Relevanz
	FOREIGN KEY (FK_Relevanz_Id)
	REFERENCES tbl_Relevanz (relevanz_stufe),
)
GO

CREATE TABLE tbl_Land
(
	rowguid uniqueidentifier not null
		CONSTRAINT PK_tbl_Land PRIMARY KEY
		CONSTRAINT DF_tbl_Land_rowguid DEFAULT newid(),
	Ansprechpartner nvarchar(60) not null,
	email nvarchar(60) not null,
	Art_der_Mitteilung nvarchar(60) not null,
	Mitteilung_Ab_Relevanz Int not null,

	CONSTRAINT FK_tbl_Land_tbl_Relevanz
	FOREIGN KEY (Mitteilung_Ab_Relevanz)
	REFERENCES tbl_Relevanz (relevanz_stufe),
)
GO

CREATE TABLE tbl_Mitteilung
(
	rowguid uniqueidentifier not null
		CONSTRAINT PK_tbl_Mitteilung PRIMARY KEY
		CONSTRAINT DF_tbl_Mitteilung_rowguid DEFAULT newid(),
	Datum DateTime not null
		CONSTRAINT DF_tbl_Mitteilung_Datum DEFAULT CURRENT_TIMESTAMP,

	FK_Land_Id uniqueidentifier not null,

	CONSTRAINT FK_tbl_Mitteilung_tbl_Land
	FOREIGN KEY (FK_Land_Id)
	REFERENCES tbl_Land (rowguid),
)
GO

CREATE TABLE tbl_Fall_Mitteilung_An_Land
(
	FK_Fall_Id uniqueidentifier not null,
	FK_Mitteilung_Id uniqueidentifier not null,

	CONSTRAINT FK_tbl_Fall_Mitteilung_An_Land_tbl_Fall
	FOREIGN KEY (FK_Fall_Id)
	REFERENCES tbl_Fall (rowguid),

	CONSTRAINT FK_tbl_Fall_Mitteilung_An_Land_tbl_Mitteilung
	FOREIGN KEY (FK_Mitteilung_Id)
	REFERENCES tbl_Mitteilung (rowguid),
)
GO

create view view_Fall
with
	schemabinding
as
	select rowguid, Datum, Medikament, Mitteilung, FK_Hausarzt_Id, FK_Relevanzarzt_Id, FK_Relevanz_Id
	from dbo.tbl_Fall
go
create unique clustered index pk_view_Fall on view_Fall (rowguid)
go


create view view_Mitteilung
with
	schemabinding
as
	select rowguid, Datum, FK_Land_Id
	from dbo.tbl_Mitteilung
go
create unique clustered index pk_view_Mitteilung on view_Mitteilung (rowguid)
go

create view view_Fall_Mitteilung_An_Land
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id
	from dbo.tbl_Fall_Mitteilung_An_Land
go
create unique clustered index pk_view_Fall_Mitteilung_An_Land on view_Fall_Mitteilung_An_Land (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Land
with
	schemabinding
as
	select rowguid, Ansprechpartner, email, Art_der_Mitteilung, Mitteilung_Ab_Relevanz
	from dbo.tbl_Land
go
create unique clustered index pk_view_Land on view_Land (rowguid)
go

create view view_Hausarzt
with
	schemabinding
as
	select rowguid, Name, Vorname, Praxis, email
	from dbo.tbl_Hausarzt
go
create unique clustered index pk_view_Hausarzt on view_Hausarzt (rowguid)
go

create view view_Relevanzarzt
with
	schemabinding
as
	select rowguid, [Name], Vorname, email
	from dbo.tbl_Relevanzarzt
go
create unique clustered index pk_view_Relevanzarzt on view_Relevanzarzt (rowguid)
go

create view view_Relevanz
with
	schemabinding
as
	select relevanz_stufe, relevanz_beschreibung
	from dbo.tbl_Relevanz
go
create unique clustered index pk_view_Relevanz on view_Relevanz (relevanz_stufe)
go

create view view_Fall_Mitteilung_An_Land_Mit_Land
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, Ansprechpartner, email, Art_der_Mitteilung, Mitteilung_Ab_Relevanz
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Land on FK_Land_Id = rowguid
go
create unique clustered index pk_view_Fall_Mitteilung_An_Land_Mit_Land on view_Fall_Mitteilung_An_Land_Mit_Land (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Land
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, Ansprechpartner, email, Art_der_Mitteilung, Mitteilung_Ab_Relevanz
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Land on FK_Land_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Land on view_Fall_Mit_Land (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Relevanz
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Relevanz_Id, relevanz_beschreibung
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Relevanz on FK_Relevanz_Id = relevanz_stufe
go
create unique clustered index pk_view_Fall_Mit_Relevanz on view_Fall_Mit_Relevanz (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Relevanzarzt
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Relevanzarzt_Id, [Name], Vorname, email
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Relevanzarzt on FK_Relevanzarzt_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Relevanzarzt on view_Fall_Mit_Relevanzarzt (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Hausarzt
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Hausarzt_Id, Name, Vorname, Praxis, email
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Hausarzt on FK_Hausarzt_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Hausarzt on view_Fall_Mit_Hausarzt (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Relevanz_Mit_Relevanzarzt
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Relevanz_Id, FK_Relevanzarzt_Id, relevanz_beschreibung, [Name], Vorname, email
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Relevanz on FK_Relevanz_Id = relevanz_stufe
		inner join dbo.tbl_Relevanzarzt on FK_Relevanzarzt_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Relevanz_Mit_Relevanzarzt on view_Fall_Mit_Relevanz_Mit_Relevanzarzt (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Relevanz_Mit_Hausarzt
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Relevanz_Id, FK_Hausarzt_Id, relevanz_beschreibung, Name, Vorname, Praxis, email
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Relevanz on FK_Relevanz_Id = relevanz_stufe
		inner join dbo.tbl_Hausarzt on FK_Hausarzt_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Relevanz_Mit_Hausarzt on view_Fall_Mit_Relevanz_Mit_Hausarzt (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Relevanz_Mit_Land
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Relevanz_Id, FK_Land_Id, relevanz_beschreibung, Ansprechpartner, email, Art_der_Mitteilung, Mitteilung_Ab_Relevanz
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Relevanz on FK_Relevanz_Id = relevanz_stufe
		inner join dbo.tbl_Land on FK_Land_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Relevanz_Mit_Land on view_Fall_Mit_Relevanz_Mit_Land (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Relevanzarzt_Mit_Land
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Relevanzarzt_Id, FK_Land_Id, [Name], Vorname, email, Ansprechpartner, Art_der_Mitteilung, Mitteilung_Ab_Relevanz
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Relevanzarzt on FK_Relevanzarzt_Id = rowguid
		inner join dbo.tbl_Land on FK_Land_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Relevanzarzt_Mit_Land on view_Fall_Mit_Relevanzarzt_Mit_Land (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Hausarzt_Mit_Land
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Hausarzt_Id, FK_Land_Id, Name, Vorname, Praxis, email, Ansprechpartner, Art_der_Mitteilung, Mitteilung_Ab_Relevanz
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Hausarzt on FK_Hausarzt_Id = rowguid
		inner join dbo.tbl_Land on FK_Land_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Hausarzt_Mit_Land on view_Fall_Mit_Hausarzt_Mit_Land (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Relevanz_Mit_Relevanzarzt_Mit_Land
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Relevanz_Id, FK_Relevanzarzt_Id, FK_Land_Id, relevanz_beschreibung, [Name], Vorname, email, Ansprechpartner, Art_der_Mitteilung, Mitteilung_Ab_Relevanz
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Relevanz on FK_Relevanz_Id = relevanz_stufe
		inner join dbo.tbl_Relevanzarzt on FK_Relevanzarzt_Id = rowguid
		inner join dbo.tbl_Land on FK_Land_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Relevanz_Mit_Relevanzarzt_Mit_Land on view_Fall_Mit_Relevanz_Mit_Relevanzarzt_Mit_Land (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Relevanz_Mit_Hausarzt_Mit_Land
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Relevanz_Id, FK_Hausarzt_Id, FK_Land_Id, relevanz_beschreibung, Name, Vorname, Praxis, email, Ansprechpartner, Art_der_Mitteilung, Mitteilung_Ab_Relevanz
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Relevanz on FK_Relevanz_Id = relevanz_stufe
		inner join dbo.tbl_Hausarzt on FK_Hausarzt_Id = rowguid
		inner join dbo.tbl_Land on FK_Land_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Relevanz_Mit_Hausarzt_Mit_Land on view_Fall_Mit_Relevanz_Mit_Hausarzt_Mit_Land (FK_Fall_Id, FK_Mitteilung_Id)
go

create view view_Fall_Mit_Relevanz_Mit_Relevanzarzt_Mit_Hausarzt_Mit_Land
with
	schemabinding
as
	select FK_Fall_Id, FK_Mitteilung_Id, FK_Relevanz_Id, FK_Relevanzarzt_Id, FK_Hausarzt_Id, FK_Land_Id, relevanz_beschreibung, [Name], Vorname, Praxis, email, Ansprechpartner, Art_der_Mitteilung, Mitteilung_Ab_Relevanz
	from dbo.tbl_Fall_Mitteilung_An_Land
		inner join dbo.tbl_Relevanz on FK_Relevanz_Id = relevanz_stufe
		inner join dbo.tbl_Relevanzarzt on FK_Relevanzarzt_Id = rowguid
		inner join dbo.tbl_Hausarzt on FK_Hausarzt_Id = rowguid
		inner join dbo.tbl_Land on FK_Land_Id = rowguid
go
create unique clustered index pk_view_Fall_Mit_Relevanz_Mit_Relevanzarzt_Mit_Hausarzt_Mit_Land on view_Fall_Mit_Relevanz_Mit_Relevanzarzt_Mit_Hausarzt_Mit_Land (FK_Fall_Id, FK_Mitteilung_Id)
go



