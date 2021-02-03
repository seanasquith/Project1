package com.company.asquith;

import java.util.*;

public class Main {
    public static String[] addTask(String[] taskList) {
        System.out.println("Enter a description of the new task.");
        Scanner input = new Scanner(System.in);
        String newTask = input.nextLine();
        String[] newTaskList = new String[taskList.length + 1];
        for (int i = 0; i < newTaskList.length - 1; i++) {
            newTaskList[i] = taskList[i];
        }
        newTaskList[newTaskList.length - 1] = newTask;
        return newTaskList;
    }

    public static String[] removeTask(String[] taskList) {
        System.out.println("Enter the index of the task to remove.");
        Scanner input = new Scanner(System.in);
        int numRemove = input.nextInt();
        if (numRemove > (taskList.length - 1) || numRemove < 0) {
            System.out.println("Enter a valid index!");
            return taskList;
        } else {
            String[] newTaskList = new String[taskList.length - 1];
            int checkElse = 0;
            for (int i = 0; i < newTaskList.length; i++) {
                if (i == numRemove || checkElse == 1) {
                    newTaskList[i] = taskList[i + 1];
                    checkElse = 1;
                } else {
                    newTaskList[i] = taskList[i];
                }
            }
            return newTaskList;
        }
    }

    public static String[] updateTask(String[] taskList) {
        System.out.println("Enter the index of the task to update.");
        Scanner input = new Scanner(System.in);
        int numUpdate = input.nextInt();
        if (numUpdate > (taskList.length - 1) || numUpdate < 0) {
            System.out.println("Enter a valid index!");
            return taskList;
        } else {
            System.out.println("Enter the new description of the task.");
            Scanner input2 = new Scanner(System.in);
            String updatedTask = input2.nextLine();
            taskList[numUpdate] = updatedTask;
            return taskList;
        }
    }

    public static void listTasks(String[] taskList) {
        for (int i = 0; i < taskList.length; i++) {
            System.out.println((i) + ". " + taskList[i]);
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userOption = -1;
        String[] taskList = {};

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
                    taskList = addTask(taskList);
                    break;
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
}