
/**
所有操作只针对于MySql
 */

DROP TABLE Persons;
CREATE TABLE If not EXISTS Persons (FirstName VARCHAR(255) ,
LastName VARCHAR(255) ,Address VARCHAR(255) , City VARCHAR(255) );

SELECT LastName,FirstName FROM Persons;

SELECT DISTINCT Company FROM Orders ;

SELECT * FROM Persons WHERE City='Beijing';

SELECT * FROM Persons WHERE BornYear > 1965;

SELECT * FROM Persons WHERE FirstName='Thomas' AND LastName='Carter';

SELECT * FROM Persons WHERE firstname='Thomas' OR lastname='Carter';

SELECT * FROM Persons WHERE (FirstName='Thomas' OR FirstName='William') AND LastName='Carter';

SELECT Company, OrderNumber FROM Orders ORDER BY Company;

SELECT Company, OrderNumber FROM Orders ORDER BY Company, OrderNumber;

SELECT Company, OrderNumber FROM Orders ORDER BY Company DESC;

SELECT Company, OrderNumber FROM Orders ORDER BY Company DESC, OrderNumber ASC;

INSERT INTO Persons VALUES ('Gates', 'Bill', 'Xuanwumen 10', 'Beijing');

UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson';

UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing' WHERE LastName = 'Wilson';

DELETE FROM Person WHERE LastName = 'Wilson' ;

SELECT column_name(s) FROM table_name LIMIT 10;

SELECT * FROM Persons WHERE City LIKE 'N%';

SELECT * FROM Persons WHERE City LIKE '%g';

SELECT * FROM Persons WHERE City LIKE '%lon%';

SELECT * FROM Persons WHERE City NOT LIKE '%lon%';

/**
SQL 中的通配符
 % 替代一个或者多个字符
 _ 仅替代一个字符
 [charlist] 字符列中的任何单一字符
 [^charlist] 不在字符列中的任何单一字符
 [!charlist]
 */

SELECT * FROM Persons WHERE LastName IN ('Adams','Carter');

SELECT * FROM Persons WHERE LastName BETWEEN 'Adams' AND 'Carter';

SELECT * FROM Persons WHERE LastName NOT BETWEEN 'Adams' AND 'Carter';

/**
别名有表的别名, 还有列的别名
 */

SELECT po.OrderID, p.LastName, p.FirstName FROM Persons AS p, Product_Orders AS po WHERE p.LastName='Adams' AND p.FirstName='John';

SELECT LastName AS Family, FirstName AS Name FROM Persons;

/**
Join
 */

SELECT Persons.LastName, Persons.FirstName, Orders.OrderNo FROM Persons, Orders WHERE Persons.Id_P = Orders.Id_P;

SELECT Persons.LastName, Persons.FirstName, Orders.OrderNo FROM Persons INNER JOIN Orders ON Persons.Id_P = Orders.Id_P ORDER BY Persons.LastName;

SELECT P.LastName, P.FirstName, O.OrderNo FROM Persons P LEFT JOIN Orders O ON P.ID_P = O.ID_P ORDER BY P.LastName;

/**
每一列的类型相同即可以合并, union 操作选取了不同的值
 */
SELECT E_Name FROM Employees_China UNION SELECT E_Name FROM Employees_US;
SELECT E_Name FROM Employees_China UNION ALL SELECT E_Name as E FROM Employees_US;

/**
表复制备份
 */
SELECT * INTO Persons_backup FROM Persons;
/**
in 子句可用于向另外一个数据库中拷贝表
 */
SELECT * INTO Persons IN 'Backup.mdb' FROM Persons;

SELECT LastName,FirstName INTO Persons_backup FROM Persons;

SELECT Persons.LastName,Orders.OrderNo INTO Persons_Order_Backup FROM Persons INNER JOIN Orders ON Persons.Id_P=Orders.Id_P;

CREATE database test;


CREATE TABLE If NOT EXISTS ALLTYPE ( id int);

/**
一些SQL 约束
 */

CREATE TABLE Persons
(
Id_P int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255)
);

CREATE TABLE Persons
(
Id_P int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255),
CONSTRAINT uc_PersonID UNIQUE (Id_P,LastName)
);

/**
下面一条指令只是撤销 UNIQUE 约束
 */
ALTER TABLE Persons DROP INDEX uc_PersonID;

CREATE TABLE Persons
(
Id_P int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255),
PRIMARY KEY (Id_P)
);

/**
如果需要命名 PROMARY KEY 约束, 以及未多个列定义PRIMARY KEY 约束, 使用下面的SQL语法
 */

CREATE TABLE Persons
(
Id_P int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255),
CONSTRAINT pk_PersonID PRIMARY KEY (Id_P,LastName)
);

/**
对表已经存在的情况下创建 pk 约束
 */
ALTER TABLE Persons
ADD PRIMARY KEY (Id_P);

/**
撤销 pk 约束
 */

ALTER TABLE Persons
DROP PRIMARY KEY;

/**
外键
 */

CREATE TABLE Orders
(
Id_O int NOT NULL,
OrderNo int NOT NULL,
Id_P int,
PRIMARY KEY (Id_O),
FOREIGN KEY (Id_P) REFERENCES Persons(Id_P)
);

/**
对于已经有的表
 */

