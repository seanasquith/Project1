package com.company.asquith;

import java.util.*;


public class Project1ArrayList {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userOption = -1;
        List<String> taskList = new ArrayList<>();

        while (userOption != 0) {
            System.out.println("Please choose an option: ");
            System.out.println("(1) Add a task");
            System.out.println("(2) Remove task");
            System.out.println("(3) Update a task");
            System.out.println("(4) List all tasks");
            System.out.println("(0) Exit.");
            userOption = input.nextInt();
            switch (userOption) {
                case 0:
                    break;
                case 1:
                    taskList = addTask(taskList); //At first, the original, empty taskList is passed into the method. But the
                    break; // method returns an updated taskList, so taskList needs to be set to addTask(taskList).
                case 2:
                    taskList = removeTask(taskList);
                    break;
                case 3:
                    taskList = updateTask(taskList);
                    break;
                case 4:
                    listTasks(taskList);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }


    public static List<String> addTask(List<String> taskList) {
        System.out.println("Enter a description of the new task.");
        Scanner input = new Scanner(System.in);
        taskList.add(input.nextLine()); //Adds input onto taskList
        return taskList; //Returns updated taskList
    }

    public static List<String> removeTask(List<String> taskList) {
        System.out.println("Enter the index of the task to remove.");
        Scanner input = new Scanner(System.in);
        int removeIndex = input.nextInt();
        if (removeIndex > (taskList.size()) || removeIndex < 0) { //If the user inputs an index that is less than 0 or greater than the greatest index,
            return taskList; //It will just return the unchanged task list.
        }
        taskList.remove(removeIndex); //Removes the task of the index that the user inputted.
        return taskList;
    }

    public static List<String> updateTask(List<String> taskList) {
        System.out.println("Enter the index of the task to update.");
        Scanner input = new Scanner(System.in);
        int setIndex = input.nextInt();
        if (setIndex > (taskList.size()) || setIndex < 0) {
            return taskList;
        }
        System.out.println("Enter the new description of the task.");
        Scanner input2 = new Scanner(System.in);
        String setChange = input2.nextLine();
        taskList.set(setIndex, setChange); //Sets an index of the list to a different string
        return taskList;
    }


    public static void listTasks(List<String> taskList) {
        for (int i = 0; i < taskList.size(); i++) {
            String task = taskList.get(i); //Gets the element of the specified index(Starts at 0)
            System.out.println(i + ". " + task); //Outputs each task in order with the index number in front of it.
        }
    }
}
