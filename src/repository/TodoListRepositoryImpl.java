package repository;

import entity.TodoList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TodoListRepositoryImpl implements TodoListRepository {
    public TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull() {
        //check apakah model penuh
        var isFull = true;
        for (var modelItem : data) {
            if (modelItem == null) {
                //model masih ada yang null
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIsFull() {
        // jika penuh, model akan di re-size ukurannya menjadi 2x lenght
        if (isFull()) {
            var temp = data;
            data = new TodoList[data.length * 2];

           data = Arrays.copyOf(temp, data.length);
        }
    }

    @Override
    public void add(TodoList todo) {
        resizeIsFull();

        //tambahkan ke posisi array yang datanya null
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todo;
                break;
            }
        }

    }

    @Override
    public boolean remove(int number) {
        if (number - 1 >= data.length) {
            return false;
        } else {
            if (data[number - 1] == null) {
                return false;
            } else {
                for (int i = number - 1; i < data.length; i++) {
                    if (data[i] != null) {
                        data[i] = data[(i + 1)];
                    }
                }
                return true;
            }
        }
    }
}
