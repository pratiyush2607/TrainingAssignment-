package com.example.coupon.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {
    @Id

    private String couponCode;

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

}
