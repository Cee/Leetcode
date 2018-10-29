# Write your MySQL query statement below
# SELECT IFNULL(ROUND(COUNT(*) / (SELECT COUNT(*) FROM (SELECT sender_id, send_to_id FROM friend_request GROUP BY sender_id, send_to_id) p), 2), 0) AS accept_rate
# FROM (SELECT sender_id, send_to_id
#       FROM friend_request
#       GROUP BY sender_id, send_to_id) r, 
#       (SELECT requester_id, accepter_id
#       FROM request_accepted 
#       GROUP BY requester_id, accepter_id) a
# WHERE r.sender_id = a.requester_id AND r.send_to_id = a.accepter_id
select
round(
    ifnull(
    (select count(*) from (select distinct requester_id, accepter_id from request_accepted) as A)
    /
    (select count(*) from (select distinct sender_id, send_to_id from friend_request) as B),
    0)
, 2) as accept_rate;