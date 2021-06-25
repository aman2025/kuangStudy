public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
//获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader(); // AppClassLoader
        System.out.println (systemClassLoader);
//获取系统类加载器的父类加载器-->力展类加载器
        ClassLoader parent = systemClassLoader.getParent(); // ExtClassLoader
        System.out.println (parent);
//获取办“展类加载器的父类加载器-->根加载器(C/c++) ,读取不到 null
        ClassLoader parent1 = parent.getParent();
        System.out.println (parent1);
        // 输出:
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        //sun.misc.Launcher$ExtClassLoader@1540e19d
        //null

        //测试当前类是哪个加载器加载的
        ClassLoader test07 = Class.forName("Test07").getClassLoader();
        System.out.println(test07); //$AppClassLoader
        //测试JDK内置的类是谁加载的
        ClassLoader rootloader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(rootloader); // null, 根加载器




    }
}
