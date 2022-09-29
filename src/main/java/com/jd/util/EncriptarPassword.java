package com.jd.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {
        var password = "isa*pre11";
        System.out.println(password);
        System.out.println(encriptar(password));
    }
    public static String encriptar(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
