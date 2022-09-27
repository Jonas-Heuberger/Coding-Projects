CREATE PROCEDURE sp_Klasse_insert
    @Klassenname nvarchar(50)
AS
BEGIN
    INSERT INTO dbo.tbl_Klasse
        (Klassenname)
    VALUES
        (@Klassenname)
END
GO

CREATE PROCEDURE sp_Klasse_update
    @rowguid uniqueidentifier,
    @Klassenname nvarchar(50)
AS
BEGIN
    UPDATE dbo.tbl_Klasse
    SET Klassenname = @Klassenname
    WHERE rowguid = @rowguid
END
GO

CREATE PROCEDURE sp_Klasse_delete
    @rowguid uniqueidentifier
AS
BEGIN
    DELETE FROM dbo.tbl_Klasse
    WHERE rowguid = @rowguid
END
GO

CREATE PROCEDURE sp_Faecher_insert
    @Fachname nvarchar(50)
AS
BEGIN
    INSERT INTO dbo.tbl_Faecher
        (Fachname)
    VALUES
        (@Fachname)
END
GO

CREATE PROCEDURE sp_Faecher_update
    @rowguid uniqueidentifier,
    @Fachname nvarchar(50)
AS
BEGIN
    UPDATE dbo.tbl_Faecher
    SET Fachname = @Fachname
    WHERE rowguid = @rowguid
END
GO

CREATE PROCEDURE sp_Faecher_delete
    @rowguid uniqueidentifier
AS
BEGIN
    DELETE FROM dbo.tbl_Faecher
    WHERE rowguid = @rowguid
END
GO

CREATE PROCEDURE sp_Lehrer_insert
    @Vorname nvarchar(50),
    @Nachname nvarchar(50),
    @Geburtsdatum date
AS
BEGIN
    INSERT INTO dbo.tbl_Lehrer
        (Vorname, Nachname, Geburtsdatum)
    VALUES
        (@Vorname, @Nachname, @Geburtsdatum)
END
GO

CREATE PROCEDURE sp_Lehrer_update
    @rowguid uniqueidentifier,
    @Vorname nvarchar(50),
    @Nachname nvarchar(50),
    @Geburtsdatum date
AS
BEGIN
    UPDATE dbo.tbl_Lehrer
    SET Vorname = @Vorname, Nachname = @Nachname, Geburtsdatum = @Geburtsdatum
    WHERE rowguid = @rowguid
END
GO

CREATE PROCEDURE sp_Lehrer_delete
    @rowguid uniqueidentifier
AS
BEGIN
    DELETE FROM dbo.tbl_Lehrer
    WHERE rowguid = @rowguid
END
GO

CREATE PROCEDURE sp_Schueler_insert
    @Vorname nvarchar(50),
    @Nachname nvarchar(50),
    @Geburtsdatum date
AS
BEGIN
    INSERT INTO dbo.tbl_Schueler
        (Vorname, Nachname, Geburtsdatum)
    VALUES
        (@Vorname, @Nachname, @Geburtsdatum)
END
GO

CREATE PROCEDURE sp_Schueler_update
    @rowguid uniqueidentifier,
    @Vorname nvarchar(50),
    @Nachname nvarchar(50),
    @Geburtsdatum date
AS
BEGIN
    UPDATE dbo.tbl_Schueler
    SET Vorname = @Vorname, Nachname = @Nachname, Geburtsdatum = @Geburtsdatum
    WHERE rowguid = @rowguid
END
GO

CREATE PROCEDURE sp_Schueler_delete
    @rowguid uniqueidentifier
AS
BEGIN
    DELETE FROM dbo.tbl_Schueler
    WHERE rowguid = @rowguid
END
GO