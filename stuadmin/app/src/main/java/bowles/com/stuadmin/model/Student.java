package bowles.com.stuadmin.model;

public class Student {
private  String iD;
private String name;
private String sex;
private String age;
private  String  institution_NO;
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }



    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getInstitution_NO() {
        return institution_NO;
    }

    public void setInstitution_NO(String institution_NO) {
        this.institution_NO = institution_NO;
    }
}
