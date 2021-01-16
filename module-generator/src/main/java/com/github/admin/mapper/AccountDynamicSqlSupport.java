package com.github.admin.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AccountDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-16T11:53:10.943+08:00", comments="Source Table: account")
    public static final Account account = new Account();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-16T11:53:10.944+08:00", comments="Source field: account.id")
    public static final SqlColumn<Integer> id = account.id;

    /**
     * Database Column Remarks:
     *   登录名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-16T11:53:10.944+08:00", comments="Source field: account.name")
    public static final SqlColumn<String> name = account.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-16T11:53:10.944+08:00", comments="Source Table: account")
    public static final class Account extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public Account() {
            super("account");
        }
    }
}