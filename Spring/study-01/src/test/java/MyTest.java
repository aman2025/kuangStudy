import com.ks.base.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");

        userService.getUser();
    }

}
