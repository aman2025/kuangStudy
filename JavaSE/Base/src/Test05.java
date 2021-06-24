//测试类什么时候会初始化
public class Test05 {
    static {
        System.out.println("Main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //1.new主动引用
        //Son son = new Son();
        // 输出
        // Main类被加载
        // 父类被加载
        // 子类被加载

        //2.反射也会产生主动引用
        //Class.forName("Son");
        // 输出
        // Main类被加载
        // 父类被加载
        // 子类被加载

        //3.不会产生类的引用的方法
        //        System.out.println(Son.b); // 调用父类的静态属性,子类不会被调用
        //        // 输出:
        //        //Main类被加载
        //        //父类被加载
        //        //2

        // 5. 创建数组
        //Son[] array = new Son[5]; // 只是名字和开辟了5个空间, 没有被加载
        // 输出:
        // Main类被加载

        // 6. 调用子类常量,不会加载父类和子类
        System.out.println(Son.M);
        // 输出:
        // Main类被加载
        //1
    }
}

class Father {
    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static
    int m = 100;
    static final int M = 1;
}

