package com.example.demo.gclib.service;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {


    @Test
    void cglibTestWithFixedValue(){

        Enhancer enhancer = getEnhancer();
        enhancer.setCallback((FixedValue) () -> "proxy hello");

        PersonService proxy = (PersonService) enhancer.create();
        String helloMessage = proxy.getHelloMessage();

        assertEquals("proxy hello", helloMessage);
    }

    @Test
    void cglibTestWithMethodInterceptor(){
        Enhancer enhancer = getEnhancer();
        enhancer.setCallback((MethodInterceptor) (o, method, args, methodProxy) -> {
            if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                return "proxy Hello";
            } else {
                return methodProxy.invokeSuper(o, args);
            }
        });

        PersonService proxy = (PersonService) enhancer.create();

        assertEquals(22, proxy.getAge());
        assertEquals("proxy Hello", proxy.getByeMessage());
    }

    @Test
    void beanGenerator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();

        beanGenerator.addProperty("name", String.class);
        Object bean = beanGenerator.create();
        Method setter = bean.getClass().getMethod("setName", String.class);
        setter.invoke(bean, "some string value set by a cglib");

        Method getter = bean.getClass().getMethod("getName");
        assertEquals("some string value set by a cglib", getter.invoke(bean));

    }

    private Enhancer getEnhancer() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        return enhancer;
    }
}