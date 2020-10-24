package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IMainClassService;
import service.impl.MainClassServiceImpl;

public class MainClass {

    public static ApplicationContext context;

    private static IMainClassService mainClassService;

    public static void main(String[] args) {
        //获取spring容器
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        mainClassService = context.getBean(new MainClassServiceImpl().getClass());
        mainClassService.main();
    }
}
