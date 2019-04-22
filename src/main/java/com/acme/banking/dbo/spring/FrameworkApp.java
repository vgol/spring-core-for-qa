package com.acme.banking.dbo.spring;

import com.acme.banking.dbo.spring.service.ReportingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FrameworkApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-context.xml", "test-spring-context.xml"
        );

        ReportingService reportingService = context.getBean(ReportingService.class);
        System.out.println(reportingService.getUsdAmountFor(1L));
    }
}
