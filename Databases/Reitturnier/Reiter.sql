create table tbl_Reiter 
(
    ReiterID uniqueidentifier,
    [Name] nvarchar(10),
    Vorname nvarchar(10),
    Adresse nvarchar(30),
    lizenznummer nvarchar
);
go 


create trigger trig_Bin_Reiter on tbl_Reiter
 Instead of Delete 
as 
begin
update 
  tbl_Reiter 
(ReiterID) 

select * from inserted 
end




