package source.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import source.aop.Account;

import java.util.List;

@Aspect
@Component
@Order(1)
public class LoggingAspect {


    //add new advice @AfterReturning
    @AfterReturning(
            pointcut = "execution(* source.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        System.out.println();
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===>>>Executing @AfterReturning method: " + method);
        System.out.println("===>>>With result: " + result);
        System.out.println();
    }

    //add new advice @AfterThrowing
    @AfterThrowing(
            pointcut = "execution(* source.dao.AccountDAO.findAccounts(..))",
            throwing = "theExp"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, Throwable theExp){
        System.out.println();
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===>>>Executing @AfterThrowing method: " + method);
        System.out.println("===>>>With exception: " + theExp);
        System.out.println();
    }

    @After("execution(* source.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        System.out.println();
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===>>>Executing @After(finally) method: " + method);
        System.out.println();
    }

    //it can handle the exceptions(add to param exception and you try/catch block with method that will be calling)
    @Around("execution(* source.service.FortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("===>>>Executing @Around method: " + method);

        long start = System.currentTimeMillis();

        Object object = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println("Duration: "+ (end - start)/1000 + " seconds");
        return object;
    }
}
