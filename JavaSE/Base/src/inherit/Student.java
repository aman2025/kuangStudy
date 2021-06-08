package inherit;

public class Student extends Person{
    {
        System.out.println("匿名代码块..");

    }
    static {
        System.out.println("静态代码块......");
    }

    public Student() {
        System.out.println("构造函数...");
    }

    public static void main(String[] args) {

        Student s1 = new Student();

    }

}
