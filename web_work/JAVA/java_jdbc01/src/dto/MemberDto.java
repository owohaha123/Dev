package dto;

//import lombok.Data;

//@Data // 어노테이션 (@Data = @Getter + @Setter)
public class MemberDto {
    private String m_id;
    private String m_pwd;
    private String m_name;
    private int m_age;
    private String m_job;

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_pwd() {
        return m_pwd;
    }

    public void setM_pwd(String m_pwd) {
        this.m_pwd = m_pwd;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public int getM_age() {
        return m_age;
    }

    public void setM_age(int m_age) {
        this.m_age = m_age;
    }

    public String getM_job() {
        return m_job;
    }

    public void setM_job(String m_job) {
        this.m_job = m_job;
    }

    public String getM_grade() {
        return m_grade;
    }

    public void setM_grade(String m_grade) {
        this.m_grade = m_grade;
    }

    public int getM_point() {
        return m_point;
    }

    public void setM_point(int m_point) {
        this.m_point = m_point;
    }

    private String m_grade;
    private int m_point;
} // DB 테이블의 컬럼명과 동일하게 변수명 설정
