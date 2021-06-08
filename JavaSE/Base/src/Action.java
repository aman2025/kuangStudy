//abstract 抽象类:类extends:单继承~        (接口可以多继承)
public abstract class Action {
    //约束~有人帮我们实现~
    //abstract，抽象方法，只有方法名字，没有方法的实现!
    public abstract void doSomething();
    // 可以有普通的方法
    public void test(){
        System.out.println("TEST");
    }
}

