package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {

        System.out.println("TODO LIST");
        todoListService.showTodoList();
        System.out.println("Menu : ");
        System.out.println("1. Tambah");
        System.out.println("2. Hapus");
        System.out.println("x. Keluar");

        var input = InputUtil.input("Pilih");
        switch (input) {
            case "1" -> addTodoList();
            case "2" -> removeTodoList();
            case "x" -> System.exit(0);
            default -> {
                System.out.println("Input tidak dimengerti");
                showTodoList();
            }
        }
    }

    public void addTodoList() {

        System.out.println("Menambah Todo");
        var input = InputUtil.input("Todo (x jika batal)");
        if (!input.equals("x")) {
            todoListService.addTodoList(input);
        }

        showTodoList();

    }

    public void removeTodoList() {
        System.out.println("Menghapus Todo");
        var input = InputUtil.input("Todo (x jika batal)");
        if (!input.equals("x")) {
           todoListService.removeTodoList(Integer.parseInt(input));
        }
        showTodoList();

    }
}
