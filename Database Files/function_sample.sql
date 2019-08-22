create or replace function max_sal(idno in number)    
return number    
is     
n number;  
begin    
select max(sal) into n from emp where deptno=idno;
    
return n;    
end; 

DECLARE    
   n number;    
BEGIN    
   n := max_sal(20);    
   dbms_output.put_line('Max Sal is: ' || n3);    
END;  
select * from emp;