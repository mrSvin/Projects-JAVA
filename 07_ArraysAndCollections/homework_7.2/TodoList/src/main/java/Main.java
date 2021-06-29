import java.util.ArrayList;
import java.util.List;

public class Main {
    private static TodoList todoList = new TodoList();


    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        todoList = new TodoList();

        todoList.add("do1");
        todoList.add("do2");
        todoList.add("do3");

        todoList.add(3, "dsd");
        todoList.getTodos();
    }
}
