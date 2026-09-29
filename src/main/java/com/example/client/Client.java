package com.example.client;

import com.example.config.AppConfig;
import com.example.service.MyBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

        Runnable task= ()->{
            MyBean bean1 = context.getBean(MyBean.class);
            MyBean bean2 = context.getBean(MyBean.class);
            System.out.println(Thread.currentThread().getName()
                    + " : " + (bean1 == bean2));
        };

        Thread thread1=new Thread(task,"Thread-1");
        Thread thread2=new Thread(task,"Thread-2");
        thread1.start();
        thread2.start();
    }
}