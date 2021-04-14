import com.ks.pojo.demo02.UserService;
import com.ks.pojo.demo02.UserServiceImpl;
import com.ks.pojo.demo02.UserServiceProxyImpl;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void test(){
        UserService userService = new UserServiceImpl();
        UserService userServiceProxy = new UserServiceProxyImpl();
        ((UserServiceProxyImpl) userServiceProxy).setUserService(userService);
        userServiceProxy.add();
        userServiceProxy.delete();
        userServiceProxy.query();
    }
}
