/*
* SQL (Structured Query Language) : 구조적 질의(요청) 언어

* 종류
1. DDL(Data Definition Language) - 정의어
   - CREATE : 생성 (계정, 테이블, DB공간 등)
   - DROP : 삭제 (계정, 테이블, DB공간 등)
   - ALTER : 수정 (위험해서 잘 안 씀...그러느니 다시 만듦)
2. DML(Data Manipulation Language) - 조작어
   - INSERT : 데이터 삽입 (Create)
   - SELECT : 데이터 선택 (읽어오기, Read)
   - UPDATE : 데이터 수정 (Update)
   - DELETE : 데이터 삭제 (Delete)
3. DCL(Data Controller Language) - 제어어
   - GRANT : 권한 부여
   - REVOKE : 권한 취소
*/

-- 사용 DB 공간 지정 명령어
USE devdb; 
-- 또는 그냥 탐색창에서 해당 DB 더블클릭

/* 
* 테이블 생성
CREATE TABLE {테이블명} (
   col_name1 data_type [제약조건 1 제약조건2 ...],
   col_name2 data_type [제약조건 1 제약조건2 ...],
   ......
   col_nameN data_type [제약조건 1 제약조건2 ...]
);
*/

CREATE TABLE testTb1 (
	t_id VARCHAR(20),
	t_name VARCHAR(10),
	t_age INT
);

-- 회원, 상품, 제조회사, 주문, 게시글 테이블 만들어보기

CREATE TABLE memberTb (
	m_id VARCHAR(20),
	m_pwd VARCHAR(20),
	m_name VARCHAR(10).
    m_age INT,
    m_job VARCHAR(20),
    m_grade VARCHAR(10),
    m_point INT
);

CREATE TABLE boardTb (
	b_no INT,
    m_id VARCHAR(20),
	b_date DATE,
	b_title VARCHAR(20),
    b_content VARCHAR(200)
);

CREATE TABLE orderTb (
	o_no INT,
    m_id VARCHAR(20),
    p_no INT,
	o_amount INT,
	o_loc VARCHAR(50),
    o_date DATE
);

CREATE TABLE productTb (
	p_no INT,
    c_name VARCHAR(20),
    p_name VARCHAR(20),
    p_amount INT,
	p_price INT,
    cp_date DATE,
	cp_amount INT
);

CREATE TABLE companyTb (
	c_name VARCHAR(20),
	c_manager VARCHAR(20),
    c_loc VARCHAR(50),
	c_phone VARCHAR(15)
);