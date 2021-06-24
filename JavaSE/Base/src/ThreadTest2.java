public class ThreadTest2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <200 ; i++) {
            System.out.println("多线程被执行了");
        }
    }

    public static void main(String[] args) {
        //启动线程：传入目标对象+Thread对象.start ()
        new Thread(new ThreadTest2()).start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println("每天都在学习java2222222");
        }

    }
}
