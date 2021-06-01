public class ArraryDemo {
    public static void main(String[] args) {
        int[] nums;
        nums = new int[3];
        nums[0] = 1;
        nums[1] = 3;
        nums[2] = 5;

        // 计算和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println(nums[3]);

    }
}
