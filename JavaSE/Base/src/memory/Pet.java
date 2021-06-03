package memory;

public class Pet {
    public String name;
    public int age;
    public void shout(){
        System.out.println("shout...");
    }
    static String size;

    public Pet() {
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
