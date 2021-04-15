package TaskTrackingProj;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskTrackingApp {

    private ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);

    public void start(){
        while(true){
            System.out.println("Type the number of the option you want.\n" +
                    "1. List tasks\n" +
                    "2. Add a task\n" +
                    "3. Complete a task\n" +
                    "4. Delete a task\n" +
                    "5. Quit\n"
            );
            int choice = scannerInt.nextInt();
            switch (choice){
                case 1:  listTasks();
                    continue;
                case 2:  addTask();
                    continue;
                case 3:  completeTask();
                    continue;
                case 4:  deleteTask();
                    continue;
                case 5:
                    System.out.println("App terminating...");
                    break;
                default:
                    System.out.println("Invalid response...");;
                    continue;

            }
        }
    }



    private void listTasks() {
        System.out.println("Tasks to do: ");
        incompleteTasksPrint();
        System.out.println("Tasks Completed: ");
        completedTasksPrint();

    }

    private void completedTasksPrint() {
        for(Task task : tasks){
            if(task.isCompleted()) {
                System.out.println(tasks.indexOf(task) + ". " + task.getTask());
            }
        }
    }

    private void incompleteTasksPrint() {
        for(Task task : tasks){
            if(!task.isCompleted()) {
                System.out.println(tasks.indexOf(task) + ". " + task.getTask());
            }
        }
    }

    private void addTask() {
        System.out.println("Type the task you would like to add.\n");
        String task = scannerString.nextLine();
        tasks.add(new Task(task));
        System.out.println("Task added...\n");
    }

    private void completeTask() {
        incompleteTasksPrint();
        System.out.println("Type the number of the task you wish to mark complete.\n");
        int task = scannerInt.nextInt();
        if(tasks.get(task) != null && !tasks.get(task).isCompleted()){
            tasks.get(task).taskCompleted();
        }else{
            System.out.println("Invalid response...");
        }
    }

    private void deleteTask() {
        listTasks();
        System.out.println("Type the number of the task you wish to delete.\n");
        int task = scannerInt.nextInt();
        if(tasks.get(task) != null){
            tasks.remove(task);
        }else{
            System.out.println("Invalid response...");
        }
    }


}
