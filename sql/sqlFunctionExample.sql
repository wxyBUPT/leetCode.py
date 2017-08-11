

/**
177. Nth Highest Salary
DescriptionHintsSubmissionsDiscussSolution
Discuss Pick One
Write a SQL query to get the nth highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the nth highest salary where n = 2 is 200. If there is no nth highest salary, then the query should return null.

+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
 */

Create table If Not Exists Employee (Id int, Salary int);
Truncate table Employee;
insert into Employee (Id, Salary) values ('1', '100');
insert into Employee (Id, Salary) values ('2', '200');
insert into Employee (Id, Salary) values ('3', '300');


delimiter $$
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M=N-1;
  RETURN (
  /**
  没有使用distince, 因为 union 已经帮忙去重了
   */
      SELECT Salary FROM Employee UNION SELECT  NULL ORDER BY Salary DESC LIMIT M, 1
  );
END $$
delimiter ;

SELECT getNthHighestSalary(2);