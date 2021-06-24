import sun.rmi.runtime.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test08 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        User user1 = new User();
        Class c33 = user1.getClass();
        System.out.println(c33); // class user
        //获得Class对象
        Class c1 = Class.forName("User");

        // 创建一个User实例 newInstance
        User user = (User) c1.newInstance(); // 本质是 调用了类的无参构造器
        user.setName("清江");
        System.out.println(user.getName());

        // 通过构造器getDeclaredConstructor创建对象, 参数多少根据User中的
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)constructor.newInstance("qingjiang", 18, 3);
        System.out.println(user2);

        //通过反射获取一个方法, 通过.invoke到插入user3对象，
        // invoke :激活// (对象，"方法的值")
        User user3 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName",String.class);
        setName.invoke(user3,"qingjiang22222");
        System.out.println(user3.getName());

        // 通过反射操作属性, 用 属性.set(实例，value)
        User user5 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，private name
        // 我们需要关闭程序的安全检测，属性或 者方法的setAccessible(true)
        name.setAccessible(true);
        name.set(user5, "qingjian55555");
        System.out.println(user5.getName());


    }
}
