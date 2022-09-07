 create or alter function concat2
 (
    @s1 nvarchar(max), 
    @s2 nvarchar(max)
 )
 returns table 
 as 
 return select 
 case when (@s1 is null or @s2 is null ) then concat(@s1, @s2) else concat(@s1, ' ', @s2) end as result;
 end



select * from cross apply concat2(Title, Firstname)