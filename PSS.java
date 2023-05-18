import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class PSS {

    public ArrayList<Task> schedule = new ArrayList<Task>();

    public static void main(String []args)
    {
        PSS userPSS = new PSS();

        int menuChoice = 1;

        // DO NOT CLOSE A SCANNER THAT USES SYSTEM.IN AS AN UNDERLYING INPUT STREAM
        // THIS WILL NOT ALLOW ANY FUTURE SCANNERS IN THE SAME PROGRAM TO USE SYSTEM.IN
        Scanner scanner = new Scanner(System.in);

        while(menuChoice != 0)
        {
            System.out.println("\nPlease select an option..." +
                                "\n0: Exit Program" +
                                "\n1: Create A Transient Task" +
                                "\n2: Create An AntiTask" +
                                "\n3: Create A Recurring Task" +
                                "\n4: Edit A Task" + 
                                "\n5: Delete A Task" +
                                "\n6: View A Task" +
                                "\n7: Create Schedule File\n");

            menuChoice = Integer.parseInt(scanner.nextLine());

            while(menuChoice < 0 ||  menuChoice > 7)
            {
                System.out.println("\nPlease make a valid selection.\n");
                menuChoice = Integer.parseInt(scanner.nextLine());
            }

            switch(menuChoice)
            {
                // End ProgramT
                case 0:
                return;

                // Create a Transient Task
                case 1:
                TransientTask TTask = new TransientTask();
                userPSS.schedule.add(TTask);
                break;

                // Create an AntiTask
                case 2:
                AntiTask aTask = new AntiTask();
                userPSS.schedule.add(aTask);
                break;

                // Create a Recurring Task
                case 3:
                RecurringTask RTask = new RecurringTask();
                userPSS.schedule.add(RTask);
                break;

                // Edit a Task
                case 4:
                System.out.println("\nPlease enter the name of the Task you would like to edit.\n : ");
                String taskToBeEdited = scanner.nextLine();

                for(Task task: userPSS.schedule)
                {
                    if (task.name.equals(taskToBeEdited))
                    {
                        userPSS.edit(task);
                        break;
                    }
                    else
                    {
                        System.out.println("\nTask not found. Please note the search is case-sensitive.");
                    }
                }
                break;

                // Delete a Task
                case 5: 
                System.out.println("\nPlease enter the name of the Task you would like to delete.\n : ");
                String taskToBeDeleted = scanner.nextLine();

                for(Task task: userPSS.schedule)
                {
                    if (task.name.equals(taskToBeDeleted))
                    {
                        userPSS.delete(task);
                        break;
                    }
                    else
                    {
                        System.out.println("\nTask not found. Please note the search is case-sesnitive.");
                    }
                }
                break;

                // View A Task
                case 6:
                System.out.println("\nPlease enter the name of the Task you would like to view.\n");
                
                String taskToBeViewed = scanner.nextLine();

                for(Task task: userPSS.schedule)
                {
                    if (task.name.equals(taskToBeViewed))
                    {
                        // Call the view method of the specific type of task
                        userPSS.view(task);
                        break;
                    }
                    else
                    {
                        System.out.println("\nTask not found. Please note the search is case-sensitive.");
                    }
                }
                break;

                //Create a Schedule File
                case 7:
                System.out.println("\nPlease enter the name of the Task you would like to add to a file. \n");

                String tasktoFile = scanner.nextLine();

                for(Task task: userPSS.schedule)
                {
                    if(task.name.equals(tasktoFile))
                    {
                        //Call the create schedule method for the task
                        userPSS.createSchedule(task);
                        break;
                    }
                    else
                    {
                        System.out.println("\nTask not found. Please note the search is case-sensitive.");
                    }
                }

            }

        }
        
    }

    public Task create()
    {
        Task task = new Task();

        task.date = task.dateCreate();
        task.startTime = task.startTimeCreate();
        task.duration = task.durationCreate();
        task.name = task.nameCreate();
        task.taskType = task.typeCreate();

        return task;
    }

    

    public void edit(Task task)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat would you like to edit from this task?" 
                            + "\n1: Date"
                            + "\n2: Start Time"
                            + "\n3: Duration"
                            + "\n4: Name"
                            + "\nPlease note you cannot change the type. If you desire a different task type, please make a new task.\n");

        int editChoice = scanner.nextInt();

        while (editChoice > 4 || editChoice < 1)
        {
            System.out.println("\nPlease enter a valid choice.\n");
            editChoice = scanner.nextInt();
        }

        switch(editChoice)
        {
            // Change Date
            case 1:
            int newDate = task.dateCreate();
            task.date = newDate;
            System.out.println("\nDate changed to: " + task.date);
            break;

            // Change Start Time
            case 2:
            float newTime = task.startTimeCreate();
            task.startTime = newTime;
            System.out.println("\nStart Time changed to: " + task.startTime);
            break;

            // Change Duration
            case 3:
            float newDuration = task.durationCreate();
            task.duration = newDuration;
            System.out.println("\nDuration changed to: " + task.duration);
            break;

            // Change Name
            case 4:
            String newName = task.nameCreate();
            task.name = newName;
            System.out.println("\nName changed to: " + task.name);
            break;
        }

    }

    // Allow a user to view a task by printing its contents
    public void view(Task task)
    {
        if (task instanceof RecurringTask) {
            System.out.println("\nTASK NAME: " + task.name);
            System.out.println("TASK TYPE: " + task.taskType);
            System.out.println("START DATE: " + ((RecurringTask) task).startDate);
            System.out.println("END DATE: " + ((RecurringTask) task).endDate);
            System.out.println("START TIME: " + task.startTime);
            System.out.println("DURATION: " + task.duration + " hours");
            System.out.println("FREQUENCY: " + ((RecurringTask) task).frequency);
    }
        else {
            System.out.println("\nTASK NAME: " + task.name);
        System.out.println("TASK TYPE: " + task.taskType);
        System.out.println("DATE: " + task.date);
        System.out.println("START TIME: " + task.startTime);
        System.out.println("DURATION: " + task.duration + " hours");
        }
    }

    public void delete(Task task)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to delete task, " + task.name + "?"
                        + "\n1: Yes"
                        + "\n2: No");

        int deleteChoice = scanner.nextInt();

        while (deleteChoice > 2 || deleteChoice < 1)
        {
            System.out.println("\nInvalid choice, please enter a valid choice number (1 or 2).\n");
            deleteChoice = scanner.nextInt();
        }
        switch(deleteChoice)
        {
            // Deleting a task
            case 1:
                System.out.println("Deleting a task...");
                schedule.remove(task);
                System.out.println("Task Deleted!");
                break;
            
            // Changed mind on deleting
            case 2: 
                System.out.println("Task deletion canceled.");
                break;
        }

    }
    
    public void createSchedule(Task task)
    {
        try {
            PrintWriter pw = new PrintWriter(new File("C:\\Users\\Jibbers\\cs3560-pss\\CS3560-PSS\\pssschedule.csv"));
            StringBuilder sb = new StringBuilder();

            if (task instanceof RecurringTask)
            {
                sb.append("TASK NAME");
                sb.append(",");
                sb.append("TASK TYPE");
                sb.append(",");
                sb.append("START DATE");
                sb.append(",");
                sb.append("END DATE");
                sb.append(",");
                sb.append("START TIME");
                sb.append(",");
                sb.append("DURATION (In Hours)");
                sb.append(",");
                sb.append("FREQUENCY");
                sb.append("\n");

                sb.append(task.name);
                sb.append(task.taskType);
                sb.append(((RecurringTask) task).startDate);
                sb.append(((RecurringTask) task).endDate);
                sb.append(task.startTime);
                sb.append(task.duration);
                sb.append(((RecurringTask) task).frequency);

                pw.write(sb.toString());
                pw.close();
            }
            else
            {
                sb.append("TASK NAME");
                sb.append(",");
                sb.append("TASK TYPE");
                sb.append(",");
                sb.append("DATE");
                sb.append(",");
                sb.append("START TIME");
                sb.append(",");
                sb.append("DURATION (In Hours)");
                sb.append("\n");

                sb.append(task.name);
                sb.append(task.taskType);
                sb.append(task.date);
                sb.append(task.startTime);
                sb.append(task.duration);

                pw.write(sb.toString());
                pw.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    //Displays the users schedule 
    public void readSchedule()
    {
        System.out.println("What is the name of the file that you want to be read?\n");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

    }
    // Checkoverlap task
    public boolean checkOverlap(Task newTask) {
        for (Task task : schedule) {
            if (task.overlaps(newTask)) {
                System.out.println("Task overlap detected: " + task.nameCreate());
                return true;
            }
        }
        return false;
    }
}
