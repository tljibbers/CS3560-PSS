public class TransientTask extends Task{

    // Inherits attributes startTime, date, duration, name, and taskType

    // Inherits methods startTimeCreate, dateCreate, durationCreate, nameCreate, and taskTypeCreate

    // Transient Task constructor with arguements
    public TransientTask(int inputDate, float inputTime, float inputDuration, String inputName)
    {
        startTime = inputTime;
        date = inputDate;
        duration = inputDuration;
        name = inputName;
        taskType = "Transient";
    }

    // Transient Task constructor with no arguements
    TransientTask()
    {
        this.date = this.dateCreate();
        this.startTime = this.startTimeCreate();
        this.duration = this.durationCreate();
        this.name = this.nameCreate();

        this.taskType = "Transient";
    }

}
