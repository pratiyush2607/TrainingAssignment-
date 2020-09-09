package com.example.demo.client;

import com.example.demo.model.Cart;
import com.example.demo.model.Coupon;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

    @Component
    @RestController
    public class callproduct implements CommandLineRunner {
    private String url;
    @Value("${external.product.url}")
    private String externalProductUrl;
    @Value("${external.coupon.url}")
    private String externalCouponUrl;

    String[] s={"NTB","INK"};

    List<String> ss=new ArrayList<String>();

    @RequestMapping(value="/cart",method= RequestMethod.GET)
    public  Cart callproduct(){
        Long sum=0L;
        Cart cart =new Cart();
        RestTemplate restTemplate=new RestTemplate();
        ss.clear();
        cart.setProducts(ss);

        cart.setTotalPrice(0L);
        cart.setDiscountedPrice(0L);
        cart.setCouponCode(" ");

    for(String i:s){
        url=externalProductUrl+i;
        Product productb=restTemplate.getForObject(url,Product.class);
        sum+=productb.getPrice();
        ss.add(i);
    }

   //Product productb=restTemplate.getForObject(externalProductUrl,Product.class);
    //Long a=producta.getPrice();
    //Long b=productb.getPrice();
    Coupon coupon=restTemplate.getForObject(externalCouponUrl,Coupon.class);
    String Discount=coupon.getCouponCode();
    Long c=85*(sum)/100;
    cart.setProducts(ss);
    cart.setTotalPrice(sum);
    cart.setDiscountedPrice(c);
    cart.setCouponCode(Discount);

    return cart;
}


    @Override
    public void run(String... args) throws Exception {

    }
}

