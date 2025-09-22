-- 코드를 입력하세요 
select b.title,
       b.board_id,
       r.reply_id,
       r.writer_id,
       r.contents,
       date_format(r.created_date, '%Y-%m-%d')
from used_goods_board b inner join used_goods_reply r on b.board_id=r.board_id
where year(b.created_date)=2022 and month(b.created_date)=10
order by r.created_date asc,
         b.title asc

-- SELECT : 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일
-- WHERE : 2022년 10월
-- FROM : 
-- 결과는 댓글 작성일을 기준으로 ASC, 만약 작성일이 같다면 게시글 제목을 기준으로 ASC
-- ORDER BY 댓글 작성일, 게시글 제목

