package com.carl;

import com.carl.service.BuyGoodService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: Carl
 * @Date: 2021/04/02/14:08
 * @Description:
 */
public class MyTest {
    @Test
    public void test10(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容其中获取service
        BuyGoodService service = (BuyGoodService) ac.getBean("buyService");

        //调用方法
        service.buy(1001, 200);
    }
}
