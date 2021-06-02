public class ArrayDemo02 {
    public static void main(String[] args) {
        // 1.静态初始化, 创建+赋值
        int[] num2 = {1,2,3};
        Man[] mans = {new Man(),new Man()};
        System.out.println(mans);

        // 2.动态初始化
        int[] b = new int[10];
        b[0] = 10;
        System.out.println(b[0]);
        System.out.println(b[1]);// 没赋值前,默认值都0


    }
}
