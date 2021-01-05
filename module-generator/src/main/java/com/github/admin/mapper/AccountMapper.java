package com.github.admin.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

import com.github.admin.module.Account;
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
public interface AccountMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.635+08:00", comments="Source Table: account")
    BasicColumn[] selectList = BasicColumn.columnList(AccountDynamicSqlSupport.id, AccountDynamicSqlSupport.name);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.625+08:00", comments="Source Table: account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.626+08:00", comments="Source Table: account")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.626+08:00", comments="Source Table: account")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Account> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.627+08:00", comments="Source Table: account")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Account> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.628+08:00", comments="Source Table: account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AccountResult")
    Optional<Account> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.628+08:00", comments="Source Table: account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AccountResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Account> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.63+08:00", comments="Source Table: account")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.63+08:00", comments="Source Table: account")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, AccountDynamicSqlSupport.account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.631+08:00", comments="Source Table: account")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, AccountDynamicSqlSupport.account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.632+08:00", comments="Source Table: account")
    default int insert(Account record) {
        return MyBatis3Utils.insert(this::insert, record, AccountDynamicSqlSupport.account, c ->
            c.map(AccountDynamicSqlSupport.id).toProperty("id")
            .map(AccountDynamicSqlSupport.name).toProperty("name")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.633+08:00", comments="Source Table: account")
    default int insertMultiple(Collection<Account> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, AccountDynamicSqlSupport.account, c ->
            c.map(AccountDynamicSqlSupport.id).toProperty("id")
            .map(AccountDynamicSqlSupport.name).toProperty("name")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.633+08:00", comments="Source Table: account")
    default int insertSelective(Account record) {
        return MyBatis3Utils.insert(this::insert, record, AccountDynamicSqlSupport.account, c ->
            c.map(AccountDynamicSqlSupport.id).toPropertyWhenPresent("id", record::getId)
            .map(AccountDynamicSqlSupport.name).toPropertyWhenPresent("name", record::getName)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.636+08:00", comments="Source Table: account")
    default Optional<Account> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, AccountDynamicSqlSupport.account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.637+08:00", comments="Source Table: account")
    default List<Account> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, AccountDynamicSqlSupport.account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.637+08:00", comments="Source Table: account")
    default List<Account> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, AccountDynamicSqlSupport.account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.638+08:00", comments="Source Table: account")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, AccountDynamicSqlSupport.account, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.639+08:00", comments="Source Table: account")
    static UpdateDSL<UpdateModel> updateAllColumns(Account record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(AccountDynamicSqlSupport.id).equalTo(record::getId)
                .set(AccountDynamicSqlSupport.name).equalTo(record::getName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-31T16:20:33.639+08:00", comments="Source Table: account")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Account record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(AccountDynamicSqlSupport.id).equalToWhenPresent(record::getId)
                .set(AccountDynamicSqlSupport.name).equalToWhenPresent(record::getName);
    }
}