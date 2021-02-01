package com.github.admin.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AccountDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.935+08:00", comments="Source Table: account")
    public static final Account account = new Account();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.936+08:00", comments="Source field: account.id")
    public static final SqlColumn<Long> id = account.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.936+08:00", comments="Source field: account.name")
    public static final SqlColumn<String> name = account.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.936+08:00", comments="Source Table: account")
    public static final class Account extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public Account() {
            super("account");
        }
    }
}