# Write your MySQL query statement below

SELECT Distinct author_id As id FROM Views
WHERE author_id=viewer_id
ORDER BY id