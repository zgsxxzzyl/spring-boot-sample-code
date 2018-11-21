package com.web;

import com.domain.customer.Customer;
import com.domain.order.Order;
import com.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SampleController {

    @Autowired
    private StoreService storeService;

    @ResponseBody
    @RequestMapping(value = "/store")
    Object store() {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Customer c = new Customer();
            c.setName("test");
            c.setAge(30);
            Order o = new Order();
            o.setCode(1);
            o.setQuantity(7);
            storeService.storeWithStoreException(c, o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
