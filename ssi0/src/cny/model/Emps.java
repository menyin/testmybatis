
package cny.model;

import java.io.Serializable;

public class Emps implements Serializable{
    private String id;
    private String name;
    private  Double sal;

    public Emps(){}
    public Emps(String id, String name, Double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

}

