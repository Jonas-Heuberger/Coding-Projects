USE Master 

IF EXISTS
(SELECT * FROM sysdatabases WHERE name = 'test')
BEGIN 
	RAISERROR ('DB Besteht bereits', 0 ,1)
	ALTER DATABASE test set single_user with rollback immediate
	DROP DATABASE test
	END
	GO
	CHECKPOINT 
	
	CREATE DATABASE test
	GO 
	CHECKPOINT

	USE test 
	CREATE TABLE tbl_Schueler
	(
	rowguid uniqueidentifier PRIMARY KEY,
	ID INT IDENTITY(1,1),
	Nachname nvarchar(50) NOT NULL,
	Vorname nvarchar(50),
	Strasse nvarchar(50),
	PLZ int, 
	Ort nvarchar(20)
	)

	CREATE TABLE tbl_Mail
	(
	rowguid uniqueidentifier PRIMARY KEY,
	SchuelerID uniqueidentifier NOT NULL,
	Mail nvarchar(100) NOT NULL,
	)

	GO 

	ALTER TABLE tbl_Schueler ADD CONSTRAINT DF_tbl_Schueler_rowguid 
	DEFAULT (newid())
	FOR rowguid

	ALTER TABLE tbl_Mail 
	ADD CONSTRAINT DF_tbl_Mail_rowguid 
	DEFAULT (newid())
	FOR rowguid
	GO
	
	ALTER TABLE tbl_Mail
	ADD CONSTRAINT FK_tbl_Mail_tbl_Schueler
	FOREIGN KEY (SchuelerID)
	REFERENCES tbl_Schueler (rowguid)
	ON DELETE CASCADE
	GO
	
	CREATE PROCEDURE usp_SchuelerDelete
		@SchuelerRowguid uniqueidentifier
	AS
	BEGIN
		DELETE tbl_Schueler WHERE rowguid = @SchuelerRowguid
	END
	GO
	CREATE PROCEDURE usp_SchuelerADD
	@Nachname nvarchar(50),
	@Vorname nvarchar(50) = NULL,
	@Strasse nvarchar(50) = NULL,
	@PLZ int = NULL,
	@Ort nvarchar(20) = NULL
	AS
	BEGIN
	INSERT INTO tbl_Schueler
	(
	rowguid,
	Nachname,
	Vorname,
	Strasse,
	PLZ,
	Ort
	)
	VALUES
	(
	(newid()),
	@Nachname,
	@Vorname,
	@Strasse,
	@PLZ,
	@Ort
	)
	END
	GO

	CREATE PROCEDURE usp_SchuelerEdit
	@rowguid uniqueidentifier,
	@Nachname nvarchar(50) = NULL,
	@Vorname nvarchar(50) = NULL,
	@Strasse nvarchar(50) = NULL,
	@PLZ int = NULL,
	@Ort nvarchar(20) = NULL
	AS
	BEGIN
	UPDATE tbl_Schueler
	SET
		Nachname = ISNULL(@Nachname, Nachname),
		Vorname = ISNULL(@Vorname, Vorname),
		Strasse = ISNULL(@Strasse, Strasse),
		PLZ = ISNULL(@PLZ, PLZ),
		Ort = ISNULL(@Ort, Ort)

	WHERE rowguid = @rowguid
	END
	GO

	CREATE PROCEDURE usp_SchuelerList
	AS
	BEGIN
		SELECT
		Nachname,
		Vorname,
		Strasse,
		PLZ,
		Ort
		FROM tbl_Schueler
		ORDER BY Nachname, Vorname
	END
	GO

	CREATE PROCEDURE usp_MailList
	@SchuelerID uniqueidentifier
	AS
	BEGIN
		SELECT
		Mail
		FROM tbl_Mail
		WHERE SchuelerID = @SchuelerID
	END
	GO

	CREATE PROCEDURE usp_MailAdd
	@SchuelerID uniqueidentifier,
	@Mail nvarchar(100)
	AS
	BEGIN
	INSERT INTO tbl_Mail
	(
	rowguid,
	SchuelerID,
	Mail
	)
	VALUES
	(
	(newid()),
	@SchuelerID,
	@Mail
	)
	END
	GO

	CREATE PROCEDURE usp_MailDelete
	@SchuelerID uniqueidentifier,
	@Mail nvarchar(100)
	AS
	BEGIN
	DELETE tbl_Mail
	WHERE SchuelerID = @SchuelerID AND Mail = @Mail
	END
	GO

	CREATE PROCEDURE usp_MailEdit
	@SchuelerID uniqueidentifier,
	@Mail nvarchar(100) = NULL,
	@NewMail nvarchar(100) = NULL
	AS
	BEGIN
	UPDATE tbl_Mail
	SET
		Mail = ISNULL(@NewMail, Mail)
	WHERE SchuelerID = @SchuelerID AND Mail = @Mail
	END
	GO
	