package com.jiangli.domain;

public class Account { 
    private int id; 
    private String name; 

    public Account() { 
    } 

    public Account(String name) { 
        this.name = name; 
    } 

    public int getId() { 
        return id; 
    } 

    public void setId(int id) { 
        this.id = id; 
    }
    public void setName(String name) { 
        this.name = name; 
    }
    public String getName() { 
        return name;
    }


    @Override 
    public String toString() { 
        return "Account{" + 
                "id=" + id + 
                ", name='" + name + '\'' + 
                '}'; 
    } 
}
