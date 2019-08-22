CREATE OR REPLACE PROCEDURE display_ename(id_e NUMBER)
AS
BEGIN
DECLARE
e_id emp.empno%TYPE;
e_name emp.ename%TYPE;
o_name emp.ename%type;
BEGIN
SELECT empno,ename
INTO e_id,o_name
FROM emp
WHERE empno=id_e;

begin
insert into testers(name) values(o_name);
end;
END;
END;



call display_ename(7839);

select emp.ename from emp where emp.ename='CLARK';



drop table testers;
create table testers(name varchar2(20));




describe dept;
