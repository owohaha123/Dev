USE clubdb;

-- 회원 테이블
CREATE TABLE membertbl (
	m_id VARCHAR(20) NOT NULL PRIMARY KEY,
	m_pwd VARCHAR(20) NOT NULL,
	m_name VARCHAR(10) NOT NULL,
	m_phone VARCHAR(20) NOT NULL,
	m_birth DATE NOT NULL
);

-- 동호회 테이블
CREATE TABLE clubtbl (
	cb_no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	cb_name VARCHAR(20) NOT NULL,
	cb_content VARCHAR(50) NOT NULL
);

-- 가입 테이블
CREATE TABLE jointbl (
    m_id VARCHAR(20) NOT NULL,
    cb_no INT NOT NULL,
    j_date DATE DEFAULT (curdate()),
	-- 외래키 설정
	FOREIGN KEY (m_id) REFERENCES membertbl (m_id),
	FOREIGN KEY (cb_no) REFERENCES clubtbl (cb_no)  
);


INSERT INTO membertbl VALUES('catlover' , '1234' , '고사랑' , '010-1111-1111' , '2002-10-11');
INSERT INTO membertbl VALUES('booklover' , '1234' , '도애정' , '010-2222-2222' , '2002-11-11');
INSERT INTO membertbl VALUES('balllover' , '1234' , '공조아' , '010-3333-3333' , '2002-12-11');
INSERT INTO clubtbl VALUES(NULL , '야구사랑' , '야구가 좋은 사람들');
INSERT INTO clubtbl VALUES(NULL , '책사랑' , '활자러버');
INSERT INTO clubtbl VALUES(NULL , '삼색이삼랑해' , '삼색아 기다려');

select * from membertbl;
select * from clubtbl;
select * from jointbl;
select * from membertbl where m_id = 'catlover';
select count(*) from membertbl where m_id = 'catlover' and m_pwd = '1234';