import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    String description;
    String dueDate;
    boolean isComplete;

    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false;
    }
}

public class ToDoListApp {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsComplete();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
    }

    private static void displayMenu() {
        System.out.println("\n===== To-Do List Application =====");
        System.out.println("1. Add Task");
        System.out.println("2. Mark Task as Complete");
        System.out.println("3. View Tasks");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
    }

    private static void addTask() {
        System.out.println("\n===== Add Task =====");
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();

        Task newTask = new Task(title, description, dueDate);
        taskList.add(newTask);

        System.out.println("Task added successfully!");
    }

    private static void markTaskAsComplete() {
        System.out.println("\n===== Mark Task as Complete =====");
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        viewTasks();
        System.out.print("Enter the index of the task to mark as complete: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < taskList.size()) {
            Task task = taskList.get(index);
            task.isComplete = true;
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    private static void viewTasks() {
        System.out.println("\n===== View Tasks =====");
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);
                System.out.println("Task " + i + ":");
                System.out.println("Title: " + task.title);
                System.out.println("Description: " + task.description);
                System.out.println("Due Date: " + task.dueDate);
                System.out.println("Status: " + (task.isComplete ? "Complete" : "Incomplete"));
                System.out.println("----------------------------");
            }
        }
    }

    private static void removeTask() {
        System.out.println("\n===== Remove Task =====");
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        viewTasks();
        System.out.print("Enter the index of the task to remove: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task index.");
        }
    }
}
