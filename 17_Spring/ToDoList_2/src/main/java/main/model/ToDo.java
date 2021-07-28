package main.model;

import com.mysql.cj.jdbc.Driver;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;

@Entity
@Table(name = "todolist")
public class ToDo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dolist")
    private String dolist;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoliste() {
        return dolist;
    }

    public void setDolist(String dolist) {

        this.dolist = dolist;
    }


}
