
import java.rmi.RemoteException;
import java.util.ArrayList;

public class StudentDBImpl implements StudentDB {
    public ArrayList<Student> students = new ArrayList<Student>();

    @Override
    public boolean add(Student stu) throws RemoteException {
        if (stu == null)
            return false;
        return students.add(stu);
    };

    public Student queryByID(int stuID) throws RemoteException {
        boolean flag = false;
        int i;
        for (i = 0; i < students.size(); i++) {
            if (students.get(i).id == stuID) {
                flag = true;
                break;
            }
        }
        return flag ? students.get(i) : null;
    };

    public Student queryByName(String name) throws RemoteException {
        boolean flag = false;
        int i;
        for (i = 0; i < students.size(); i++) {
            if (students.get(i).name.equals(name)) {
                flag = true;
                break;
            }
        }
        return flag ? students.get(i) : null;
    };

    public boolean delete(int stuID) throws RemoteException {
        boolean flag = false;
        int i;
        for (i = 0; i < students.size(); i++) {
            if (students.get(i).id == stuID) {
                students.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    };
}
