package com.github.cockpit.domain;

import lombok.Data;

/**
 * Create on 2017/3/7
 * @author Asin Liu
 */
@Data
public class Usr {
    private long id;
    private String account;
    private String phone;
    private String password;
}
