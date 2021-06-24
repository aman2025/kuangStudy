public class ThreadTest5 implements Runnable {
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // 如果当前线程是兔子，线程sleep
            if(Thread.currentThread().getName().equals("兔子")&& i%20==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 判断比赛结束,
            if(gameOver(i)){ // run方法内部，可以执行非静态方法
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
        }
    }
    private boolean gameOver(int steps){
        if(winner != null){
            return true;
        }
        if(steps >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is:"+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 创建线程，赋值名称，同时开启2个线程
        new Thread(new ThreadTest5(), "乌龟").start();
        new Thread(new ThreadTest5(), "兔子").start();
    }
}
