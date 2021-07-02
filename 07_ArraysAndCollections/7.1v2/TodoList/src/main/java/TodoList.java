import java.util.ArrayList;

public class TodoList {

        public ArrayList<String> getArrayList() {
            return arrayList;
        }

    public ArrayList<String> arrayList = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        arrayList.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index == arrayList.size() + 1) {
            arrayList.add(todo);
        }
        if (index < arrayList.size()) {
            arrayList.add(index, todo);
        } else {
            System.out.println("индекс не существует");
        }
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (arrayList.size() > index) {
            arrayList.remove(index);
            arrayList.add(index, todo);
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (arrayList.size() > index) {
            arrayList.remove(index);
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        for (int i=0; i<arrayList.size(); i++) {
            System.out.println(i + " - " + arrayList.get(i));
        }
        return arrayList;
    }

}