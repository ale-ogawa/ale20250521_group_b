//package com.example.webapp.repository;

/**import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Account;

@Mapper
public interface AccountMapper {

    // 新規登録
    void insert(Account account);

    // 全取得
    List<Account> findAll();

    // IDで取得
    Account findById(Integer id);

    // メールアドレスで取得（ログイン用など）
    Account findByAddress(String address);
}
**/






/**import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Account;

@Mapper
public interface AccountMapper {
    void insert(Account account);
}**/
package com.example.webapp.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Account;

@Mapper
public interface AccountMapper {

    // accountsテーブルへ新規登録
    void insert(Account account);

}
