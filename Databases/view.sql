create view view_Employees with Schemabinding
as
select EmployeeID, Title, Firstname, Lastname, from dbo.Employees
Go
create unique CLUSTERED Index pk_view_Employee on view_Employees 
    (
    EmployeeID
    )