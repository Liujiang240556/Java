package bowles.com.stuadmin.model;

public class Course {
    private  String course_no;
    private  String course_name;
    private  String pre_course_no;
    private  String credit;

    public String getCourse_no() {
        return course_no;
    }

    public void setCourse_no(String course_no) {
        this.course_no = course_no;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getPre_course_no() {
        return pre_course_no;
    }

    public void setPre_course_no(String pre_course_no) {
        this.pre_course_no = pre_course_no;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
