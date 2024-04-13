import java.io.Serializable;

public class Student implements Serializable {
    public int id;
    public String name;
    public String gender;
    public int age;
    public int classId;

    public Student(int sid, String sname, String sgender, int sage, int sclassid) {
        id = sid;
        name = sname;
        gender = sgender;
        age = sage;
        classId = sclassid;
    }
}
