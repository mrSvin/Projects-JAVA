package main.model;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class ToDo {
    ArrayList<String> todo = new ArrayList<>();
    Connection con;
    ResultSet rs;
    private String content;

    private String contentUpdate;
    private String numberUpdate;

    private String numberDelete;


    private void sqlRequest(String request, int execute) throws SQLException {
        DriverManager.registerDriver(new Driver());
        String mysqlUrl = "jdbc:mysql://localhost/todolist?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Moscow";
        con = DriverManager.getConnection(mysqlUrl, "root", "admin");
        Statement stmt = con.createStatement();
        String sql = request;
        if (execute == 1) {
            rs = stmt.executeQuery(sql);
        }
        if (execute == 2) {
            stmt.executeUpdate(sql);
        }
    }

    //Получаем список дел
    public ArrayList<String> getTodo() throws SQLException {
        sqlRequest("SELECT dolist FROM todolist.todolist", 1);

        todo = new ArrayList<>();
        for (int i = 1; rs.next(); i++) {
            todo.add(i + ". " + rs.getString("dolist"));
        }
        System.out.println(todo);
        con.close();

        return todo;
    }

    //Добавляем дело
    private void addTodo(String content) throws SQLException {
        int lastValue = getTodo().size() + 1;
        //System.out.println("Размер " + lastValue);
        sqlRequest("INSERT INTO `todolist`.`todolist` (`dolist`, `id`) VALUES ('" + content +
                "','" + lastValue + "')", 2);
    }

    //Обновляем дело
    private void updateTodo(String contentUpdate, String number) throws SQLException {
        int lastValue = getTodo().size() + 1;
        sqlRequest("UPDATE `todolist`.`todolist` SET `dolist` = '" + contentUpdate +
                "' WHERE (`id` = '" + number + "');", 2);
    }

    //Удалям дело
    private void deleteTodo(String number) throws SQLException {
        int lastValue = getTodo().size() + 1;
        sqlRequest("DELETE FROM `todolist`.`todolist` WHERE (`id` = '" + number + "');", 2);

        for (int i = Integer.parseInt(number) + 1; i < lastValue; i++) {
            int numberUpdate = i - 1;
            System.out.println("UPDATE `todolist`.`todolist` SET `id` = '" + numberUpdate +
                    "' WHERE (`id` = '" + i + "');");
            sqlRequest("UPDATE `todolist`.`todolist` SET `id` = '" + numberUpdate +
                    "' WHERE (`id` = '" + i + "');", 2);
        }

    }

    //Удаляем все дела
    public void deleteAllTodo() throws SQLException {
        int lastValue = getTodo().size() + 1;
        for (int i = 1; i < lastValue; i++) {
            sqlRequest("DELETE FROM `todolist`.`todolist` WHERE (`id` = '" + i + "');", 2);
        }
    }

    public void setContent(String content) throws SQLException {
        System.out.println("Добавлено дело: " + content);
        //this.content = content;
        addTodo(content);
    }

    public String getContent() {
        return content;
    }


    public String getContentUpdate() {
        return contentUpdate;
    }

    public void setContentUpdate(String contentUpdate) {
        this.contentUpdate = contentUpdate;
    }

    public String getNumberUpdate() {
        return numberUpdate;
    }

    public void setNumberUpdate(String numberUpdate) throws SQLException {

        this.numberUpdate = numberUpdate;
        System.out.println("Обновлено дело: " + numberUpdate + " " + contentUpdate);
        updateTodo(contentUpdate, numberUpdate);
    }

    public String getNumberDelete() {
        return numberDelete;
    }

    public void setNumberDelete(String numberDelete) throws SQLException {
        this.numberDelete = numberDelete;
        System.out.println("Удалено дело: " + numberDelete);
        deleteTodo(numberDelete);
    }

}
