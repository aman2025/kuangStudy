public class TestJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("vip插队" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程
        Thread testJoin = new Thread(new TestJoin());
        for (int i = 0; i < 330; i++) {
            System.out.println("主线程在排队！！！"+i);
            if(i==100){
                testJoin.start();
                testJoin.join();
            }
        }
    }
}
