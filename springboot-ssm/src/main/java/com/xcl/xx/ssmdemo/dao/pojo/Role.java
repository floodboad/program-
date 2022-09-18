package com.xcl.xx.ssmdemo.dao.pojo;

import javax.persistence.Table;

@Table(name = "tb_role")
public class Role {

    private Integer id;
    private String name;
    private String tel;
    private String work;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", work='" + work + '\'' +
                '}';
    }
}
