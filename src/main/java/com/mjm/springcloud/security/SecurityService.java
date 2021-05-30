package com.mjm.springcloud.security;

public interface SecurityService {
    boolean login(String userName, String password);
}
