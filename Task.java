import java.util.Scanner;

public class Task{

    public static Scanner scanner = new Scanner(System.in);
                            // Scanner to read in user input

    public float startTime; /*  A start time, rounded to the nearest 15-minutes, 
                                expressed as a floating point number of a 24 hour clock
                                Ex: 8:30 AM = 8.5 // 7:45 PM = 19.75 */

    public int date;   /* Dates are represented as integers, of the form YYYYMMDD, 
                          Ex: April 14, 2020 would be 20200414 */

    public float duration; /*   Rounded to the nearest 15 minutes, expressed as a 
                                floating point number giving the number of hours. 
                                Ex: A task that is one hour and 45 minutes would have a duration of 1.75 */

    public String name;  // User Selected Text String (Swimming, Golfing, etc)

    public String taskType;  // Transient, Antitask, or Reoccuring

   // Task constructor with arguements
    public Task(int inputDate, float inputTime, float inputDuration, String inputName, String inputType)
    {
        startTime = inputTime;
        date = inputDate;
        duration = inputDuration;
        name = inputName;
        taskType = inputType;
    }

    // Task with no arguements
    public Task()
    {}
    //checkoverlap
    public boolean overlaps(Task otherTask) {
        return (date == otherTask.dateCreate()) && 
               (startTime < otherTask.startTimeCreate() + otherTask.durationCreate()) && 
               (otherTask.startTimeCreate() < startTime + duration);
    }
    // Allow a user to view a task by printing its contents
    public void view()
    {
        System.out.println("\nTASK NAME: " + this.name);
        System.out.println("TASK TYPE: " + this.taskType);
        System.out.println("DATE: " + this.date);
        System.out.println("START TIME: " + this.startTime);
        System.out.println("DURATION: " + this.duration + "hours");
    }

    // Create a date for the task and check it is valid
    public int dateCreate()
    {

        System.out.println("\nPlease enter a date in the format YYYYMMDD" +
                           "\nEx: April 14, 2020 would be 20200414");

        // This string will allow us to perform input validation for correctly inputted year, month, and day.
        String userDate = scanner.nextLine();

        int userYear = Integer.parseInt(userDate.substring(0, 4));
        int userMonth = Integer.parseInt(userDate.substring(4, 6));
        int userDay = Integer.parseInt(userDate.substring(6, 8));

        System.out.println("\nYear: " + userYear);
        System.out.println("Month: " + userMonth);
        System.out.println("Day: " + userDay + "\n");


        // User cannot enter a year beyond 9999 or a year before 0
        while (userYear > 9999 || userYear < 0)
        {
            System.out.println("\nPlease enter a valid year. You cannot enter a Task for a year beyond 9999 or a negative date."
                            + "\nPlease enter a new valid year: ");

            userYear = Integer.parseInt(scanner.nextLine());
        }

        // User cannot enter a month that is either 0 or beyond 12
        while (userMonth > 12 || userMonth == 0)
        {
            System.out.println("\nPlease enter a valid month. You cannot enter a Task for a month beyond 12 (December) or below 1 (January)."
                            + "\nPlease enter a new valid month: ");
            userMonth = Integer.parseInt(scanner.nextLine());
        }



        // User cannot have a Task for the 31st on a month with only 30 (or less) days.
        switch(userMonth) 
        {
            case 2:
            // Day-Validation for February
                while (userDay > 28 || userDay <= 0)
                {
                    System.out.println("\nPlease enter a valid day. You cannot enter a Task for a day beyond the 28th on February."
                            + "\nNeither can you have a Task on a day that is 0 or below."
                            + "\nPlease enter a new valid day: ");
                    userDay = Integer.parseInt(scanner.nextLine());
                }
                break;
            case 5:
            case 6:
            case 9:
            case 11:
            // Day-Validation for April, June, September, and November
                while (userDay > 30 || userDay <= 0)
              {
                System.out.println("\nPlease enter a valid day. You cannot enter a Task for a day beyond the 30th on a month with 30 days."
                            + "\nNeither can you have a Task on a day that is 0 or below."
                            + "\nPlease enter a new valid day: ");
                userDay = Integer.parseInt(scanner.nextLine());
              }
              break;
            default:
              // For any other month...
              while (userDay > 31 || userDay <= 0)
              {
                System.out.println("\nPlease enter a valid day. You cannot enter a Task for a day beyond the 31st on a month with 31 days."
                            + "\nNeither can you have a Task on a day that is 0 or below."
                            + "\nPlease enter a new valid day: ");
                userDay = Integer.parseInt(scanner.nextLine());
              }
              break;
          }


          // DATE HAS PASSED CHECKS. 
          // Now we concatenate each indiviaul part in case the year, month, or date was changed.

          String yearString = Integer.toString(userYear);
          String monthString = Integer.toString(userMonth);
          String dayString = Integer.toString(userDay);

          String finishedDate = yearString + monthString + dayString;

          int returnedDate = Integer.parseInt(finishedDate);
          return returnedDate;
    }

