import java.util.Scanner;

public class RecurringTask extends Task{

    // Inherits attributes: startTime, date, duration, name, and taskType

    // Inherits methods: startTimeCreate, dateCreate, durationCreate, nameCreate, and typeCreate

    int startDate;
    int endDate;
    int frequency;

    /**
     * Constructor of RecurringTask that include parameters defined by the user.
     * name          The name of the task
     * taskType      The type of the task: "Class", "Study", "Sleep", "Exercise", "Work", "Meal"
     * startTime     The start time of the task from 0 (midnight) to 23.75 (11:45 pm), rounded to the nearest 15 minutes
     * duration      The duration of the task from 0.25 to 23.75, rounded to the nearest 15 minutes (0.25)
     * startDate     The start date of the task in YYYYMMDD format
     * endDate       The end date of the task in YYYYMMDD format
     * frequency     1 = daily, 7 = weekly
     */
    public RecurringTask(int startDate, int endDate, float startTime, float duration, String name, String taskType, int frequency) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.duration = duration;
        this.name = name;
        this.taskType = taskType;
        this.frequency = frequency;
    }
    /**
     * Constructor of RecurringTask (Contains no parameters. All attributes will come from user input and are verified through methods)
     * name          The name of the task
     * taskType      The type of the task: "Class", "Study", "Sleep", "Exercise", "Work", "Meal"
     * startTime     The start time of the task from 0 (midnight) to 23.75 (11:45 pm), rounded to the nearest 15 minutes
     * duration      The duration of the task from 0.25 to 23.75, rounded to the nearest 15 minutes (0.25)
     * startDate     The start date of the task in YYYYMMDD format
     * endDate       The end date of the task in YYYYMMDD format
     * frequency     1 = daily, 7 = weekly
     */
    public RecurringTask() {
        this.startDate = startDateCreate();
        this.endDate = endDateCreate();
        this.name = nameCreate();
        this.taskType = typeCreate();
        this.startTime = startTimeCreate();
        this.duration = durationCreate();
        this.frequency = frequencyCreate();
    }

    // Attribute Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Gets the type from user input and verifies that it is a recurring type
     * @return userInput        The userInput is a recurring type that is a String
     */
    public String typeCreate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose a recurring task type: {\"Class\", \"Study\", \"Sleep\", \"Exercise\", \"Work\", \"Meal\"}");
        String userInput;
        String[] typeList = {"Class", "Study", "Sleep", "Exercise", "Work", "Meal"};
        boolean isValid = false;
        while (true) {
            System.out.println("Enter type: ");
            userInput = scanner.nextLine();
            
            for (String type : typeList) {
                if (userInput.equals(type)) {
                    isValid = true;
                }
            }

            if (isValid) {
                System.out.println("Selected type: " + userInput);
                break;
            } else {
                System.out.println("Invalid type. Try again.");
            }
        }
        return userInput;
    }
    /**
     * Gets the frequency from user input and verifies that it is 1 or 7
     * @return freq        The freq is an int that is exclusively 1 (daily) or 7 (weekly)
     */
    public int frequencyCreate() {
        System.out.println("\nPlease enter the frequency of the recurring task: 1 (daily), 7 (weekly)");
        int freq = scanner.nextInt();
        // Frequency must be 1 or 7
        while (!(freq == 1 || freq == 7)) {
            System.out.println("\nInvalid frequency. Frequency must be 1 or 7.");
            freq = scanner.nextInt();
        }
        return freq;
    }

    /**
     * Gets the start date from user input
     * @return startDate    The startDate is an int of the form YYYYMMDD that is the start date of the recurring task
     */
    public int startDateCreate() {
        System.out.println("\nSTART DATE:");
        int startDate;
        startDate = dateCreate();

        return startDate;
        }

    /**
     * Gets the end date from user input and verifies that it is after the start date
     * @return endDate      The endDate is an int of the form YYYYMMDD that is the end date of the recurring task
     */
    public int endDateCreate() {
        System.out.println("\nEND DATE:");
        int endDate = dateCreate();
        // End date must be after the start date
        while (this.startDate >= endDate) {
            System.out.println("\nInvalid endDate. End date cannot be the same or earlier than start date.");
            System.out.println("END DATE: ");
            endDate = dateCreate();
        }
        return endDate;
    }


}
