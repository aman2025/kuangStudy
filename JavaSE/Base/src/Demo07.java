public class Demo07 {
    // 递归阶乘 5的阶乘 5*4*3*2*1
    public static void main(String[] args) {
        int result = f(3);
        System.out.println(result);
    }
    public static int f(int n){
        if(n==1){
            return 1;
        }else{
            return n*f(n-1);
        }
    }
}
