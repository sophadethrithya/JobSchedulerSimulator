package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//Since I am using priorityQueue to sort the data from the file I use Process class to store each job
class Process {
    String processorNum;
    int runningTime;

    public Process(String processorNum, int runningTime) {
        this.processorNum = processorNum;
        this.runningTime = runningTime;
    }
}

public class SJF{
    private PriorityQueue<Process>data = new PriorityQueue<>();

    //This class will display and compute for the result of Shortest Job First
    public SJF(String filepath) throws FileNotFoundException{
        try{
            this.data = getData(filepath);
            Record record = compute(this.data);
            displayResult(record);


        }
        catch (Exception e)
        {
            System.out.println("Error: " +e);
        }

    }
    //This class will get the data from the file store as Process and added to priorityQueue sorted in ascending order
    public PriorityQueue<Process> getData(String filepath) throws FileNotFoundException {
        //Sort the data in asceding order using processorComparator()
        PriorityQueue<Process> data = new PriorityQueue<>(20,new processorComparator());
        File file = new File(filepath);
        Scanner filedata = new Scanner(file);

        while(filedata.hasNextLine()){

            String data1 = filedata.nextLine().replaceAll("\\s","");

            int data2 = Integer.parseInt(filedata.nextLine().replaceAll("\\s",""));

            data.add(new Process(data1,data2));
        }
        return data;
    }

    //Record all the Start Time and End Time of each job and find the average Turn Around Time
    public Record compute(PriorityQueue<Process> data)
    {
        Record record = new Record();
        PriorityQueue<Process>temp1 = new PriorityQueue<>(data);
        record.start.add(0);
        int dataSize = data.size();
        for (int i = 0; i < dataSize;i++)
        {
            int temp = record.start.get(i)+temp1.poll().runningTime;
            record.stop.add(temp);
            if (i < dataSize-1)
                record.start.add(temp);
        }

        return record;

    }

    //Display the result
    public void displayResult(Record record)
    {
        System.out.println("Shortest Job First: ");
        System.out.println("Schedule Table:");
        System.out.println("Job#\tStart Time\tEnd Time\tJob Completion");

        for(int i = 0; i< record.start.size() ; i++)
        {
                Process temp = this.data.poll();
                System.out.println( String.valueOf(temp.processorNum) + "\t" + record.start.get(i) + "\t\t\t" + record.stop.get(i) + "\t\t\t" + String.valueOf(temp.processorNum) + " complete @" + record.stop.get(i));

        }
        float turnAroundTime = 0;
        for (int i: record.stop)
        {
            turnAroundTime+= i;
        }
        turnAroundTime /= record.start.size();
        System.out.println("\nAverage Turn Around Time:" + turnAroundTime);
        System.out.println();
    }
}
//Comparator to sort Process in ascending order
class processorComparator implements Comparator<Process> {

    @Override
    public int compare(Process o1, Process o2) {
        if(o1.runningTime < o2.runningTime)
            return -1;
        else if (o1.runningTime > o2.runningTime)
            return 1;
        return 0;
    }
}
