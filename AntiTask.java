public class AntiTask extends Task {
    // Inherits attributes: startTime, date, duration, name, and taskType

    // Inherits methods: startTimeCreate, dateCreate, durationCreate, nameCreate, and taskTypeCreate

    // Transient Task constructor with arguments
    public AntiTask(int inputDate, float inputTime, float inputDuration, String inputName)
    {
        startTime = inputTime;
        date = inputDate;
        duration = inputDuration;
        name = inputName;
        taskType = "Cancellation";
    }

    // Transient Task constructor with no arguments
    public AntiTask()
    {
        this.date = dateCreate();
        this.startTime = startTimeCreate();
        this.duration = durationCreate();
        this.name = nameCreate();

        this.taskType = "Cancellation";
    }

}
