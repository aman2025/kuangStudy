public class Demo02 {
    public static void main(String[] args) {
        int a = 20;
        int b = 30;
        String c = ""+a+b;
        System.out.println(c); // "2030"

        String d = a+b+""; //
        System.out.println(d); // "50" , 先加后转成字符
    }
}
