import java.util.Scanner;

public class TodoListApp {
    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan todolist
     */
    public static void showTodolist() {
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Membuat Aplikasi Dasar Todo List";

        showTodolist();
    }

    /**
     * Menambahkan todolist
     */
    public static void addTodoList(String todo) {
        //check apakah model penuh
        var isFull = true;
        for (String modelItem : model) {
            if (modelItem == null) {
                //model masih ada yang null
                isFull = false;
                break;
            }
        }

        // jika penuh, model akan di re-size ukurannya menjadi 2x lenght
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        //tambahkan ke posisi array yang datanya null
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            String todo = "Contoh Todo ke " + (i + 1);
            addTodoList(todo);
            showTodolist();
        }
    }

    /**
     * Menghapus todolist
     */
    public static boolean removeTodoList(int number) {
        if (number - 1 >= model.length) {
            return false;
        } else {
            if (model[number - 1] == null) {
                return false;
            } else {
                for (int i = number - 1; i < model.length; i++) {
                    if (model[i] != null) {
                        model[i] = model[(i + 1)];
                    }
                }
                return true;
            }
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Todo 1");
        addTodoList("Todo 2");
        addTodoList("Todo 3");
        addTodoList("Todo 4");
        addTodoList("Todo 5");

        var result = removeTodoList(10);
        System.out.println(result);

        result = removeTodoList(3);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodolist();
    }

    //Utility untuk input data
    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

    public static void testInput() {
        var input = input("Nama");
        System.out.println("Hi " + input);
    }

    /**
     * View Menampilkan todolist
     */
    public static void viewShowTodoList() {
        System.out.println("Todo List : ");
        showTodolist();
        System.out.println("Menu : ");
        System.out.println("1. Tambah");
        System.out.println("2. Hapus");
        System.out.println("x. Keluar");

        var input = input("Pilih");
        switch (input) {
            case "1" -> viewAddTodoList();
            case "2" -> viewRemoveTodoList();
            case "x" -> System.exit(0);
            default -> {
                System.out.println("Input tidak dimengerti");
                viewShowTodoList();
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("Todo 1");
        addTodoList("Todo 2");
        addTodoList("Todo 3");
        addTodoList("Todo 4");
        addTodoList("Todo 5");

        viewShowTodoList();
    }

    /**
     * View Menambahkan todolist
     */
    public static void viewAddTodoList() {
        System.out.println("Menambah Todo");
        var input = input("Todo (x jika batal)");
        if (!input.equals("x")) {
            addTodoList(input);
        }
        viewShowTodoList();
    }

    public static void testViewAddTodoList() {
        viewAddTodoList();
    }


    /**
     * View Menghapus todolist
     */
    public static void viewRemoveTodoList() {
        System.out.println("Menghapus Todo");
        var input = input("Todo (x jika batal)");
        if (!input.equals("x")) {
            boolean result = removeTodoList(Integer.parseInt(input));

            if (result) {
                System.out.println("Todo Berhasil Dihapus");
            } else {
                System.out.println("Todo Tidak Ada");
            }
        }
        viewShowTodoList();
    }

    public static void testViewRemoveTodoList() {
        viewRemoveTodoList();
    }


}
