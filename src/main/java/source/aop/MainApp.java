package source.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import source.dao.AccountDAO;
import source.dao.MembershipDAO;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);


        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        System.out.println("Here i call findAccounts()");
        List<Account> accountList = accountDAO.findAccounts(false);

        System.out.println(accountList);

        try{
            System.out.println("Here i call findAccounts(), one more");
            accountDAO.findAccounts(true);
        }catch (Exception ex){
            System.out.println("Something wrong with exception: " + ex);
        }finally {
            context.close();
        }
    }
}
