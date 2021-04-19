import com.ks.di.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTestAll {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beansAll.xml");
        Student student = (Student) context.getBean("student");

        student.show();
    }

}
