# JobSchedulerSimulator
Simulating Job Scheduler and Performance Analysis
_____________________________________________________

This is a Java Programming project to simulate Job Scheduler of the Operating Systems.

There are four scheduling method including: 
- First-Come-First-Serve (FCFS)
- Shortest-Job-First (SJF)
- Round-Robin-2 (RR-2) Time slice - 2
- Round-Robin-5 (RR-5) Time slice - 5

To build and run the program, you need to instantiate an each scheduling object with filepath as a parameter in Main() class.
Example of instantiation:

FCFS temp = new FCFS(String filepath);

SJF temp = new SJF(String filepath);

RoundRobin = new RoundRobin(String filepath, int time-slice);

Once object are instantiated, the result will display as table with column of Job#, Start time, End time and Completion Time.

It also output the Average Turn Around Time of each scheduling method in the end.

