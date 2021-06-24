public class A {

    private int baseSalary;
    private int hours;

    public A() {
    }

    public A(int baseSalary) {
        this(baseSalary, 0);
        System.out.println("执行了一个参数的");
    }

    public A(int baseSalary, int hours) {
        this.baseSalary = baseSalary;
        this.hours = hours;
    }

    public void setBaseSalary(int baseSalary) throws IllegalAccessException {
        if(baseSalary <= 0){
            throw new IllegalAccessException();
        }
        this.baseSalary = baseSalary;
    }

    public int getBaseSalary() {
        return baseSalary;
    }
}
