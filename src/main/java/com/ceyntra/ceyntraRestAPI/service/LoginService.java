package com.ceyntra.ceyntraRestAPI.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginService {
    public String doHash(String password){
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] hashedByte=messageDigest.digest();
            StringBuilder sb=new StringBuilder();
            for(byte b:hashedByte){
                sb.append(String.format("%02x",b));
            }
            return  sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}