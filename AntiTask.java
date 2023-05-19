public class AntiTask extends Task {
    // Inherits attributes: startTime, date, duration, name, and taskType

    // Inherits methods: startTimeCreate, dateCreate, durationCreate, nameCreate, and taskTypeCreate

    // Anti Task constructor with arguments
    public AntiTask(int inputDate, float inputTime, float inputDuration, String inputName)
    {
        startTime = inputTime;
        date = inputDate;
        duration = inputDuration;
        name = inputName;
        taskType = "Cancellation";
    }

    // Anti Task constructor with no arguments
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
