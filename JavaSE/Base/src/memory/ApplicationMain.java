package memory;

public class ApplicationMain {
    public static void main(String[] args) {
//        Pet.size = "5"; // 类名调用size
//        System.out.println(Pet.size);
//        Pet dog = new Pet();
//        dog.name = "wancai";
//        dog.age = 3;
//
//
//        System.out.println("=========================");
//        Pet cat = new Pet("xh",3);
//        System.out.println(cat.age);
//        System.out.println(cat.name);

        Person person = new Person();
        Pet cat = new Pet("ca1",5);
        person.setPet(cat);
        person.check();


    }
}