ALTER TABLE Orders
ADD FOREIGN KEY (Id_P)
REFERENCES Persons(Id_P);

/**
撤销foreign key
 */

ALTER TABLE Orders
DROP FOREIGN KEY fk_PerOrders;

/**
SQL CHECK 约束
CHECK 约束 id_P 列不许只包含大于 0 的整数
 */

CREATE TABLE Persons
(
Id_P int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255),
CHECK (Id_P>0)
);

/**
如果需要命名CHECk约束, 以及未多个列定义CHECK约束
 */

CREATE TABLE Persons
(
Id_P int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255),
CONSTRAINT chk_Person CHECK (Id_P>0 AND City='Sandnes')
);

ALTER TABLE Persons
ADD CHECK (Id_P>0);

ALTER TABLE Persons
ADD CONSTRAINT chk_Person CHECK (Id_P>0 AND City='Sandnes');

/**
撤销check 约束
 */

ALTER TABLE Persons
DROP CHECK chk_Person;

/**
Default 约束
 */
CREATE TABLE Persons
(
Id_P int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255) DEFAULT 'Sandnes'
);

/**
可以使用sql中的一些函数
 */

CREATE TABLE Orders
(
Id_O int NOT NULL,
OrderNo int NOT NULL,
Id_P int,
OrderDate date DEFAULT GETDATE()
);

/**
表已经存在的情况
 */
ALTER TABLE Persons
ALTER City SET DEFAULT 'SANDNES';

/**
创建索引
 */
CREATE INDEX PersonIndex
ON Person (LastName) ;

/**

 */
CREATE INDEX PersonIndex
ON Person (LastName DESC) ;

/**
创建多列索引
 */
CREATE INDEX PersonIndex
ON Person (LastName, FirstName);

/**
删除索引, 表, 库
 */

/**
删除索引
 */
ALTER TABLE table_name DROP INDEX index_name;

DROP Database dbName;

DROP TABLE tableName;

/**
对应Alert
 */

ALTER TABLE table_name
ADD column_name datatype;

ALTER TABLE table_name DROP COLUMN column_name;


ALTER TABLE Persons ADD Birthday date;


/**
对于某些auto inc 字段
 */

CREATE TABLE Persons
(
P_Id int NOT NULL AUTO_INCREMENT,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255),
PRIMARY KEY (P_Id)
);

/**
对于创建视图
不知道sql是否支持, 以及如何使用, 具体查看sql 文档决定
 */

 /**
 SQL 中的日期
  */

SELECT NOW();

SELECT CURDATE();

SELECT CURTIME();

/**
SQL 提取一些信息
比较高深的还不会用, 只会用部分内容
 */

select date(OrderDate) from Orders;


/**
需要注意的是NULL值

 */
SELECT LastName,FirstName,Address FROM Persons WHERE Address IS NULL;

SELECT LastName,FirstName,Address FROM Persons WHERE Address IS NOT NULL;


/**
MYSQL 中的数据类型
 */

 CREATE TABLE If NOT EXISTS ALL_TYPE(
 FIRST_NAME CHAR(10),
 LAST_NAME VARCHAR (255),
 SHORT_DESCRIBE TINYTEXT ,
 DESCRIBEI TEXT ,
 HEADER_IMG BLOB,
 JOIN_AT DATE,
 JOIN_AT_TIME DATETIME
 );

 /**
 一些函数
  */

  SELECT AVG(OrderPrice) AS OrderAverage FROM Orders;

SELECT Customer FROM Orders WHERE OrderPrice>(SELECT AVG(OrderPrice) FROM Orders);

SELECT COUNT(*) FROM Orders;

SELECT COUNT(DISTINCT column_name) FROM Orders;

SELECT FIRST(OrderPrice) AS FirstOrderPrice FROM Orders;
SELECT LAST(OrderPrice) AS LastOrderPrice FROM Orders;
SELECT MAX(OrderPrice) AS LargestOrderPrice FROM Orders;
SELECT MIN(OrderPrice) AS SmallestOrderPrice FROM Orders;

SELECT SUM(OrderPrice) AS OrderTotal FROM Orders;

/**
 Group by
 */

SELECT Customer,SUM(OrderPrice) FROM Orders GROUP BY Customer;
SELECT Customer,OrderDate,SUM(OrderPrice) FROM Orders GROUP BY Customer,OrderDate;

/**
Having 一般配合 group by 使用
 */

SELECT Customer,SUM(OrderPrice) FROM Orders GROUP BY Customer HAVING SUM(OrderPrice)<2000;

SELECT UCASE(LastName) as LastName,FirstName FROM Persons;
SELECT LCASE(LastName) as LastName,FirstName FROM Persons;

/**
MID 用于提取第几个字符
 */
SELECT MID(City,1,3) as SmallCity FROM Persons;

/**
len 应该对应于字符处理
 */
SELECT LEN(City) as LengthOfCity FROM Persons;

/**
保留 0 位小数返回
 */
SELECT ProductName, ROUND(UnitPrice,0) as UnitPrice FROM Products;

SELECT ProductName, UnitPrice, Now() as PerDate FROM Products;

SELECT ProductName, UnitPrice, FORMAT(Now(),'YYYY-MM-DD') as PerDate FROM Products;