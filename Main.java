package com.company;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Since all operating system UNIX, window or mac work differently use need to configure the filepath of each text file
        //Uncomment below to enter your path on runtime and use that filepath as parameter for all the four scheduling algorithm
//        System.out.println("Please Input your file directory: [e.g. for MacOS: /Users/user/job1.txt" );
//        Scanner in = Scanner(System.in);
//        String filepath = in.nextLine();
//        in.close();
        //Below is the Example of implementing one of the four algorithm
//        FCFS temp = new FCFS(filepath); //one create an instance it will display all the result and table for you


//        //Part1
//        //5 Jobs
//        String filepathfor5jobs ="/Users/sophadethrithya/OneDrive - Cal Poly Pomona/Operating system/SchedulingProject/Part1-TestCase/5Job.txt" ;
//
//        System.out.println("Part 1 - 5 jobs:");
//        FCFS fcfs = new FCFS(filepathfor5jobs);
//        SJF sjf = new SJF(filepathfor5jobs);
//        //specify RRNum which is a quantum time or time slice
//        RoundRobin roundrobin2 = new RoundRobin(filepathfor5jobs,2);
//        RoundRobin roundrobin5 = new RoundRobin(filepathfor5jobs,5);

//        //Part1
//        //10 Jobs
//        String filepathfor10jobs ="/Users/sophadethrithya/OneDrive - Cal Poly Pomona/Operating system/SchedulingProject/Part1-TestCase/10Job.txt" ;
//        FCFS fcfs1 = new FCFS(filepathfor10jobs);
//        SJF sjf1 = new SJF(filepathfor10jobs);
//        //specify RRNum which is a quantum time or time slice
//        RoundRobin roundrobin21 = new RoundRobin(filepathfor10jobs,2);
//        RoundRobin roundrobin51 = new RoundRobin(filepathfor10jobs,5);

//        //Part1
//        //15 Jobs
//        String filepathfor15jobs ="/Users/sophadethrithya/OneDrive - Cal Poly Pomona/Operating system/SchedulingProject/Part1-TestCase/15Job.txt" ;
//        FCFS fcfs2 = new FCFS(filepathfor15jobs);
//        SJF sjf2 = new SJF(filepathfor15jobs);
//        //specify RRNum which is a quantum time or time slice
//        RoundRobin roundrobin22 = new RoundRobin(filepathfor15jobs,2);
//        RoundRobin roundrobin52 = new RoundRobin(filepathfor15jobs,5);


        //Part3 - performace analysis
        //FCFS experiment
        for(int j = 5; j<=15; j+=5)
        {
            float averageResult = 0;
            for (int i = 0; i< 10; i++)
            {
                FCFS fcfs = new FCFS("/Users/sophadethrithya/OneDrive - Cal Poly Pomona/Operating system/SchedulingProject/trial/Job"+String.valueOf(j)+"Trial"+String.valueOf(i+1)+".txt");
                averageResult += fcfs.result;

            }
            averageResult /=10.0;
            System.out.println("Average Result for Job of "+ j+": "+ averageResult);
        }
        //SJF experiment
        for(int j = 5; j<=15; j+=5)
        {
            float averageResult = 0;
            for (int i = 0; i< 10; i++)
            {
                SJF sjf = new SJF("/Users/sophadethrithya/OneDrive - Cal Poly Pomona/Operating system/SchedulingProject/trial/Job"+String.valueOf(j)+"Trial"+String.valueOf(i+1)+".txt");
                averageResult += sjf.result;

            }
            averageResult /=10.0;
            System.out.println("Average Result for Job of "+ j+": "+ averageResult);
        }

        //RoundRobin-2 experiment
        for(int j = 5; j<=15; j+=5)
        {
            float averageResult = 0;
            for (int i = 0; i< 10; i++)
            {
                RoundRobin rr2 = new RoundRobin("/Users/sophadethrithya/OneDrive - Cal Poly Pomona/Operating system/SchedulingProject/trial/Job"+String.valueOf(j)+"Trial"+String.valueOf(i+1)+".txt",2);
                averageResult += rr2.result;

            }
            averageResult /=10.0;
            System.out.println("Average Result for Job of "+ j+": "+ averageResult);
        }

        //RoundRobin-5 experiment
        for(int j = 5; j<=15; j+=5)
        {
            float averageResult = 0;
            for (int i = 0; i< 10; i++)
            {
                RoundRobin rr5 = new RoundRobin("/Users/sophadethrithya/OneDrive - Cal Poly Pomona/Operating system/SchedulingProject/trial/Job"+String.valueOf(j)+"Trial"+String.valueOf(i+1)+".txt",5);
                averageResult += rr5.result;

            }
            averageResult /=10.0;
            System.out.println("Average Result for Job of "+ j+": "+ averageResult);
        }

    }
}
