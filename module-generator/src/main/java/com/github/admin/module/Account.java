package com.github.admin.module;

import javax.annotation.Generated;

public class Account {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.615+08:00", comments="Source field: account.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.619+08:00", comments="Source field: account.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.619+08:00", comments="Source field: account.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.619+08:00", comments="Source field: account.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.619+08:00", comments="Source field: account.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.619+08:00", comments="Source field: account.name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}