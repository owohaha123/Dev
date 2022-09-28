-- 여기에 작성하는 문장은 프로그램이 아니다
-- 모든 문장은 개별적으로 실행되며, 함께 실행할지 개별적으로 실행할지는 선택
-- 한줄주석 /*묶음주석*/

-- MySQL 사용자 추가
-- 사용자를 위한 공간 생성
CREATE DATABASE testDB;
-- CREATE DATABASE db명; 

-- 사용자 생성
CREATE USER 'test01'@'%' IDENTIFIED BY '1234';

-- 생성한 사용자에게 권한 부여
GRANT ALL PRIVILEGES ON testdb.* TO 'test01';