package com.xcl.xx.ssmdemo.entity;

import java.util.List;
import java.util.Map;

public class DemoThymeleafr {
    String username;
    String password;
    List<String> hobbies;
    Map<String, String> secrets;

    @Override
    public String toString() {
        return "DemoThymeleafr{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hobbies=" + hobbies +
                ", secrets=" + secrets +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getSecrets() {
        return secrets;
    }

    public void setSecrets(Map<String, String> secrets) {
        this.secrets = secrets;
    }
}
