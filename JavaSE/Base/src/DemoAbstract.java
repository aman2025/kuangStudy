import memory.Person;

public class DemoAbstract {
    public static void main(String[] args) {
        Animal a1 = new Dog(); // 父类
        a1.shout(); // 调用父类的方法
        a1.dsao(); // 错误： 父类调用了，子类的方法

        // 子对象，类型是子类
        Dog dog = new Dog();
        dog.dsao();
        dog.shout();

    }
}
