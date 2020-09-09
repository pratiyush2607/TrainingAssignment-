package com.example.coupon.repository;

import com.example.coupon.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository <Coupon,String >{
}
