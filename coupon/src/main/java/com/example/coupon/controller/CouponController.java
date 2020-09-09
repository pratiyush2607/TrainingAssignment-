package com.example.coupon.controller;


import com.example.coupon.model.Coupon;
import com.example.coupon.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CouponController {
    @Autowired
    CouponRepository repository;
    @RequestMapping(value="/coupon", method= RequestMethod.GET)
    public List<Coupon> getCoupons(){

        return repository.findAll();
    }
    @RequestMapping(value="/coupon/{id}", method= RequestMethod.GET)
    public Coupon getCoupon(@PathVariable("id") String id){
        return repository.findById(id).get();
    }
    @RequestMapping(value="/coupon", method= RequestMethod.POST)
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return repository.save(coupon);
    }

}
