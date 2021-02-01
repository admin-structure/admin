package com.github.admin.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PostDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.97+08:00", comments="Source Table: post")
    public static final Post post = new Post();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.971+08:00", comments="Source field: post.id")
    public static final SqlColumn<Long> id = post.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.971+08:00", comments="Source field: post.title")
    public static final SqlColumn<String> title = post.title;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.971+08:00", comments="Source field: post.text")
    public static final SqlColumn<String> text = post.text;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.971+08:00", comments="Source field: post.category")
    public static final SqlColumn<String> category = post.category;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.971+08:00", comments="Source field: post.author_id")
    public static final SqlColumn<Long> authorId = post.authorId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.97+08:00", comments="Source Table: post")
    public static final class Post extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> text = column("text", JDBCType.VARCHAR);

        public final SqlColumn<String> category = column("category", JDBCType.VARCHAR);

        public final SqlColumn<Long> authorId = column("author_id", JDBCType.BIGINT);

        public Post() {
            super("post");
        }
    }
}