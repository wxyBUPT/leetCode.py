/**
197. Rising Temperature
Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.

+---------+------------+------------------+
| Id(INT) | Date(DATE) | Temperature(INT) |
+---------+------------+------------------+
|       1 | 2015-01-01 |               10 |
|       2 | 2015-01-02 |               25 |
|       3 | 2015-01-03 |               20 |
|       4 | 2015-01-04 |               30 |
+---------+------------+------------------+
For example, return the following Ids for the above Weather table:
+----+
| Id |
+----+
|  2 |
|  4 |
+----+
 */

Create table If Not Exists Weather (Id int, Date date, Temperature int);
Truncate table Weather;
insert into Weather (Id, Date, Temperature) values ('1', '2015-01-01', '10');
insert into Weather (Id, Date, Temperature) values ('2', '2015-01-02', '25');
insert into Weather (Id, Date, Temperature) values ('3', '2015-01-03', '20');
insert into Weather (Id, Date, Temperature) values ('4', '2015-01-04', '30');


SELECT w1.Id FROM Weather w1 LEFT JOIN Weather w2 ON
TO_DAYS(w1.DATE) - TO_DAYS(w2.DATE)=1 WHERE w1.Temperature > w2.Temperature;
/**
觉得下面这种做法没有做 join 快
 */
SELECT w1.Id FROM Weather w1, Weather w2 WHERE
w1.Temperature > w2.Temperature AND TO_DAYS(w1.DATE) - TO_DAYS(w2.DATE) = 1;
