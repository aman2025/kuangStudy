public class Outer {
    private static int id = 10;
    public void out(){
        System.out.println("这是外部类的方法");
        // 没有名字的初始化类
        new Apple().eat();
    }

}
class Apple{
    public void eat(){}
}
