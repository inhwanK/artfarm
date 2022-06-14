select * from notice;
select * from exhibition;
select * from exhibition_period;
select * from exhibition_file;

select DISTINCT exhibition_idx from exhibition_period;

insert into notice(title, content, writer) values('아트팜 공지사항','아트팜은 무명 아티스트들을 위한 플랫폼입니다.','관리자');

insert into exhibition(title, sub_title,discription,author,category,place,url,on_off,thumbnail)
				values('승화','昇華, Sublimation','「승화」는 2021년 국립현대미술관의 주최와 국립극장 국립무용단의 협조로 스톤 존스턴 영화감독이 2022년 5월 기획전시 《생의 찬미(Praise of Life)》를 위한 이머젼(immersion)컨텐츠로 제작되었다.

처용무(處容舞)는 우리나라에서 기록된 가장 오래되기도 하고 지속적으로 궁중에 의해 1100년 이상 전해져 내려온 무용이며 정화 의식이기도 하다. 다섯명의 무용수들은 다섯가지 색(오방색五方色)을 입고 동서남북과 중앙의 “오행五行”을 상징한다.

마지막에 들려주는 노래 "Beth"의 작사자는 성경의 시편에서 각 행의 첫글자가 히브리어의 두번째 글자 벳(ב)인 시에서 “청년이 무엇으로 그 행실을 깨끗케 하리이까” 하는 첫 질문에서 영감을 얻었다. 성경에 기록된 첫 살인에서 시작하여 노랫말은 마침내 2017년 미국 텍사스주에서 한 남자가 자신의 분노를 인내하지 못하고 26명을 희생시킨 참사의 영혼들을 기린다.',
					'김인표',null,'휴스타 강의실','localhost:8080',true,'thumbnail domain');

update exhibition 
set thumbnail = 'https://artfarm-storage.s3.ap-northeast-2.amazonaws.com/exhibition/3/KakaoTalk_20220126_170420283.jpg'

update exhibition 
set thumbnail = 'https://artfarm-storage.s3.ap-northeast-2.amazonaws.com/exhibition/6/9.jpg'
where exhibition_idx = 6;

insert into exhibition_period(exhibition_idx, `date`) values(2,date_add(now(), interval 2 day));
insert into exhibition_period(exhibition_idx, `date`) values(2,now());
						
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

