select * from notice;
select * from exhibition;
select * from exhibition_period;
select * from exhibition_file;

select DISTINCT exhibition_idx from exhibition_period;

insert into notice(title, content, writer) values('공지사항 디폴트 값 테스트','공지사항 테스트를 위한 글입니다.','김인환');

insert into exhibition(title, sub_title,discription,author,category,place,url,on_off,thumbnail)
				values('김인표의 화려한 시각예술','시각이란 무엇인가?','마서웨이홍의 등장! 시각을 포기할 것 인가?',
					'김인표',null,'휴스타 강의실','localhost:8080',true,'thumbnail domain');
					
insert into exhibition_period(exhibition_idx, `date`, start_time, end_time)
						values(10,date_add(now(), interval -3 day),now(),date_add(now(), interval 4 hour));
						
insert into exhibition_period(exhibition_idx, `date`, start_time, end_time)
						values(9,now(),now(),date_add(now(), interval 4 hour));

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
 
select * from exhibition e join exhibition_period ep on e.exhibition_idx = ep.exhibition_idx;

delete from exhibition_period where period_idx = 4;

update exhibition set discription = '인표는 자신의 눈을 지킬 수 있을 것인가? 아니면 그냥 시각을 쳐 포기할 것인가?' where exhibition_idx =3; 


delete from exhibition;
where exhibition_idx =5;

delete from exhibition where exhibition_idx =7;

