import com.test.bean.Student;
import com.test.bean.Teacher;
import com.test.config.MainConfiguartion;
import com.test.config.TestConfiguration;
import com.test.mapper.TestMapper;
import com.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguartion.class);
        TestService testService = context.getBean(TestService.class);
        testService.test();
    }
}
