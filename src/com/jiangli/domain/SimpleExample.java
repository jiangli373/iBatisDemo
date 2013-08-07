package com.jiangli.domain;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SimpleExample { 

    /** 
     * SqlMapClient的实例是线程安全的，因此仅需要一个实例即可，这里使用了一个静态单例模式。 
     */ 
    private static SqlMapClient sqlMapClient; 

    /** 
     * 将SqlMapClient的构件放到此不是好注意，应该放到一个单例模式的工具类中，需要的时候随时获取 
     */ 
    static { 
        try { 
        	String resource = "mybatis.xml";
            Reader reader = Resources.getResourceAsReader(resource); 
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader); 
            reader.close(); 
        } catch (IOException e) { 
            throw new RuntimeException("在构件SqlMapClient实例的时候发生了异常！" + e, e); 
        } 
    } 

    public static List selectAllAccounts() throws SQLException { 
        //返回所有的帐户 
        return sqlMapClient.queryForList("Account.selectAllAccounts"); 
    } 

    public static Account selectAccountById(int id) throws SQLException { 
        return (Account) sqlMapClient.queryForObject("Account.selectAccountById", id); 
    } 

    public static void insertAccount(Account account) throws SQLException { 
        sqlMapClient.insert("Account.insertAccount", account); 
    } 

    public static void updateAccount(Account account) throws SQLException { 
        sqlMapClient.update("Account.updateAccount", account); 
    } 

    public static void deleteAccount(int id) throws SQLException { 
        sqlMapClient.delete("Account.deleteAccount", id); 
    } 

    public static void main(String[] args) throws SQLException { 
//        Account act = new Account("1"); 
//        act.setId(23); 
         
//        insertAccount(act); 
    	Account listUser = new Account();
    	listUser = selectAccountById(1);
    	 System.out.println(listUser+"\n"); 
        List<Account> acclist=  selectAllAccounts(); 
        for(Account acc:acclist){ 
            System.out.println(acc); 
        } 
    } 
}
