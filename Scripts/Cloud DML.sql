select * from notice;
select * from exhibition;
select * from exhibition_period;

insert into notice(title, content, writer, views, regist_date) values('첫번째 공지사항','공지사항 테스트를 위한 글입니다.','김인환',0,now()); 

insert into exhibition(title, sub_title,discription,author,category,place,url,on_off,thumbnail)
				values('전시 테스트','테스트란 무엇인가?','전시회 테스트를 위한 데이터 넣는데만 한 세월, 결국 테스트는 노가다인가?',
					'김인환','테스트','휴스타 강의실','localhost:8080',true,'thumbnail domain');
					
insert into exhibition_period(exhibition_idx, `date`, start_time, end_time)
						values(3,now(),now(),date_add(now(), interval 5 hour));