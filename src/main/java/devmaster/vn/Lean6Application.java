package devmaster.vn;

import devmaster.vn.Entity.Student;
import devmaster.vn.repository.StudentRepository;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Lean6Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Lean6Application.class, args);
        StudentRepository studentRepository = context.getBean(StudentRepository.class);
        System.out.println(studentRepository.findById(1).get().getClazz());
    }

}
