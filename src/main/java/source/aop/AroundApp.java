package source.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import source.dao.AccountDAO;
import source.dao.MembershipDAO;
import source.service.FortuneService;

import java.util.List;

public class AroundApp {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);


        FortuneService fortuneService = context.getBean("fortuneService",FortuneService.class);

        System.out.println("Main program: ");

        String data = fortuneService.getFortune();

        System.out.println("My fortune is: " + data);
    }
}
