public class ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            System.out.println("多线程被执行了");
        }
    }

    public static void main(String[] args) {
        //main线程，主线程
        //创建一个线程对象
        ThreadTest threadTest = new ThreadTest();
        threadTest.start(); //调用start方法开启线程
        for (int i = 0; i <1000 ; i++) {
            System.out.println("每天都在学习java");
        }
        // 两个循环交叉出现
    }
}
