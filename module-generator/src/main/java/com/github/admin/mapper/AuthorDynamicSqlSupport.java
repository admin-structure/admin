package com.github.admin.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AuthorDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.975+08:00", comments="Source Table: author")
    public static final Author author = new Author();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.975+08:00", comments="Source field: author.id")
    public static final SqlColumn<Long> id = author.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.975+08:00", comments="Source field: author.name")
    public static final SqlColumn<String> name = author.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.975+08:00", comments="Source field: author.thumbnail")
    public static final SqlColumn<String> thumbnail = author.thumbnail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.975+08:00", comments="Source field: author.post_id")
    public static final SqlColumn<Long> postId = author.postId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.975+08:00", comments="Source Table: author")
    public static final class Author extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> thumbnail = column("thumbnail", JDBCType.VARCHAR);

        public final SqlColumn<Long> postId = column("post_id", JDBCType.BIGINT);

        public Author() {
            super("author");
        }
    }
}