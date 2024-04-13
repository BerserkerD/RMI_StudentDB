
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentDB extends Remote {
    boolean add(Student stu) throws RemoteException;

    Student queryByID(int stuID) throws RemoteException;

    Student queryByName(String name) throws RemoteException;

    boolean delete(int stuID) throws RemoteException;
}
