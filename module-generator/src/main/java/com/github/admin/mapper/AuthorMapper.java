package com.github.admin.mapper;

import static com.github.admin.mapper.AuthorDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.github.admin.model.Author;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
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
public interface AuthorMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, thumbnail, postId);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.975+08:00", comments="Source Table: author")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.975+08:00", comments="Source Table: author")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.975+08:00", comments="Source Table: author")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Author> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.975+08:00", comments="Source Table: author")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Author> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AuthorResult")
    Optional<Author> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AuthorResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumbnail", property="thumbnail", jdbcType=JdbcType.VARCHAR),
        @Result(column="post_id", property="postId", jdbcType=JdbcType.BIGINT)
    })
    List<Author> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, author, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, author, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    default int insert(Author record) {
        return MyBatis3Utils.insert(this::insert, record, author, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(thumbnail).toProperty("thumbnail")
            .map(postId).toProperty("postId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    default int insertMultiple(Collection<Author> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, author, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(thumbnail).toProperty("thumbnail")
            .map(postId).toProperty("postId")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    default int insertSelective(Author record) {
        return MyBatis3Utils.insert(this::insert, record, author, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(thumbnail).toPropertyWhenPresent("thumbnail", record::getThumbnail)
            .map(postId).toPropertyWhenPresent("postId", record::getPostId)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    default Optional<Author> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, author, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.976+08:00", comments="Source Table: author")
    default List<Author> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, author, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.977+08:00", comments="Source Table: author")
    default List<Author> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, author, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.977+08:00", comments="Source Table: author")
    default Optional<Author> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.977+08:00", comments="Source Table: author")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, author, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.978+08:00", comments="Source Table: author")
    static UpdateDSL<UpdateModel> updateAllColumns(Author record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(thumbnail).equalTo(record::getThumbnail)
                .set(postId).equalTo(record::getPostId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.978+08:00", comments="Source Table: author")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Author record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(thumbnail).equalToWhenPresent(record::getThumbnail)
                .set(postId).equalToWhenPresent(record::getPostId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.979+08:00", comments="Source Table: author")
    default int updateByPrimaryKey(Author record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(thumbnail).equalTo(record::getThumbnail)
            .set(postId).equalTo(record::getPostId)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-01-31T06:07:51.98+08:00", comments="Source Table: author")
    default int updateByPrimaryKeySelective(Author record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(thumbnail).equalToWhenPresent(record::getThumbnail)
            .set(postId).equalToWhenPresent(record::getPostId)
            .where(id, isEqualTo(record::getId))
        );
    }
}