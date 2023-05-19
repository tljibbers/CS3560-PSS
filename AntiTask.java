public class AntiTask extends Task {
    // Inherits attributes: startTime, date, duration, name, and taskType

    // Inherits methods: startTimeCreate, dateCreate, durationCreate, nameCreate, and taskTypeCreate

    // AntiTask constructor with arguments
     /**
     * Constructor of AntiTask that include parameters defined by the user.
     * @param inputDate             The date of the task being cancelled
     * @param inputTime             The time of the task being cancelled
     * @param inputDuration         The duration of the task being cancelled
     * @param inputName             The name specified by the user
     */
    public AntiTask(int inputDate, float inputTime, float inputDuration, String inputName)
    {
        startTime = inputTime;
        date = inputDate;
        duration = inputDuration;
        name = inputName;
        taskType = "Cancellation";
    }

    // AntiTask constructor with no arguments
     /**
     * Constructor of AntiTask (Contains no parameters. All attributes will come from user input and are verified through methods)
     * inputDate                The date of the task being cancelled
     * inputTime                The time of the task being cancelled
     * inputDuration            The duration of the task being cancelled
     * inputName                The name specified by the user
     */
    public AntiTask()
    {
        System.out.println("DATE MUST MATCH THE RECURRING TASK INSTANCE:");
        this.date = dateCreate();
        System.out.println("START TIME MUST MATCH THE RECURRING TASK INSTANCE:");
        this.startTime = startTimeCreate();
        System.out.println("DURATION MUST MATCH THE RECURRING TASK INSTANCE:");
        this.duration = durationCreate();
        this.name = nameCreate();

        this.taskType = "Cancellation";
    }

}
