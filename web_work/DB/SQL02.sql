/*
MySQL 데이터타입 (자료형)
1. 문자형 (5.0.3 이전 버전은 byte로, 이후 버전은 글자수로 크기 지정)
   1) CHAR(n) - 고정길이. n의 수치로 크기를 결정 (255자)
   2) VARCHAR(n) - 가변 길이 (65,535byte) ★많이 씀
   3) TEXT(n) - VARCHAR과 같으나 조회 속도가 느림 (65,535byte)
			 보통 크기를 설정하지 않고 사용
   4) TINYTEXT(n) - 255자
   5) MEDIUMTEXT(n) - 16,777,215자
   6) LONGTEXT(n) - 4,294,967,295자
   7) JSON - json 형태로 저장 (예. {'이름':'홍길동', '나이':20})
   
2.숫자형
   1) TINYINT(n) - 정수. -128 ~ 127
   2) SMALLINT(n) - -32,768 ~ 32,767
   3) MEDIUMINT(n) - -8,388,608 ~ 8,388,607
   4) INT(n) - -2,147,483,548 ~ 2,147,483,547
   5) BIGINT(n) - 무제한
   6) FLOAT(n,d) - 실수. n:전체길이, d:소수점이후
				   (7,2) -> 99,999.99
				   부동 소수형 ★많이 씀
   7) DEFCIMAL(n,d) - 고정 소수형
   8)DOUBLE(n,d) - 부정 소수형(문자열로 저장)
   
3. 날짜형
   1) DATE - 날짜(년,월,일) 형태
   2) TIME - 시간(시,분,초) 형태
   3) DATETIME - 날짜와 시간이 합쳐진 형태 (8byte)
				 1000-01-01 부터 ★많이 씀
   4) TIMESTAMP - 날짜와 시간이 합쳐진 형태 (4byte)
	 			  1970-01-01 부터
   5) YEAR - 년도만 저장하는 형태
UTC(Universal Time Coordinated) - 협정 세계시

4. 이진 데이터형(binary)
  1) BINARY(n) & BYTE(n) - GHAR 형태의 이진데이터
  2) VARBINARY(n) - VARCHAR 형태의 이진데이터
  3) TINYBLOB(n) - 이진데이터(파일류). 255byte
  4) BLOB(n) - 65,535byte
  5) MIDIUMBLOB(n) - 16,777,215byte
  6) LONGBLOB(n) - 4,294,967,295byte
*/
-- 위지윅(WYSIWYG, What You See Is What You Get)
-- 보이는대로 처리한다의 의미! (웹 에디터) BLOB 타입 사용

/*
제약 조건
- 데이터의 무결성을 지키기 위해 데이터를 입력할 때 실행되는 검사규칙
- CREATE 문이나 ALTER 문에서 사용
1. NOT NULL - 해당 컬럼에 NULL이 들어갈 수 없다 (반드시 입력)
2. UNIQUE - 해당 컬럼에 중복값을 허용하지 않는다
3. PRIMARY KEY - 해당 컬럼을 기본키로 설정 (NOT NULL + UNIQUE)
4. FOREIGN KEY - 해당 컬럼을 외래키로 설정
5. DEFAULT - 해당 컬럼에 기본값을 설정

CONSTRAINT 키워드 : 특정 컬럼에 제약조건을 설정하기 위한 명령어

컬럼에 제약조건을 넣는 방식
1. 컬럼 작성 시 같이 한다
2. CONSTRAINT 키워드로 나중에 추가
*/

-- 테이블 삭제 : DROP TABLE {테이블명};
DROP TABLE member;
-- 회원테이블 생성(제약조건 추가)
CREATE TABLE member (
	m_id VARCHAR(20) PRIMARY KEY,
	m_pwd VARCHAR(20) NOT NULL,
	m_name VARCHAR(10) NOT NULL,
    m_age INT,
    m_job VARCHAR(20),
    m_grade VARCHAR(10) DEFAULT 'silver', -- DEFAULT : 비어있다면 'silver'를 넣자
										  -- 따라서 NOT NULL은 DEFAULT와 굳이 같이 쓰진 않음
	m_point INT DEFAULT 0
);

-- 실습 예) 나중에 자세히~
INSERT INTO member
-- 기본값 사용시엔 null이 아닌 default 사용
VALUES ('hong02','1234','홍길동','20','학생', default, default);
commit; -- 입력 최종 실행

SELECT * FROM member; -- 테이블 내용 보기

/*
CONSTRAINT를 사용한 제약조건 처리
1. unique
CONSTRAINT 제약조건명 UNIQUE (컬럼명)
2. primary key
CONSTRAINT 제약조건명 PRIMARY KEY (컬럼명)
3. Foreign key
CONSTRAINT 제약조건명 FOREIGN KEY (컬럼명)
REFERENCE 테이블명 (컬럼명)
제약조건명 : 제약조건을 따로 관리가 가능하면
해당 제약조건을 나중에 변경하거나 제거할 때 구분하기 위해 사용
보통 테이블명과 컬럼명, 제약조건의 단어를 조합하여 작명
예) MEMBER 테이블의 기본키 : m_id_pk -- pk: PRIMARY KEY 약자
*/

