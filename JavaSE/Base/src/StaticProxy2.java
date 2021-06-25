public class StaticProxy2 {

    public static void main(String[] args) {
        // 类比以下两个实现方式，说明Thread底层是代理实现
        new WeddingCompany(new You2()).happyMarry(); //  new WeddingCompany 传入真实角色对象
        new Thread(()-> System.out.println("执行线程...")).start(); // new Thread传入也是真实的线程对象
    }
}
interface Marry {
    void happyMarry();
}

// 真实角色： 你结婚
class You2 implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("真实角色实现...");
    }
}
// 代理角色： 婚庆公司
class WeddingCompany implements Marry{
    // 需要代理的真实角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("代理:after...");
    }

    private void before() {
        System.out.println("代理:before...");
    }

}