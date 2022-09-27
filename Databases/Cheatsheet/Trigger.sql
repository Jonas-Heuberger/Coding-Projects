CREATE TRIGGER tr_log_Klasse_insert on dbo.tbl_Klasse
AFTER INSERT
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('INSERT INTO dbo.tbl_Klasse')
END
GO

CREATE TRIGGER tr_log_Klasse_update on dbo.tbl_Klasse
AFTER UPDATE
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('UPDATE dbo.tbl_Klasse')
END
GO

CREATE TRIGGER tr_log_Klasse_delete on dbo.tbl_Klasse
AFTER DELETE
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('DELETE FROM dbo.tbl_Klasse')
END
GO

CREATE TRIGGER tr_log_Faecher_insert on dbo.tbl_Faecher
AFTER INSERT
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('INSERT INTO dbo.tbl_Faecher')
END
GO

CREATE TRIGGER tr_log_Faecher_update on dbo.tbl_Faecher
AFTER UPDATE
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('UPDATE dbo.tbl_Faecher')
END
GO

CREATE TRIGGER tr_log_Faecher_delete on dbo.tbl_Faecher
AFTER DELETE
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('DELETE FROM dbo.tbl_Faecher')
END
GO

CREATE TRIGGER tr_log_Lehrer_insert on dbo.tbl_Lehrer
AFTER INSERT
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('INSERT INTO dbo.tbl_Lehrer')
END
GO

CREATE TRIGGER tr_log_Lehrer_update on dbo.tbl_Lehrer
AFTER UPDATE
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('UPDATE dbo.tbl_Lehrer')
END
GO

CREATE TRIGGER tr_log_Lehrer_delete on dbo.tbl_Lehrer
AFTER DELETE
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('DELETE FROM dbo.tbl_Lehrer')
END
GO

CREATE TRIGGER tr_log_Schueler_insert on dbo.tbl_Schueler
AFTER INSERT
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('INSERT INTO dbo.tbl_Schueler')
END
GO

CREATE TRIGGER tr_log_Schueler_update on dbo.tbl_Schueler
AFTER UPDATE
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('UPDATE dbo.tbl_Schueler')
END
GO

CREATE TRIGGER tr_log_Schueler_delete on dbo.tbl_Schueler
AFTER DELETE
AS
BEGIN
    INSERT INTO dbo.Logging
        (Action)
    VALUES
        ('DELETE FROM dbo.tbl_Schueler')
END
GO