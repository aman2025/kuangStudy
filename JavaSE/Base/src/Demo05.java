public class Demo05 {
    public static void main(String[] args) {
//        printMax(5,2,3);
        test2(2,5,6,7);
    }
    // 数组中的最大值, 可变参数
    public static void printMax(double... numbers){

        if(numbers.length == 0 ){
            System.out.println("no arguments...");
            return;
        }
        double max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        System.out.println("this max value is: " + max);
    }

    public static void test(int... i){
        System.out.println(i[1]);
    }

    // 多个参数,可变参数放在末尾
    public static void test2(int x, int... y){
        System.out.println(x);
        System.out.println(y[2]);

    }
}
