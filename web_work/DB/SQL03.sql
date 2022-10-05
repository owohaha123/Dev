/*
DML (데이터 조작어)
1. INSERT(삽입)
- 테이블에 데이터를 삽입하는 명령어
- 문법>
INSERT INTO {테이블명} (컬럼명1, 컬럼명2, ...)
VALUES ('데이터' , '데이터' , ...);
-- 데이터의 배치 순서는 위의 컬럼명 배치 순서대로
    
    INSERT INTO {테이블명}
    VALUES ('데이터' , '데이터' , ...);
    -- 데이터의 배치 순서는 테이블의 컬럼 순서대로
    */
    

DESC board;

INSERT INTO board (b_mid , b_title, b_content, b_date)
VALUES ('test01','그냥...','아무거나','2022-09-30');

INSERT INTO board
VALUES (null, 'jun01','그냥2...',null,'2022-09-30');

COMMIT;

SELECT * FROM board;

-- 자동 commit 상태 확인문장
select @@autocommit;
set autocommit = 0;

/*
2. UPDATE(수정)
- 테이블에 삽입된 데이터를 수정하는 명령어
- 컬럼 단위로 수정
- 행을 선택하는 조건이 없는 경우 모든 행을 수정
- 문법>
UPDATE {테이블명}
SET 컬럼명1 = 변경데이터[, 컬럼명2 = 변경데이터, ...]
WHERE 조건;
    - WHERE 절?
    - 조건을 지정할 때 사용하는 명령어 절
    - 이 절에서 설정된 조건에 따라 맞는 행만 선별
    */

UPDATE board
SET b_date = '2022-09-30';

ROLLBACK; -- 복구 명령어
COMMIT; -- 최종 실행(승인) 명령어
/*
Safe Updates : 기본키를 사용하지 않은
update나 delete를 방지하는 기능
Workbench 옵션(Edit>Preferences)에서
Safe Updates 체크박스 해제
*/

/*
3. DELETE(삭제)
- 테이블에서 데이터를 삭제 명령어
- 행단위로 수행
- 조건이 없을 경우 모든 행을 삭제
- 문법>
DELETE FROM {테이블명}
[WHERE 조건];
*/

DELETE FROM board
WHERE b_no = 4;

SELECT * FROM board;

ROLLBACK;
COMMIT;

DELETE FROM board
WHERE b_date = '2022-09-30';

DELETE FROM board
WHERE b_mid = 'jun01';

SELECT * FROM member;

-- 상품 구매 시 구매금액의 1% 적립
-- 홍길동이 50000원 상품 구매
UPDATE member
SET m_point = m_point + 50000 * 0.01
WHERE m_id = 'hong02';
-- 새해가 밝았습니다. 모든 회원이 나이를 1살 더 먹었습니다.
-- 이 사항을 DB에 반영해 주세요
UPDATE member
SET m_age = m_age + 1;

/*
SQL 쿼리문 작성법(권장)
1. SQL문은 대소문자 구분없음
2. 한문장은 여러줄로 작성 가능
3. (일반적으로)SQL 키워드는 대문자로,
이름(테이블명, 컬럼명 등)은 소문자로 작성
4. 문장은 마지막은 ';' 를 기술 (Must!)
5. 이름(테이블명, 컬럼명 등)에 공백 사용 안 함
대신 '_' 등을 사용
*/

/*
4. SELECT(선택, 읽어오기)
- DQL(Data Query Language, 데이터 질의어)로 분류하기도 함
- 테이블의 데이터를 검색하는 명령어
- 행단위로 처리하면 결과에 대한 컬럼을 지정할 수 있음
- 문법>
SELECT [DISTINCT] {*, 컬럼명 [별칭], 컬럼명 [별칭], ...}
FROM {테이블명}
[WHERE 조건]
[ORDER BY {컬럼명} [ASC|DESC]];
    
    DISTINCT : 결과 데이터의 중복 제거
    * : 모든 컬럼.
    별칭(Alias) : 컬럼 이름에 대한 별명
    ORDER BY : 특정 컬럼의 데이터로 결과를 정렬
    ASC : 오름차순 정렬
    DESC : 내림차순 정렬
    */

SELECT m_id, m_name, m_age
FROM member
WHERE m_age >= 25
ORDER BY m_age DESC
;

