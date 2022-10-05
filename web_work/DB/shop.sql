USE shopdb;

-- 회원 테이블
CREATE TABLE membertbl (
m_id VARCHAR(20) NOT NULL PRIMARY KEY,
m_pwd VARCHAR(20) NOT NULL,
m_name VARCHAR(10) NOT NULL,
m_address VARCHAR(20) NOT NULL,
m_charge INT DEFAULT 0 NOT NULL
);

-- 제품 테이블
CREATE TABLE producttbl (
pr_no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
pr_name VARCHAR(20) NOT NULL,
pr_price INT NOT NULL,
pr_amount INT DEFAULT 0
);

-- 구매 테이블
CREATE TABLE buytbl (
pc_no INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
m_id VARCHAR(20) NOT NULL,
pr_no INT NOT NULL,
pc_date DATE DEFAULT (curdate()),
pc_time TIME DEFAULT (CURRENT_TIME),
pc_amount INT NOT NULL,
pc_price INT NOT NULL,
pc_condition VARCHAR(10) DEFAULT '정상',
-- 회원아이디, 상품번호 외래키로 설정
FOREIGN KEY (m_id) REFERENCES membertbl (m_id),
FOREIGN KEY (pr_no) REFERENCES producttbl (pr_no)
);

-- 회원 등록 / 상품 등록
INSERT INTO membertbl VALUES('spotato', 1234, '고구마', '흙시 흙구 땅바닥리', DEFAULT);
INSERT INTO membertbl VALUES('ppotato', 1234, '왕감자', '흙시 흙구 땅바닥리', DEFAULT);
INSERT INTO membertbl VALUES('tomatto', 1234, '강토티', '흙시 흙구 땅바닥리', DEFAULT);
INSERT INTO membertbl VALUES('oonion', 1234, '한양파', '흙시 흙구 땅바닥리', DEFAULT);
INSERT INTO membertbl VALUES('meatball', 1234, '고기원', '목장시 잔디구 풀밭동', DEFAULT);
INSERT INTO producttbl VALUES(NULL, '최강고구마', 800, 999);
INSERT INTO producttbl VALUES(NULL, '최강감자', 1500, 999);
INSERT INTO producttbl VALUES(NULL, '샵샤브샤브', 8520, 999);
INSERT INTO producttbl VALUES(NULL, '얼큰마라탕', 6500, 999);
INSERT INTO producttbl VALUES(NULL, '팔딱회', 10000, 999);

-- spotato 씨가 50000원 충전
UPDATE membertbl
SET m_charge = m_charge + 50000
WHERE m_id = 'spotato';

UPDATE membertbl
SET m_charge = m_charge + 100000
WHERE m_id = 'ppotato';

-- 구매 시나리오(샵샤브샤브 2개 구매 시)
-- 1. 제품 수량 차감
UPDATE producttbl
SET pr_amount = pr_amount - 2
WHERE pr_name = '샵샤브샤브';
-- 2. 충전금액 차감
UPDATE membertbl
SET m_charge = m_charge - (2 * 8520)
WHERE m_id = 'spotato';
-- 3. 구매데이터 입력
INSERT INTO buytbl VALUES(NULL, 'spotato', 3, DEFAULT , DEFAULT, 2 , (2 * 8520) , DEFAULT);

-- 반품 시나리오(샵샤브샤브 2개 반품 시)
-- 1. 구매상태 변경 (정상 -> 취소)
UPDATE buytbl
SET pc_condition = '취소'
WHERE m_id = 'spotato';
-- 2. 충전금액 증가(반환)
UPDATE membertbl
SET m_charge = m_charge + (2 * 8520)
WHERE m_id = 'spotato';
-- 3. 제품수량 증가(반환)
UPDATE producttbl
SET pr_amount = pr_amount + 2
WHERE pr_name = '샵샤브샤브';

-- 날짜별 판매량, 판매금액/ 제품별 판매량, 판매금액 산정
UPDATE producttbl
SET pr_amount = pr_amount - 3
WHERE pr_name = '최강고구마';
UPDATE membertbl
SET m_charge = m_charge - (3 * 800)
WHERE m_id = 'spotato';
INSERT INTO buytbl VALUES(NULL, 'spotato', 1, DEFAULT , DEFAULT, 3 , (3 * 800) , DEFAULT);

UPDATE producttbl
SET pr_amount = pr_amount - 5
WHERE pr_name = '최강감자';
UPDATE membertbl
SET m_charge = m_charge - (5 * 1500)
WHERE m_id = 'spotato';
INSERT INTO buytbl VALUES(NULL, 'spotato', 2, '2022-10-03' , DEFAULT, 5 , (5 * 1500) , DEFAULT);

UPDATE producttbl
SET pr_amount = pr_amount - 3
WHERE pr_name = '팔딱회';
UPDATE membertbl
SET m_charge = m_charge - (3 * 10000)
WHERE m_id = 'ppotato';
INSERT INTO buytbl VALUES(NULL, 'ppotato', 5, DEFAULT , DEFAULT, 3 , (3 * 10000) , DEFAULT);

-- 날짜별 판매량, 판매금액
SELECT pc_date, count(pc_amount), sum(pc_price)
FROM buytbl
GROUP BY pc_date;

-- 제품별 판매량, 판매금액
SELECT P.pr_no, P.pr_name, B.pc_amount, sum(B.pc_price)
FROM producttbl P INNER JOIN buytbl B
ON P.pr_no = B.pr_no
WHERE pc_condition = '정상'
GROUP BY P.pr_name;



select * from membertbl;
select * from producttbl;
select * from buytbl;