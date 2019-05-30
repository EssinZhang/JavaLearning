package cn.zyx.bean;

import java.util.List;

public class Employee {

    private int id;
    private String name;
    private String position;
    private List<Employee> underling;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", underling=" + underling +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Employee> getUnderling() {
        return underling;
    }

    public void setUnderling(List<Employee> underling) {
        this.underling = underling;
    }
}
