import java.util.Scanner;

public class RecurringTask extends Task{

    // Inherits attributes: startTime, date, duration, name, and taskType

    // Inherits methods: startTimeCreate, dateCreate, durationCreate, nameCreate, and typeCreate

    int startDate;
    int endDate;
    int frequency;

    /**
     * Constructor of RecurringTask (attributes will come from user input)
     * name          The name of the task
     * taskType      The type of the task: "Class", "Study", "Sleep", "Exercise", "Work", "Meal"
     * startTime     The start time of the task from 0 (midnight) to 23.75 (11:45 pm), rounded to the nearest 15 minutes
     * duration      The duration of the task from 0.25 to 23.75, rounded to the nearest 15 minutes (0.25)
     * startDate     The start date of the task in YYYYMMDD format
     * endDate       The end date of the task in YYYYMMDD format
     * frequency     1 = daily, 7 = weekly
     */
    public RecurringTask() {
        // Inherited attributes //////////////////
        this.name = nameCreate();
        this.taskType = typeCreate(); // Polymorphic method
        this.startTime = startTimeCreate();
        this.duration = durationCreate();

        // New attributes ///////////////////////
        this.frequency = frequencyCreate();
        this.startDate = startDateCreate();
        this.endDate = endDateCreate();
    }
    // Attribute Methods //////////////////////////////////////////////////
    public String typeCreate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose a recurring task type: {\"Class\", \"Study\", \"Sleep\", \"Exercise\", \"Work\", \"Meal\"}");
        String type = scanner.next();
        // Recurring task type must be from the list above
        while (!(taskType.equals("Class") || taskType.equals("Study") || taskType.equals("Sleep") || taskType.equals("Exercise")
                || taskType.equals("Work") || taskType.equals("Meal"))) {
            System.out.println("\nInvalid task type. Task type must be a String from the list above.");
            type = scanner.next();
        }
        return type;
    }

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

    public int startDateCreate() {
        System.out.println("\nSTART DATE:");
        return dateCreate();
        }

    public int endDateCreate() {
        System.out.println("\nEND DATE:");
        int endDate = dateCreate();
        // End date must be after the start date
        while (this.startDate >= endDate) {
            System.out.println("\nInvalid endDate. End date cannot be the same or earlier than start date.");
            endDate = dateCreate();
        }
        return endDate;
    }
}
