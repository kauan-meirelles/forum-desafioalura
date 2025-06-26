package com.alura.forumhub;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteBCrypt {
    public static void main(String[] args) {
        String rawPassword = "123456";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(rawPassword);
        System.out.println("HASH: " + hash);
    }
}
