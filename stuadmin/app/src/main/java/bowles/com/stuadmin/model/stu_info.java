package bowles.com.stuadmin.model;

public class stu_info {
private  String name;
private  String course_name;
private  String course_score;

    public String getCourse_score() {
        return course_score;
    }

    public void setCourse_score(String course_score) {
        this.course_score = course_score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
