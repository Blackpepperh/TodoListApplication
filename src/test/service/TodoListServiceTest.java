package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
//       testShowTodoList();
//        testAddTodoList();
    testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListRepository.data[0] = new TodoList("Todo 1");
        todoListRepository.data[1] = new TodoList("Todo 2");
        todoListRepository.data[2] = new TodoList("Todo 3");
        todoListRepository.data[3] = new TodoList("Todo 4");


        todoListService.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Todo 1");
        todoListService.addTodoList("Todo 2");
        todoListService.addTodoList("Todo 3");
        todoListService.addTodoList("Todo 4");
        todoListService.addTodoList("Todo 5");
        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
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
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");
        todoListService.addTodoList("Todo 5");

        todoListService.removeTodoList(5);
        todoListService.showTodoList();
    }
}
