-- 테이블 삭제 쿼리
DROP TABLE IF EXISTS datatbl;

-- 테이블 생성 쿼리
CREATE TABLE datatbl(
	m_code INT AUTO_INCREMENT PRIMARY KEY,
    m_str VARCHAR(20) NOT NULL,
    m_int INT NOT NULL,
    m_date DATE NOT NULL
);

-- SELECT * FROM datatbl;

SELECT * FROM datatbl WHERE m_code = 1;

UPDATE datatbl
SET m_str = ?, m_int = ?, m_date = ?
WHERE m_code = ?;