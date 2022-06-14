-- artfarm
DROP SCHEMA IF EXISTS `artfarm`;

-- artfarm
CREATE SCHEMA `artfarm`;

-- 공지사항
DROP TABLE IF EXISTS `artfarm`.`notice` RESTRICT;

-- 전시회
DROP TABLE IF EXISTS `artfarm`.`exhibition` RESTRICT;

-- 전시기간
DROP TABLE IF EXISTS `artfarm`.`exhibition_period` RESTRICT;

-- 전시자료
DROP TABLE IF EXISTS `artfarm`.`exhibition_data` RESTRICT;

-- 공지사항
CREATE TABLE `artfarm`.`notice` (
	`notice_idx`  INT(11) UNSIGNED NOT NULL COMMENT '공지사항번호', -- 공지사항번호
	`title`       VARCHAR(256)     NULL     COMMENT '공지제목', -- 공지제목
	`content`     VARCHAR(9999)    NULL     COMMENT '공지내용', -- 공지내용
	`writer`      VARCHAR(30)      NULL     COMMENT '작성자', -- 작성자
	`views`       INT(11)          NULL     COMMENT '조회수', -- 조회수
	`regist_date` DATETIME         NULL     COMMENT '작성일', -- 작성일
	`update_date` DATETIME         NULL     COMMENT '수정일' -- 수정일
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE `artfarm`.`notice`
	ADD CONSTRAINT `PK_notice` -- 공지사항 기본키
		PRIMARY KEY (
			`notice_idx` -- 공지사항번호
		);

ALTER TABLE `artfarm`.`notice`
	MODIFY COLUMN `notice_idx` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '공지사항번호';

-- 전시회
CREATE TABLE `artfarm`.`exhibition` (
	`exhibition_idx` BIGINT(20) UNSIGNED NOT NULL COMMENT '전시회번호', -- 전시회번호
	`title`          VARCHAR(256)        NULL     COMMENT '전시회제목', -- 전시회제목
	`sub_title`      VARCHAR(256)        NULL     COMMENT '부제', -- 부제
	`discription`    VARCHAR(9999)       NULL     COMMENT '소개', -- 소개
	`author`         VARCHAR(256)        NULL     COMMENT '작가', -- 작가
	`category`       VARCHAR(30)         NULL     COMMENT '카테고리', -- 카테고리
	`place`          VARCHAR(256)        NULL     COMMENT '장소', -- 장소
	`url`            VARCHAR(256)        NULL     COMMENT '전시회URL', -- 전시회URL
	`on_off`         BOOLEAN             NULL     COMMENT '온오프라인여부', -- 온오프라인여부
	`thumbnail`      VARCHAR(256)        NULL     COMMENT '썸네일' -- 썸네일
)
COMMENT '전시회';

-- 전시회
ALTER TABLE `artfarm`.`exhibition`
	ADD CONSTRAINT `PK_exhibition` -- 전시회 기본키
		PRIMARY KEY (
			`exhibition_idx` -- 전시회번호
		);

ALTER TABLE `artfarm`.`exhibition`
	MODIFY COLUMN `exhibition_idx` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '전시회번호';

-- 전시기간
CREATE TABLE `artfarm`.`exhibition_period` (
	`period_idx`     BIGINT(22) UNSIGNED NOT NULL COMMENT '전시기간번호', -- 전시기간번호
	`exhibition_idx` BIGINT(20) UNSIGNED NULL     COMMENT '전시회번호', -- 전시회번호
	`date`           DATE                NULL     COMMENT '전시일', -- 전시일
	`start_time`     TIMESTAMP           NULL     COMMENT '시작시간', -- 시작시간
	`end_time`       TIMESTAMP           NULL     COMMENT '종료시간' -- 종료시간
)
COMMENT '전시기간';

-- 전시기간
ALTER TABLE `artfarm`.`exhibition_period`
	ADD CONSTRAINT `PK_exhibition_period` -- 전시기간 기본키
		PRIMARY KEY (
			`period_idx` -- 전시기간번호
		);

ALTER TABLE `artfarm`.`exhibition_period`
	MODIFY COLUMN `period_idx` BIGINT(22) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '전시기간번호';

-- 전시자료
CREATE TABLE `artfarm`.`exhibition_data` (
	`data_idx`       BIGINT(23) UNSIGNED NOT NULL COMMENT '전시자료번호', -- 전시자료번호
	`exhibition_idx` BIGINT(20) UNSIGNED NULL     COMMENT '전시회번호', -- 전시회번호
	`name`           VARCHAR(50)         NULL     COMMENT '자료명', -- 자료명
	`data_path`      VARCHAR(256)        NULL     COMMENT '자료경로' -- 자료경로
)
COMMENT '전시자료';

-- 전시자료
ALTER TABLE `artfarm`.`exhibition_data`
	ADD CONSTRAINT `PK_exhibition_data` -- 전시자료 기본키
		PRIMARY KEY (
			`data_idx` -- 전시자료번호
		);

ALTER TABLE `artfarm`.`exhibition_data`
	MODIFY COLUMN `data_idx` BIGINT(23) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '전시자료번호';

-- 전시기간
ALTER TABLE `artfarm`.`exhibition_period`
	ADD CONSTRAINT `FK_exhibition_TO_exhibition_period` -- 전시회 -> 전시기간
		FOREIGN KEY (
			`exhibition_idx` -- 전시회번호
		)
		REFERENCES `artfarm`.`exhibition` ( -- 전시회
			`exhibition_idx` -- 전시회번호
		);

-- 전시자료
ALTER TABLE `artfarm`.`exhibition_data`
	ADD CONSTRAINT `FK_exhibition_TO_exhibition_data` -- 전시회 -> 전시자료
		FOREIGN KEY (
			`exhibition_idx` -- 전시회번호
		)
		REFERENCES `artfarm`.`exhibition` ( -- 전시회
			`exhibition_idx` -- 전시회번호
		);