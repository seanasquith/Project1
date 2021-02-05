package com.company.asquith;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userOption = -1; //Initializes to -1 because 0 is used to exit program
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


    public static String[] addTask(String[] taskList) {
        System.out.println("Enter a description of the new task.");
        Scanner input = new Scanner(System.in);
        String newTask = input.nextLine(); //Puts user input into a string called new Task
        String[] newTaskList = new String[taskList.length + 1]; //Creates newTaskList that has a length 1 greater than taskList
        for (int i = 0; i < newTaskList.length - 1; i++) { //Copy's everything from taskList into new taskList, but leaves last index blank
            newTaskList[i] = taskList[i];
        }
        newTaskList[newTaskList.length - 1] = newTask; //Adds on the new task onto the last spot in the new task list
        return newTaskList; //returns the taskList with the new task
    }

    public static String[] removeTask(String[] taskList) {
        System.out.println("Enter the index of the task to remove.");
        Scanner input = new Scanner(System.in);
        int numRemove = input.nextInt(); // Variable for the index of the task to be removed
        if (numRemove > (taskList.length - 1) || numRemove < 0) { //If the user inputs an index that is less than 0 or greater than the greatest index,
            System.out.println("Enter a valid index!"); //It will just return the unchanged task list.
            return taskList;
        } else {
            String[] newTaskList = new String[taskList.length - 1]; //Creates a new task list that is 1 less than the length of taskList
            int checkIf = 0; //Variable to check that the if statement is entered.
            for (int i = 0; i < newTaskList.length; i++) {
                if (i == numRemove || checkIf == 1) { //If i equals the index that is being removed, it will skip adding it to the program by adding
                    newTaskList[i] = taskList[i + 1]; //The index of i+1 of the taskList to the newTaskList
                    checkIf = 1; //This prevents the else from being entered after the numRemove has already been skipped.
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
            taskList[numUpdate] = updatedTask; //Sets string in taskList to a new String
            return taskList;
        }
    }

    public static void listTasks(String[] taskList) {
        for (int i = 0; i < taskList.length; i++) {
            System.out.println((i) + ". " + taskList[i]); //Outputs each task in order with the index number in front of it.
        }
    }
}