public class MethodReload {
    public static void main(String[] args) {
        double num = max(10.0, 20);
        System.out.println(num);
    }

    //max方法
    public static int max(int a, int b){
        int ret; // 初始化值只要在其中一个方法中定义
        if(a == b){
            System.out.println("a=b");
            return 0;
        }
        if(a > b){
            ret = a;
        }else{
            ret = b;
        }
        return ret;
    }
    // 重载max方法
    public static double max(double a, double b){

        double ret=0;
        if(a == b){
            System.out.println("a=b");
            return ret;
        }
        if(a > b){
            ret = a;
        }else{
            ret = b;
        }
        return ret;
    }
}
