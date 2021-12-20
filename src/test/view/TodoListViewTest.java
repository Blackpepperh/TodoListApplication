package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class TodoListViewTest {
    public static void main(String[] args) {
//        testShowTodoList();
        testAddTodoList();
//        testRemoveTodoList();
    }


    public static void testShowTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);
        todoListService.addTodoList("Todo 1");
        todoListService.addTodoList("Todo 2");
        todoListService.addTodoList("Todo 3");
        todoListService.addTodoList("Todo 4");
        todoListService.addTodoList("Todo 5");
        todoListView.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);
        todoListService.addTodoList("Todo 1");
        todoListService.addTodoList("Todo 2");
        todoListService.addTodoList("Todo 3");
        todoListService.addTodoList("Todo 4");
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");

        todoListView.addTodoList();
        todoListService.showTodoList();
        todoListView.addTodoList();
        todoListService.showTodoList();
    }

    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Todo 1");
        todoListService.addTodoList("Todo 2");
        todoListService.addTodoList("Todo 3");
        todoListService.addTodoList("Todo 4");
        todoListService.addTodoList("Todo 5");
        todoListService.showTodoList();
        todoListView.removeTodoList();
        todoListService.showTodoList();
    }

}
