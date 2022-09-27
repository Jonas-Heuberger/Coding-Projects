USE Schule
GO

ALTER TABLE tbl_Klasse add deleteDate datetime;
GO

CREATE trigger trig_Bin_Klasse on tbl_Klasse
INSTEAD of DELETE
AS
BEGIN
    UPDATE tbl_Klasse
    SET deleteDate = GETDATE()
    WHERE rowguid = (SELECT rowguid
    FROM deleted)
END
GO

ALTER TABLE tbl_Faecher add deleteDate datetime;
GO

CREATE trigger trig_Bin_Faecher on tbl_Faecher
INSTEAD of DELETE
AS
BEGIN
    UPDATE tbl_Faecher
    SET deleteDate = GETDATE()
    WHERE rowguid = (SELECT rowguid
    FROM deleted)
END
GO

ALTER TABLE tbl_Lehrer add deleteDate datetime;
GO

CREATE trigger trig_Bin_Lehrer on tbl_Lehrer
INSTEAD of DELETE
AS
BEGIN
    UPDATE tbl_Lehrer
    SET deleteDate = GETDATE()
    WHERE rowguid = (SELECT rowguid
    FROM deleted)
END
GO

ALTER TABLE tbl_Schueler add deleteDate datetime;
GO

CREATE trigger trig_Bin_Schueler on tbl_Schueler
INSTEAD of DELETE
AS
BEGIN
    UPDATE tbl_Schueler
    SET deleteDate = GETDATE()
    WHERE rowguid = (SELECT rowguid
    FROM deleted)
END
GO