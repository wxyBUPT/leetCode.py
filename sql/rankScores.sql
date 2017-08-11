/**
178. Rank Scores
Write a SQL query to rank scores. If there is a tie between two scores,
both should have the same ranking. Note that after a tie,
the next ranking number should be the next consecutive integer value.
In other words, there should be no "holes" between ranks.

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
For example, given the above Scores table, your query should generate the following report (order by highest score):

+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
 */

Create table If Not Exists Scores (Id int, Score DECIMAL(3,2));
Truncate table Scores;
insert into Scores (Id, Score) values ('1', '3.5');
insert into Scores (Id, Score) values ('2', '3.65');
insert into Scores (Id, Score) values ('3', '4.0');
insert into Scores (Id, Score) values ('4', '3.85');
insert into Scores (Id, Score) values ('5', '4.0');
insert into Scores (Id, Score) values ('6', '3.65');

/**
Use two variables
 */
SELECT Score, @rank := @rank + (@prev <> (@prev := Score)) Rank
FROM Scores, (SELECT @rank:=0, @prev := -1) init
ORDER BY Score DESC;

SELECT
Score,
(SELECT COUNT(DISTINCT Score) FROM Scores WHERE Score >= s.Score) Rank
FROM Scores s
ORDER By Score desc;

SELECT
Score,
(SELECT count(*) FROM (SELECT DISTINCT Score s FROM Scores) tmp WHERE tmp.s >= Score) Rank
FROM Scores
ORDER BY Score DESC;

SELECT s.Score, COUNT (DISTINCT t.Score) Rank
FROM Scores s JOIN Scores t on (s.Score <= t.Score)
GROUP By s.Id
ORDER By s.Score desc;