-- 제조회사 테이블
CREATE TABLE company (
	c_name VARCHAR(20) PRIMARY KEY,
	c_manager VARCHAR(20) NOT NULL,
    c_loc VARCHAR(50) NOT NULL,
	c_phone VARCHAR(15) NOT NULL
);

-- 상품 테이블
CREATE TABLE product (
	p_no INT PRIMARY KEY,
    p_cname VARCHAR(20) NOT NULL,
    p_name VARCHAR(20) NOT NULL,
    p_amount INT DEFAULT 0,
	p_price INT NOT NULL,
    cp_date DATE,
	cp_amount INT,
    CONSTRAINT p_c_fk FOREIGN KEY (p_cname)
    REFERENCES company (c_name)
);

-- 주문 테이블
CREATE TABLE ordertbl (
	o_no INT PRIMARY KEY,
    o_mid VARCHAR(20) NOT NULL,
    o_pno INT NOT NULL,
	o_amount INT NOT NULL,
	o_loc VARCHAR(50) NOT NULL,
    o_date DATE,
	CONSTRAINT o_m_fk FOREIGN KEY (o_mid)
    REFERENCES member (m_id),
    CONSTRAINT o_p_fk FOREIGN KEY (o_pno)
    REFERENCES product (p_no)
    ON UPDATE CASCADE ON DELETE CASCADE
    -- 상품테이블의 상품번호를 수정/삭제하면,
	-- 그 번호를 사용하는 주문의 정보도 같이 수정/삭제 한다
);

/*
 ON DELETE
  - 참조되는 테이블의 값이 삭제될 경우
 , ON UPDATE
  - 참조되는 테이블의 값이 수정될 경우
   설정 동작
   1. CASCADE : 참조하는 테이블의 값도 같이 처리
   2. SET NULL : 참조하는 테이블의 값을 NULL로 변경
   3. NO ACTION : 참조하는 테이블의 값에 아무 변경 안 함
   4. SET DEFAULT : 참조하는 테이블의 값을 기본값으로 변경
   5. RESTRICT : 참조되는 테이블의 값이 변경 불가
	
   예) 참조되는 테이블 : member (기본키를 제공하는 테이블)
	   참조하는 테이블 : ordertbl (외래키가 있는 테이블)
*/

/*
자동으로 증가하는 정수 값을 사용하는 컬럼 설정
AUTO_INCREMENT : 1씩 증가하는 정수값이 자동으로 삽입됨.
정수형 기본키 컬럼에만 사용
예)
CREATE TABLE datatbl(
d_no INT AUTO_INCREMENT PRIMARY KEY,
d_data1 VARCHAR(10) NOT NULL,
.....
정수형 기본키 컬럼에만 사용
예)
CREATE TABLE datatbl(
	d_no INT AUTO_INCREMENT PRIMARY KEY,
    d_data1 VARCHAR(10) NOT NULL,
    .....
);
*/

/*
테이블 삭제와 수정
삭제 : DROP TABLE {테이블명};
수정 : ALTER TABLE {테이블명}
  1) 컬럼 추가 : ADD {컬럼명} {타입};
  2) 컬럼 변경 : MODIFY COLUMN {컬럼명} {변경타입};
			  해당 컬럼에 데이터가 있을 경우 변경 불가
  3) 컬럼 삭제 : DROP COLUMN {컬럼명};
  4) 테이블명 변경 : RENAME {새컬럼명};
  5) 컬럼명 변경 : CHANGE COLUMN {기존컬럼명} {새컬럼명};
				타입도 함께 변경 가능
*/

ALTER TABLE testtbl
ADD COLUMN phone VARCHAR(15);

ALTER TABLE testtbl
MODIFY COLUMN phone VARCHAR(20);

ALTER TABLE testtbl
CHANGE COLUMN phone t_phone VARCHAR(20);

ALTER TABLE testtbl
DROP COLUMN t_phone;

ALTER TABLE testtbl
RENAME test_tbl;

/*
제약조건의 추가/삭제
1) 기본키 추가 : ADD PRIMARY KEY (컬럼명);
2) 기본키 삭제 : DROP PRIMARY KEY;
3) 외래키 추가 : ADD CONSTRAINT 제약조건명
			  FOREIGN KEY (컬럼명)
              REFERENCES 테이블명 (컬럼명)
4) 외래키 삭제 : DROP FOREIGN KEY 제약조건명;
5) 제약조건 추가/삭제 : ADD CONSTRANT 제약조건명 {제약조건_키워드};
				   DROP CONSTRANT 제약조건명;
*/
ALTER TABLE test_tbl
ADD PRIMARY KEY (t_id);

ALTER TABLE test_tbl
ADD CONSTRAINT t_c_fk FOREIGN KEY (t_name)
REFERENCES company (c_name);

-- 테이블 상태 확인 명령어 : DESC{테이블명}
DESC board;
show tables; -- 공간에 작성된 테이블명 확인 명령