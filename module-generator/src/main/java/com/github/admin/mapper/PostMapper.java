package com.github.admin.mapper;

import static com.github.admin.mapper.PostDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.github.admin.model.Post;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface PostMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    BasicColumn[] selectList = BasicColumn.columnList(id, title, text, category, authorId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.971+08:00", comments="Source Table: post")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.971+08:00", comments="Source Table: post")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.971+08:00", comments="Source Table: post")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Long.class)
    int insert(InsertStatementProvider<Post> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.972+08:00", comments="Source Table: post")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PostResult")
    Optional<Post> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.972+08:00", comments="Source Table: post")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PostResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="text", property="text", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="author_id", property="authorId", jdbcType=JdbcType.BIGINT)
    })
    List<Post> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, post, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, post, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    default int insert(Post record) {
        return MyBatis3Utils.insert(this::insert, record, post, c ->
            c.map(title).toProperty("title")
            .map(text).toProperty("text")
            .map(category).toProperty("category")
            .map(authorId).toProperty("authorId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    default int insertSelective(Post record) {
        return MyBatis3Utils.insert(this::insert, record, post, c ->
            c.map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(text).toPropertyWhenPresent("text", record::getText)
            .map(category).toPropertyWhenPresent("category", record::getCategory)
            .map(authorId).toPropertyWhenPresent("authorId", record::getAuthorId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    default Optional<Post> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, post, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    default List<Post> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, post, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    default List<Post> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, post, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    default Optional<Post> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, post, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    static UpdateDSL<UpdateModel> updateAllColumns(Post record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(title).equalTo(record::getTitle)
                .set(text).equalTo(record::getText)
                .set(category).equalTo(record::getCategory)
                .set(authorId).equalTo(record::getAuthorId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.973+08:00", comments="Source Table: post")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Post record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(title).equalToWhenPresent(record::getTitle)
                .set(text).equalToWhenPresent(record::getText)
                .set(category).equalToWhenPresent(record::getCategory)
                .set(authorId).equalToWhenPresent(record::getAuthorId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.974+08:00", comments="Source Table: post")
    default int updateByPrimaryKey(Post record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(text).equalTo(record::getText)
            .set(category).equalTo(record::getCategory)
            .set(authorId).equalTo(record::getAuthorId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.974+08:00", comments="Source Table: post")
    default int updateByPrimaryKeySelective(Post record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(text).equalToWhenPresent(record::getText)
            .set(category).equalToWhenPresent(record::getCategory)
            .set(authorId).equalToWhenPresent(record::getAuthorId)
            .where(id, isEqualTo(record::getId))
        );
    }
}