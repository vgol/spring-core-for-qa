package com.acme.banking.dbo.spring;

import com.acme.banking.dbo.spring.dao.AccountRepository;
import com.acme.banking.dbo.spring.domain.SavingAccount;
import com.acme.banking.dbo.spring.service.ReportingService;
import com.acme.banking.dbo.spring.service.TransferService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "test,prod"); //-Dspring.profiles.active="test,prod"
        /** ApplicationContext vs BeanFactory: https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#context-introduction-ctx-vs-beanfactory */
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-spring-context.xml", "spring-context.xml")) {

            AccountRepository accountRepository = context.getBean("accountRepository", AccountRepository.class);
            accountRepository.saveAndFlush(new SavingAccount(0, "correct@mail.ru"));

            ReportingService reportingService = (ReportingService) context.getBean("reportingService");
            System.out.println(">>>>> " + reportingService.accountReport(1L));
            System.out.println(">>>>> " + reportingService.accountReport(2L));

            context.getBean(TransferService.class).transfer(1L, 2L, 100);
            System.out.println(">>>>> " + reportingService.accountReport(1L));
            System.out.println(">>>>> " + reportingService.accountReport(2L));
            //Move to spring-context and Show Diagram...
        }
    }
}
