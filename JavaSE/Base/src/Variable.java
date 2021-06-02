public class Variable {
    static int age = 90;
    String name; // 实例变量, 实例属性, new Variable()
    int tall; // 没有初始化, 默认0, string 类型默认值是null

    public static void main(String[] args) {
        Variable va = new Variable();

        System.out.println(age);
    }
    public void sage(){
        System.out.println(age);
    }
}
