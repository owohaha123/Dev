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
USE devdb_1; 
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

CREATE TABLE testTbl (
	t_id VARCHAR(20),
	t_name VARCHAR(10),
	t_age INT
);