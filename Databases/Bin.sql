alter table tbl_Reiter add deleteDate datetime;

create trigger trig_Bin_Reiter on tbl_Reiter
Instead of delete
as
begin
    update tbl_Reiter set deleteDate = getdate();
end     

create view view_Reiter
as
begin
    select * from tbl_Reiter where deleteDate is null
end




