create procedure usp_CustomerList 
as
Begin 
select CompanyName, ContactName from Customers
End
go 
create or alter View view_Customer
as
select CompanyName, ContactName from Customers
go


create or alter procedure usp_CustomerList 
@Anzahl int
As
Begin
select top (@Anzahl) CompanyName, ContactName from Customers
End


-- select top()

