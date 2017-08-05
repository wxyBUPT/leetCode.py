
CREATE TABLE If NOT EXISTS Employees_China (id int, E_Name VARCHAR(32));

CREATE TABLE If NOT EXISTS Employees_Us (id int, E_Name VARCHAR(32));

INSERT INTO Employees_China (id, E_Name) VALUES (1, "Zhang, Hua");

INSERT INTO Employees_Us (id, E_Name) VALUES (2, "Petter");

/**
每一列的类型相同即可以合并, union 操作选取了不同的值
 */
SELECT E_Name FROM Employees_China UNION SELECT E_Name FROM Employees_US;
SELECT E_Name FROM Employees_China UNION ALL SELECT E_Name as E FROM Employees_US;