package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

//This class is to keep track of START time and END TIME using stack
 class Record2{
    Stack<Integer> start = new Stack<Integer>();
    Stack<Integer>stop = new Stack<>();

        }
public class RoundRobin {
     //RRNum is the quantum time/ time slice
    public int RRNum;
    public HashMap<String, Integer> data = new HashMap<>();

    //This class is called for RoundRobin
    public RoundRobin(String filepath, int RRNum) throws FileNotFoundException {

        try {
            this.RRNum = RRNum;
            this.data = getData(filepath);
            Record2 record = compute(this.data);
//            displayResult(record);
        }
        catch (Exception e)
        {
            System.out.println("Error: " +e);
        }
    }


    //This class is called to get the data from text file
    public HashMap<String,Integer> getData(String filepath) throws FileNotFoundException {
        HashMap<String,Integer>data = new HashMap<>();


        File file = new File(filepath);
        Scanner filedata = new Scanner(file);

        while(filedata.hasNextLine()){
            String data1 = filedata.nextLine().replaceAll("\\s","");

            int data2 = Integer.parseInt(filedata.nextLine().replaceAll("\\s",""));

            data.put(data1,data2);
        }
        return  data;
    }

    //This is the class where RoundRobin scheduling algorithm are implemented
    public Record2 compute(HashMap<String, Integer> data) {

        Record2 record = new Record2();
        //I am using Stack to keep track which END time that each processes is completed to find Average Turn Around Time
        Stack<Integer> trackCompleteTime = new Stack<>();

        //Start the time from 0
        record.start.push(0);
        /*------------------This is for printing purpose-----------------------*/
        System.out.println("Round Robin Time Slice - "+String.valueOf(this.RRNum)+":");
        System.out.println("Schedule Table:");
        System.out.println("Job#\tStart Time\tEnd Time\tJob Completion");

        /*-----------------------------------------*/
        while(true){
            //ready boolean are used to make sure to repeat the loop until all process are done
            boolean ready = true;
            for (int i = 0; i < data.size();i++)
            {
                //This if statement is for display purpose
                if(data.get("Job"+String.valueOf(i+1)) != 0)
                    System.out.print("Job"+String.valueOf(i+1)+"\t"+record.start.peek());
                // evaluate if the job is still not done or not equal to 0
                if (data.get("Job"+String.valueOf(i+1)) > 0)
                {
                    //ready is set to false to make sure that the for loop will be repeat
                    ready = false;
                    //evaluate if the job time is greater than time slice
                    if(data.get("Job"+String.valueOf(i+1))> this.RRNum ) {
                        //find the end time by get the start time add with the time slice
                        int temp =  record.start.peek() + this.RRNum;
                        record.stop.push(temp);
                        System.out.print("\t"+record.stop.peek());
                        //update the Job burst time
                        data.replace((String)("Job"+String.valueOf(i+1)),data.get("Job"+String.valueOf(i+1))-this.RRNum);
                        //set the next start the same as the current end time
                        record.start.push(temp);
                    }
                    //make sure that the jobs that are done will not be processed and continue the loop
                    else if(data.get("Job"+String.valueOf(i+1)) == 0 )
                    {
                        continue;
                    }
                    //if the Job burst time is <= time slice the job will be done in this scope
                    else
                    {
                        int temp = record.start.peek()+ data.get("Job"+String.valueOf(i+1));
                        //get the End time of this job
                        record.stop.push(temp);
                        System.out.print("\t"+record.stop.peek());
                        //update the Job complete time which mean set the job burst time to 0
                        data.replace(new String("Job"+String.valueOf(i+1)),0);
                        //keep track of all completion time of each jobs
                        trackCompleteTime.push(record.stop.peek());
                        System.out.print("\tJob"+String.valueOf(i+1)+" complete @"+record.stop.peek());
                        record.start.push(temp);

                    }
                    System.out.println();
                }
            }

            if (ready == true)
                break;

        }
        //find the average turn around time
        float turnAroundTime = 0;
        for (int i: trackCompleteTime)
        {
            turnAroundTime+= i;
        }
        turnAroundTime /= this.data.size();
        System.out.println("\nAverage Turn Around Time: " + turnAroundTime);
        System.out.println();


        return record;

    }



}
