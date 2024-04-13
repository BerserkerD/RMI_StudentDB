
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MyRMIClient {
    static void info() {
        System.out.println("----------------------------------");
        System.out.println("--1.add--------------2.queryByID--");
        System.out.println("--3.queryByName---------4.Delete--");
        System.out.println("----Input a number for method-----");
        System.out.println("---------Input q for exit---------");
        System.out.println("----------------------------------");
    }

    public static void main(String args[]) {

        try {
            String name = "StudentDB";
            String serverIP = "127.0.0.1"; // 注册中心的IP地址
            int serverPort = 1099;// 注册中心的端口号
            // 获取注册中心引用
            Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
            StudentDB myStudentDB = (StudentDB) registry.lookup(name);
            Scanner sc = new Scanner(System.in);
            while (true) {
                info();
                String input = sc.next();
                if (input.equals("q"))
                    break;
                else if (input.equals("1")) {
                    System.out.println("Please input the student info:");
                    System.out.println("id:");
                    int sid = sc.nextInt();
                    System.out.println("name:");
                    String sname = sc.next();
                    System.out.println("gender:");
                    String sgender = sc.next();
                    System.out.println("age:");
                    int sage = sc.nextInt();
                    System.out.println("classid:");
                    int sclassid = sc.nextInt();
                    Student student = new Student(sid, sname, sgender, sage, sclassid);
                    boolean ret = myStudentDB.add(student);
                    if (ret)
                        System.out.println("Add Success");
                    else
                        System.out.println("Add failed");
                } else if (input.equals("2")) {
                    System.out.println("Please Input an ID for query:");
                    int qid = sc.nextInt();
                    Student stu = myStudentDB.queryByID(qid);
                    if (stu == null) {
                        System.out.println("There is no such a student");
                    } else {
                        System.out.println("Found a student info:");
                        System.out.println("id: " + stu.id);
                        System.out.println("name: " + stu.name);
                        System.out.println("gender: " + stu.gender);
                        System.out.println("age: " + stu.age);
                        System.out.println("classid: " + stu.classId);
                    }
                } else if (input.equals("3")) {
                    System.out.println("Please Input a Name for query:");
                    String qname = sc.next();
                    Student stu = myStudentDB.queryByName(qname);
                    if (stu == null) {
                        System.out.println("There is no such a student");
                    } else {
                        System.out.println("Found a student info:");
                        System.out.println("id: " + stu.id);
                        System.out.println("name: " + stu.name);
                        System.out.println("gender: " + stu.gender);
                        System.out.println("age: " + stu.age);
                        System.out.println("classid: " + stu.classId);
                    }
                } else if (input.equals("4")) {
                    System.out.println("Please Input an ID for delete:");
                    int did = sc.nextInt();
                    boolean ret = myStudentDB.delete(did);
                    if (ret) {
                        System.out.println("Delete Success");
                    } else {
                        System.out.println("Delete Failed");
                    }
                } else {
                    System.out.println("Input illegal!");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.err.println("??? exception:");
            e.printStackTrace();
        }
    }
}