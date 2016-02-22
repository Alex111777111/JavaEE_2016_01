package edu.javacourse.spring;

import edu.javacourse.spring.bean.init.InitBean1;
import edu.javacourse.spring.bean.init.InitBean2;
import edu.javacourse.spring.bean.SpringMap;
import edu.javacourse.spring.bean.SpringTest;
import edu.javacourse.spring.bean.SpringTestConstructor;
import edu.javacourse.spring.bean.SpringTestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringExample {

    public static void main(String[] args) {
        SpringExample se = new SpringExample();
        se.demoSpring();
    }
    
    public void demoSpring() {
        // ������� �������������� ���� � �����
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        // ������� ������ �����, ������� �������� � ���� ������ �����
//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springSuit.xml"});

        // ������� ����������� ���� � �����
//        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(new String[]{"springExample.xml"});
        
        // ������ ������ ����, ������� ������ � ���������������� �����
        // ������ ����� ��������� ����� ����
        System.out.println();
        System.out.println();
        SpringTest st = context.getBean("testSpringBean", SpringTest.class);
        System.out.println(st.getNumber());
        System.out.println(st.getChild().getHello());
        System.out.println(st.getOtherChild().getHello());
        System.out.println();
        System.out.println();

        // ����� ���� � ���������� ��������� ��� ������ ����
        SpringTest stInner = context.getBean("outerbean", SpringTest.class);
        System.out.println(stInner.getNumber());
        System.out.println(stInner.getChild().getHello());
        System.out.println();
        System.out.println();
        
        // �������� ������� ����� ����������� �����
        System.out.println("===> getInstance");
        SpringTestInstance test2 = context.getBean("instanceBean1", SpringTestInstance.class);
        test2.sayHello();
        SpringTestInstance test3 = context.getBean("instanceBean2", SpringTestInstance.class);
        test3.sayHello();
        System.out.println();
        System.out.println();

        // �������� ������� � ��������� ���������� � ������������
        SpringTestConstructor test4 = context.getBean("constructorBean", SpringTestConstructor.class);
        System.out.println("===> Constructor");
        System.out.println(test4.getNumber());
        System.out.println(test4.getName());
        System.out.println(test4.getTest().getNumber());
        System.out.println(test4.getTest().getChild().getHello());
        System.out.println();
        System.out.println();

        // ������������� �������� ���� Map
        SpringMap test5 = context.getBean("testMap", SpringMap.class);
        System.out.println("===> Map");
        for (String s : test5.getAccounts().keySet()) {
            Float f = test5.getAccounts().get(s);
            System.out.println(s + ":" + f);
        }
        System.out.println();
        System.out.println();

        // ����� ����� � ������������������ � ������������ - ����� ������� ������ ������� ���������� ����
        //InitBean1 init1 = (InitBean1) context.getBean("init1");
        InitBean2 init2 = (InitBean2) context.getBean("init2");

        // ���� �������� � ���� ClassPathXmlApplicationContext ��� ������������� destroy
        ((ClassPathXmlApplicationContext)context).destroy();
        
    }
}