/*
WHERE 절의 연산자
1. 비교연산자 (= != < > >= <=)
- '=' 연산자의 차이(Java 와 SQL)
- Java의 같다 : ==
- SQL의 같다 : =
- Java의 대입 : =
- SQL의 대입 : = (UPDATE의 SET 절에서만 사용)
2. 논리연산자 (AND, OR, NOT)
	BETWEEN a AND b
	IN (list) : list에 찾고자 하는 조건값의 목록을 작성
	NOT을 조합하여 반대 경우의 조건을 작성
3. 문자열 검색 연산자
- LIKE - 컬럼의 데이터를 문자열로 검색
- 모르는 부분 처리를 위한 특수 문자
  1) % : 여러 글자를 대체하여 표현(대체하는 글자의 수는 0개부터)
        ex) LIKE '%대%'; : '대'로 시작하거나, 중간에 들어가거나, 마지막이 '대'로 끝나는 데이터
  2) _ : 한 글자를 대체하여 표현
        ex) LIKE '_대'; : 두번째 글자가 '대'인 두글자의 단어를 검색
			LIKE '__대'; : 세번째 글자가 '대'인 세글자의 단어를 검색
			LIKE '__대%'; : 전체 글자의 개수는 모르나 3번째 글자가 '대'인 단어를 검색
4. NULL 관련 연산자
- IS NULL : 컬럼의 데이터가 null인 행 검색
  IS NOT NULL : 컬럼의 데이터가 null이 아닌 행 검색
*/
-- SELECT 실습을 위해 employees 로 변경
use employees;
-- 사원 전체의 정보
SELECT *
FROM employees
;

SELECT emp_no, first_name
FROM employees
;

-- 여사원의 사번과 이름 검색
SELECT emp_no, first_name
FROM employees
WHERE gender = 'F'
;
-- 컬럼 별칭 사용
SELECT emp_no "사원 번호", first_name 이름
FROM employees ;
-- 고용일 1992년부터 1995년 사이인 사원의 사번과 이름 검색
SELECT emp_no, first_name, last_name, hire_date
FROM employees
WHERE hire_date BETWEEN '1992-01-01'
AND '1995-12-31'
ORDER BY hire_date DESC -- 오름차순(ASC)은 대부분 생략
;

SELECT emp_no, first_name, last_name, hire_date
FROM employees
WHERE hire_date >= '1992-01-01'
AND hire_date <='1995-12-31' -- (= BETWEEN A AND B)
ORDER BY hire_date ASC, first_name DESC, last_name ASC-- 정렬기준 여러개 설정 가능
;

-- 문제
-- 1. 1990년 이후에 입사한 직원의 직원번호, 성명을 구하시오
SELECT emp_no, first_name, hire_date
FROM employees
WHERE hire_date >= '1990-01-01'
ORDER BY hire_date;
-- 2. 이름이 Mark 인 직원의 직원번호를 구하시오
SELECT emp_no, first_name, last_name
FROM employees
WHERE first_name = 'Mark'
ORDER BY emp_no;
-- 3. 이름이 Jun 이거나 생일이 1960 이후인 직원의 성과 직원번호를 구하시오 (OR 연산자 사용)
SELECT emp_no, first_name, birth_date
FROM employees
WHERE first_name = 'Jun'
OR birth_date >= '1960-01-01'
ORDER BY birth_date , first_name;
-- LIKE 사용 예
-- 이름에 'a'가 들어가는 사원의 사번과 이름
-- 숫자형 컬럼에는 사용하지 않는다
SELECT emp_no, first_name
FROM employees
WHERE BINARY first_name LIKE '%A%'
;
-- 대소문자를 구분하여 검색 결과 구하기 : BINARY
-- 검색 시 WHERE 절에서 컬럼명 앞에 BINARY 추가
-- 테이블 생성 시 type 다음에 BINARY 추가
-- 예) m_id VARCHAR(10) BINARY NAT NULL,
-- IN 연산자
-- 복합적 or 연산
-- 이름이 'Mark'이거나 'Elvis'이거나 'Ohad'인 사원의 사번과 생일 구하기
SELECT emp_no, first_name, birth_date
FROM employees
WHERE first_name = 'Mark'
OR first_name = 'Elvis'
OR first_name = 'Ohad'
;

SELECT emp_no, first_name, birth_date
FROM employees
WHERE first_name IN ('Mark','Elvis','Ohad')
;
DESC salaries;

SELECT *
FROM salaries
;

