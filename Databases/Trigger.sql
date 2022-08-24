create table Log 
(
   rowguid uniqueidentifier primary key default(newid()),
   AKtion nvarchar(max) not null,
   EstellungVon nvarchar(50) not null default (suser_name()),
   Erstellungsdatum datetime not null default(getdate()),

);


create trigger trig_Customers on Customers
After Insert 
as 
begin
insert into Log 
(AKtion) 

select * from inserted 
concat('Datensatz eingefügt: ', inserted.CustomerID, ' ', inserted.CompanyName, ' ', inserted.ContactName)
end

-- select into
end

End