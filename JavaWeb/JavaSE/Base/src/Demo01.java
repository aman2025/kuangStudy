public class Demo01 {
    public static void main(String[] args) {
        String name = "B";
        switch (name){
            case "A":
                System.out.println("a");
            case "B":
                System.out.println("b");
            case "C":
                System.out.println("c");
                break;
            default:
                System.out.println("other");
        }
    }
}