-- 각 사원의 현재 급여를 구하시오
-- to_date가 '9999-01-01'이면 현재의 급여
SELECT emp_no, salary
FROM salaries
WHERE to_date LIKE '9999%'
;
SELECT MAX(salary), emp_no -- MAX: 최댓값
FROM salaries
WHERE to_date LIKE '9999%'
;
SELECT emp_no
FROM salaries
WHERE salary = 158220
;
SELECT emp_no, first_name
FROM employees
WHERE emp_no = 43624
;
SELECT emp_no, dept_no
FROM dept_emp
WHERE emp_no = 43624
AND to_date LIKE '9999%'
;
SELECT *
FROM departments
WHERE dept_no = 'd007'
;
-- Sales 부서장은 누구?
SELECT dept_no, emp_no
FROM dept_manager
WHERE dept_no = 'd007'
AND to_date LIKE '9999%'
;
SELECT emp_no, first_name
FROM employees
WHERE emp_no = '111133'
;
-- DISTINCT : 검색 결과의 중복 제거
SELECT DISTINCT dept_no
FROM dept_emp
;
SELECT dept_no
FROM dept_emp
;
-- 출력 개수 제한 : LIMIT n[, m]
-- n 단독 : 0번부터 n-1번까지의 행 조회
-- n과 m의 경우, n : 조회할 행의 시작번호,
-- m : 조회할 행의 개수
SELECT *
FROM employees
LIMIT 10
;
SELECT *
FROM employees
WHERE gender = 'F'
ORDER BY first_name
LIMIT 0, 10
;

show tables;

SELECT DISTINCT deptno
FROM emp;

SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM salgrade;

/*
집계함수

- 행에 대한 산술적인 연산을 수행하는 함수
- 주로 숫자타입의 컬럼에 적용하는 함수
    1. count(컬럼) - 전체 또는 특정 컬럼의 값이 있는 행의 개수
	   count(*) - 모든 행의 개수
       count(컬럼명) - 해당 컬럼의 값이 null이 아닌 행의 개수
    2. sum(컬럼) - 해당 컬럼의 모든 행의 합산
    3. avg(컬럼) - 해당 컬럼의 모든 행의 평균값
    4. min(컬럼) - 해당 컬럼의 모든 행 중에 가장 작은 값
    5. max(컬럼) - 해당 컬럼의 모든 행 중에 가장 큰 값
    6. stdev(컬럼) - 표준변차 함수
    7. var_samp(컬럼) - 분산을 구하는 함수
    */
-- 전체 사원 수
SELECT count(*)
FROM emp
;
-- comm을 받는 사원 수
SELECT count(comm)
FROM emp;
-- 회사의 전체 인건비는 얼마?
SELECT sum(sal)
FROM emp;
-- 회사의 평균 인건비(급여)는 얼마?
SELECT avg(sal)
FROM emp;
-- 최소 급여와 최대 급여는?
SELECT min(sal), max(sal)
FROM emp;

/*
GROUP BY, HAVING
행을 그룹으로 묶어주는 역할
집계함수를 사용할 수 있음
*/
-- 부서별 인원수를 파악하자
SELECT deptno
FROM emp
WHERE deptno = 40;

SELECT deptno, count(*) 인원수
FROM emp
GROUP BY deptno;

-- 부서별 급여 합계, 급여 평균
SELECT deptno, sum(sal), avg(sal), max(sal), min(sal)
FROM emp
GROUP BY deptno;
-- HAVING : 그룹화에 대한 조건을 작성하는 구문
-- 사원 수가 5명 이상인 부서는?
SELECT deptno, count(*)
FROM emp
GROUP BY deptno
HAVING count(*) >= 5;
-- HAVING 절은 GROUP BY 절과 함께 사용 (단독 사용 불가)
-- WITH ROLLUP : 그룹의 중간 합계 및 총합
SELECT deptno, job, sum(sal), count(*)
FROM emp
GROUP BY deptno, job
WITH ROLLUP;
-- 실습 문제
-- 1. 직함별 평균 급여를 조회하시오
SELECT job, avg(sal)
FROM emp
GROUP BY job;
-- 2. 직함별 최대 급여, 최소 급여 조회하시오
SELECT job, max(sal), min(sal)
FROM emp
GROUP BY job;
-- 3. 직함별 인원수를 조회하시오
SELECT job, count(*)
FROM emp
GROUP BY job;
-- 4. 부서별 사원수와 커미션을 받는 사원들의 수를 조회하시오
SELECT deptno, count(*), count(comm)
FROM emp
GROUP BY deptno;