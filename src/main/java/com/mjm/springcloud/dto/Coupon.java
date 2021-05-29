package com.mjm.springcloud.dto;

import java.math.BigDecimal;

public class Coupon {
    private long id;
    private String code;
    private BigDecimal discount;
    private String expDate;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getExpDate() {
        return expDate;
    }

}
