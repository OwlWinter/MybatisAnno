package cn.mogeek.domain;

import java.sql.Timestamp;

public class Disciple implements Cloneable {

    /**
     * 姓名 主修方向 毕业院校 师兄 来源 日报 目标
     */
    private String student_name, major_subject, graduated_school,
            brother, come_from, daily_report, slogan;

    /**
     * id 为主键
     */
    private int id, qq_num, student_id;

    private Timestamp create_time, update_time;

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getMajor_subject() {
        return major_subject;
    }

    public void setMajor_subject(String major_subject) {
        this.major_subject = major_subject;
    }

    public String getGraduated_school() {
        return graduated_school;
    }

    public void setGraduated_school(String graduated_school) {
        this.graduated_school = graduated_school;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getCome_from() {
        return come_from;
    }

    public void setCome_from(String come_from) {
        this.come_from = come_from;
    }

    public String getDaily_report() {
        return daily_report;
    }

    public void setDaily_report(String daily_report) {
        this.daily_report = daily_report;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQq_num() {
        return qq_num;
    }

    public void setQq_num(int qq_num) {
        this.qq_num = qq_num;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }



    @Override
    public String toString(){
        return "id: " + id
                + ", 学号：" + student_id
                + ", 姓名: " + student_name
                + ", 学习方向: " + major_subject
                + ", 口号: " + slogan
                + ", QQ号: " + qq_num
                + ", 辅导师兄: " + brother
                + ", 户籍: " + come_from
                + ", 毕业院校: " + graduated_school
                + ", 日报链接: " + daily_report
                + ", 报名时间" + create_time
                + ", 更新时间" + update_time;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        Disciple disciple = (Disciple)super.clone();
        return disciple;
    }
}


