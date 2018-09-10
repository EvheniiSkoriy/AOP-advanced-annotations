package source.dao;

import org.springframework.stereotype.Component;
import source.aop.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;


    public List<Account> findAccounts(boolean flag){

        if(flag == true){
            throw new RuntimeException("No accounts for you !");
        }

        List<Account> accounts = new ArrayList<Account>();

        Account account = new Account("John","Silver");

        Account account1 = new Account("Panda","Platinum");

        Account account2 = new Account("Tiger","Gold");

        accounts.add(account);
        accounts.add(account1);
        accounts.add(account2);

        return accounts;
    }



    public void addAccount(Account theAccount, boolean flag){

        System.out.println(getClass()+" Doing my DB work:Adding an account");
    }

    public String getName() {
        System.out.println(getClass()+" in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
