
/**
183. Customers Who Never Order
DescriptionHintsSubmissionsDiscussSolution
 SQL Schema  Discuss Pick One
Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.

Table: Customers.

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Table: Orders.

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Using the above tables as example, return the following:

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
 */

Create table If Not Exists Customers (Id int, Name varchar(255));
Create table If Not Exists Orders (Id int, CustomerId int);
Truncate table Customers;
insert into Customers (Id, Name) values ('1', 'Joe');
insert into Customers (Id, Name) values ('2', 'Henry');
insert into Customers (Id, Name) values ('3', 'Sam');
insert into Customers (Id, Name) values ('4', 'Max');
Truncate table Orders;
insert into Orders (Id, CustomerId) values ('1', '3');
insert into Orders (Id, CustomerId) values ('2', '1');
INSERT INTO Orders (Id, CustomerId) VALUES ('3', '3');
INSERT INTO Orders (Id, CustomerId) VALUES (4, 2);

/**
 use join , in
 */
SELECT Name AS Customers FROM Customers WHERE Id NOT IN (SELECT DISTINCT CustomerId FROM Orders);

SELECT A.Name AS Customers FROM Customers A WHERE NOT EXISTS(SELECT 1 FROM Orders B WHERE A.Id = B.CustomerId);

/**
Left join
 */
SELECT A.Name AS Customer FROM Customers A LEFT JOIN Orders B on A.Id=b.CustomerId WHERE B.CustomerId is NULL;
/**
Iner join
 */

SELECT A.Name AS Customer From Customers A WHERE A.Id NOT IN (SELECT A.Id FROM Customers A JOIN Orders B ON A.Id=B.CustomerId);




