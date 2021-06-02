public class BreakAndContinue {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i);
//            if(i == 29){
//                System.out.println("结束.");
//                break;
//            }
//        }

        // 在while循环中
        int i = 0;
        while (i<100){
            i++;
            if(i%10==0){
                System.out.println();
                continue;
            }
            System.out.print(i);
        }
    }
}
