package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //This is the sameple of file directory on my MacOS laptop
        String filepath1 = "/Users/sophadethrithya/OneDrive - Cal Poly Pomona/Operating system/SchedulingProject/out/job1.txt";
        String filepath2 = "/Users/sophadethrithya/OneDrive - Cal Poly Pomona/Operating system/SchedulingProject/src/com/company";
        System.out.println("Please Input your file directory" );
        Scanner filedir = new Scanner(System.in);
        String filepath = filedir.nextLine();

        //This is how you would call the class for each scheduling method
        FCFS fcfs = new FCFS(filepath1);
        SJF sjf = new SJF(filepath1);
        //specify RRNum which is a quantum time or time slice
        RoundRobin roundrobin2 = new RoundRobin(filepath1,2);
        RoundRobin roundrobin5 = new RoundRobin(filepath1,5);


        filedir.close();

    }
}
