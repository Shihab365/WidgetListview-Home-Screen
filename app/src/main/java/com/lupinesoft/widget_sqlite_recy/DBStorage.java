package com.lupinesoft.widget_sqlite_recy;

public class DBStorage {
    String name, cgpa;

    public DBStorage(String name, String cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }

    public DBStorage(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }
}
