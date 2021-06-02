package memory;


public class Person {

    private Pet pet;
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * 一种： pet = new Pet() ，不是适合，不能在类中，这里传具体参数值
     */

    public void check(){
        System.out.println(pet.name);

    }
}
