import java.util.Scanner;
import java.util.ArrayList;

public class PSS {

    public ArrayList<Task> schedule = new ArrayList<Task>();

    public static void main(String []args)
    {
        PSS userPSS = new PSS();

        int menuChoice = 1;

        // DO NOT CLOSE A SCANNER THAT USES SYSTEM.IN AS AN UNDERLYING INPUT STREAM
        // THIS WILL NOT ALLOW ANY FUTURE SCANNERS IN THE SAME PROGRAM TO USE SYTEM.IN
        Scanner scanner = new Scanner(System.in);

        while(menuChoice != 0)
        {
            System.out.println("\nPlease select an option..." +
                                "\n0: Exit Program" +
                                "\n1: Create A Transient Task" +
                                "\n2: Create An AntiTask" +
                                "\n3: Create A Reoccuring Task" +
                                "\n4: Edit A Task" + 
                                "\n5: Delete A Task" +
                                "\n6: View A Task\n");

            menuChoice = Integer.parseInt(scanner.nextLine());

            while(menuChoice < 0 ||  menuChoice > 6)
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
                // Insert call to AntiTask constructor here
                break;

                // Create a Reoccuring Task
                case 3:
                // Insert call to Reoccuring Task constructor here
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
                        System.out.println("\nTask not found. Please note the search is case-sesnitive.");
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
                        userPSS.schedule.remove(task);
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
                        System.out.println("\nTask not found. Please note the search is case-sesnitive.");
                    }
                }
                break;

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
                            + "\nPlease note you cannot change the type. If you desire a differnet task type, please make a new task.\n");

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
        System.out.println("\nTASK NAME: " + task.name);
        System.out.println("TASK TYPE: " + task.taskType);
        System.out.println("DATE: " + task.date);
        System.out.println("START TIME: " + task.startTime);
        System.out.println("DURATION: " + task.duration + "hours");
    }

    public void delete(Task task)
    {
        task = null;
    }
    
}