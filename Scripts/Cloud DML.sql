select * from notice;
select * from exhibition;
select * from exhibition_period;

select DISTINCT exhibition_idx from exhibition_period;

insert into notice(title, content, writer) values('공지사항 디폴트 값 테스트','공지사항 테스트를 위한 글입니다.','김인환'); 

insert into exhibition(title, sub_title,discription,author,category,place,url,on_off,thumbnail)
				values('전시 테스트','테스트란 무엇인가?','전시회 테스트를 위한 데이터 넣는데만 한 세월, 결국 테스트는 노가다인가?',
					'김인환','테스트','휴스타 강의실','localhost:8080',true,'thumbnail domain');
					
insert into exhibition_period(exhibition_idx, `date`, start_time, end_time)
						values(5,date_add(now(), interval 2 day),now(),date_add(now(), interval 5 hour));
						
select e.exhibition_idx, e.title ,e.sub_title ,e.author 
  from exhibition_period ep join exhibition e on ep.exhibition_idx = e.exhibition_idx
group by ep.exhibition_idx;
  
select e.title ,e.sub_title
  from exhibition_period ep join exhibition e on ep.exhibition_idx = e.exhibition_idx;
  
delete from exhibition_period where period_idx = 15;

delete from notice where notice_idx = 8;

-- update notice
--   set title ="김인표의 화려한 공지사항", content =""

select now();
show global variables like '%zone%';

select *
  from exhibition_period ep join exhibition e on ep.exhibition_idx = e.exhibition_idx
 where date(ep.`date`) = date(NOW()) and e.category = '시각';