    // Create a start time for the task and check it is valid
    public float startTimeCreate()
    {
        System.out.println("\nChoose an hour of the day for the start time of your task using 24-hour time. So between 0 - 23." + 
                            "\nEx: 8 AM = 8 // 7 PM = 19");
        String hourAsString = scanner.nextLine();
        float hour = Float.parseFloat(hourAsString);

        // Perform check for if a valid hour was input
        while(hour < 0 || hour > 23)
        {
            System.out.println("Please enter a valid hour.");
            hour = scanner.nextInt();
        }

        System.out.println("\nChoose a minute time using 15 minute intervals.");

        System.out.printf("1: %.0f:00\n2: %.0f:15\n3: %.0f:30\n4: %.0f:45\n", hour, hour, hour, hour);


        int minutesChoice = scanner.nextInt();

        // Perform check for if a valid choice was made
        while (minutesChoice < 1 || minutesChoice > 4)
        {
            System.out.println("Please enter a valid selection\n : ");
            minutesChoice = scanner.nextInt();
        }

        switch(minutesChoice)
        {
            case 1:
            // Leave x as x.0
            break;
            case 2:
            // Add .25
            hour += 0.25;
            break;
            case 3:
            // Add .50
            hour += 0.50;
            break;
            case 4:
            // Add .75
            hour += 0.75;
            break;
        }

        return hour;
    }

    // Create a duration for the task and check it is valid
    public float durationCreate()
    {
        //Scanner scanner = new Scanner(System.in);

        System.out.println("\nChoose an amount of hours for the duration of your task." + 
                            "\nEx: 8 = 8 hours");
        float hour = scanner.nextFloat();

        // Perform check for if a valid hour was input
        while(hour < 0 || hour > 23)
        {
            System.out.println("Please enter a valid hour. Task duration cannot be negative");
            hour = scanner.nextInt();
        }

        System.out.println("Choose the amount of minutes for the duruation using 15 minute intervals.");

        System.out.printf("1: %.0f:00\n2: %.0f:15\n3: %.0f:30\n4: %.0f:45\n", hour, hour, hour, hour);

        int minutesChoice = scanner.nextInt();

        // Perform check for if a valid choice was made
        while (minutesChoice < 1 || minutesChoice > 4)
        {
            System.out.println("Please enter a valid selection\n");
            minutesChoice = scanner.nextInt();
        }

        switch(minutesChoice)
        {
            case 1:
            // Leave x as x.0
            break;
            case 2:
            // Add .25
            hour += 0.25;
            break;
            case 3:
            // Add .50
            hour += 0.50;
            break;
            case 4:
            // Add .75
            hour += 0.75;
            break;
        }

        return hour;
    }

    // Create a name for the task
    public String nameCreate()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPlease enter a name for the task.");

        name = scanner.nextLine();

        return name;
    }

    // Have user select what type of task this will be.
    public String typeCreate()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPlease select which type of task this is."
        + "\n1: Transient Task"
        + "\n2: AntiTask"
        + "\n3: Reoccuring Task");

        int typeChoice = scanner.nextInt();

        while (typeChoice < 1 ||  typeChoice > 3)
        {
            System.out.println("Not a valid selection. Please input a valid choice.\n");
            typeChoice = scanner.nextInt();
        }

        String choice = null;

        switch(typeChoice)
        {
            case 1:
            choice = "Transient";
            return choice;
            
            case 2:
            choice = "AntiTask";
            return choice;

            case 3:
            choice = "Reoccuring";
            return choice;
        }

        return choice;
    }

}
