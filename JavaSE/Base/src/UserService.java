//interface定义的关键字，接口都需要有实现类
public interface UserService {
    // 接口中的所有定义其实都是抽象的public abstract
    void add(String name) ;
    void delete(String name);
    void update(String name);
    void query(String name );
}

