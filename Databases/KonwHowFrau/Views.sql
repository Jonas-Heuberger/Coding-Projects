create view view_Fall with schemabinding
as
select rowguid, Fallnummer, FK_Klient_Id, FK_Relevanz_Id, FK_Relevanzarzt_Id, FK_Land_Id, FK_Mitteilung_Id, FK_Fall_Id, FK_Mitteilung_Id from dbo.tbl_Fall
go
create unique clustered index pk_view_Fall on view_Fall
(
rowguid
);
go

create view view_Hausarzt with schemabinding
as
select rowguid, [Name], Vorname, Telefon, email, FK_Hausarzt_Id from dbo.tbl_Hausarzt
go
create unique clustered index pk_view_Hausarzt on view_Hausarzt
(
rowguid
);
go



