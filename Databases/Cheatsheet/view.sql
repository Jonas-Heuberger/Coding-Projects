CREATE VIEW view_Klasse
WITH
    SCHEMABINDING
AS
    SELECT rowguid, Klassenname
    FROM dbo.tbl_Klasse
GO

CREATE VIEW view_Faecher
WITH
    SCHEMABINDING
AS
    SELECT rowguid, Fachname
    FROM dbo.tbl_Faecher
GO

CREATE VIEW view_Lehrer
WITH
    SCHEMABINDING
AS
    SELECT rowguid, Vorname, Nachname, Geburtsdatum
    FROM dbo.tbl_Lehrer
GO

CREATE VIEW view_Schueler
WITH
    SCHEMABINDING
AS
    SELECT rowguid, Vorname, Nachname, Geburtsdatum
    FROM dbo.tbl_Schueler
GO

CREATE VIEW view_Klasse_besucht_Faecher
WITH
    SCHEMABINDING
AS
    SELECT rowguid, FK_KlasseID, FK_FaecherID
    FROM dbo.tbl_Klasse_besucht_Faecher
GO

CREATE VIEW view_Lehrer_unterrichtet_Faecher
WITH
    SCHEMABINDING
AS
    SELECT rowguid, FK_LehrerID, FK_FaecherID
    FROM dbo.Lehrer_unterrichtet_Faecher
GO

CREATE VIEW view_Schueler_ist_in_Klasse
WITH
    SCHEMABINDING
AS
    SELECT rowguid, FK_SchuelerID, FK_KlasseID
    FROM dbo.tbl_Schueler_ist_in_Klasse
GO

CREATE VIEW view_Logging
WITH
    SCHEMABINDING
AS
    SELECT rowguid, Action, LogDate, LogUser
    FROM dbo.Logging
GO
