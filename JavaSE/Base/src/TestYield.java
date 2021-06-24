public class TestYield implements Runnable {
    public static void main(String[] args) {
        TestYield yield=new TestYield();
        new Thread(yield,"a").start();
        new Thread(yield,"b").start();
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }
}