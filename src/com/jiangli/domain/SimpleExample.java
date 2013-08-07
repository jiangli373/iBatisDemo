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
     * SqlMapClient��ʵ�����̰߳�ȫ�ģ���˽���Ҫһ��ʵ�����ɣ�����ʹ����һ����̬����ģʽ�� 
     */ 
    private static SqlMapClient sqlMapClient; 

    /** 
     * ��SqlMapClient�Ĺ����ŵ��˲��Ǻ�ע�⣬Ӧ�÷ŵ�һ������ģʽ�Ĺ������У���Ҫ��ʱ����ʱ��ȡ 
     */ 
    static { 
        try { 
        	String resource = "mybatis.xml";
            Reader reader = Resources.getResourceAsReader(resource); 
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader); 
            reader.close(); 
        } catch (IOException e) { 
            throw new RuntimeException("�ڹ���SqlMapClientʵ����ʱ�������쳣��" + e, e); 
        } 
    } 

    public static List selectAllAccounts() throws SQLException { 
        //�������е��ʻ� 
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
