package com.example.demo.component;

import com.example.demo.JUnitApplication;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = JUnitApplication.class)
class UserTest {

    private Language language;
    private User user;

    @Autowired
    private User userPro;


//    @Test
//    public void saysHello() {
//        assertTrue(userPro.sayHello().equals("Hello"));
//    }


    @BeforeEach
    public void setUp() {
        language = Mockito.mock(Language.class); // подготавливаем заглушку !!!
        user = new User();
        user.setLanguage(language);
    }


    @Test
    public void sum() {
        User user = new User();
        int poluchim = user.sum(2, 2);
        Assert.assertEquals(4, poluchim);
        assertTrue("2 + 3 = 5", user.sum(2, 3) == 5);
        assertTrue("7 + 3 = 10", user.sum(7, 3) == 10);

        Assert.assertFalse(user.sum(3, 2) == 10);// тут ожидаем что не работает

        Assert.assertEquals(2.2, (float) user.sum(2, 0), 0.3);
    }


    @Test
    public void sayHello() {
        /**
         * когда будет визван метод language.hello() ми вернем "Sniper" !!!!
         */
        when(language.hello()).thenReturn("Sniper");
        user.sayHello();
        verify(language, times(1)).hello();
    }

}