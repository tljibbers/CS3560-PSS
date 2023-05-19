import java.util.Scanner;

public class TransientTask extends Task{

    // Inherits attributes startTime, date, duration, name, and taskType

    // Inherits methods startTimeCreate, dateCreate, durationCreate, nameCreate, and taskTypeCreate

    // Transient Task constructor with arguements
    public TransientTask(int inputDate, float inputTime, float inputDuration, String inputName, String type)
    {
        startTime = inputTime;
        date = inputDate;
        duration = inputDuration;
        name = inputName;
        taskType = type;
    }

    // Transient Task constructor with no arguements
    TransientTask()
    {
        this.date = this.dateCreate();
        this.startTime = this.startTimeCreate();
        this.duration = this.durationCreate();
        this.name = this.nameCreate();

        this.taskType = typeCreate();
    }
    // Attribute Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String typeCreate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose a recurring task type: {\"Visit\", \"Shopping\", \"Appointment\"}");
        String userInput;
        String[] typeList = {"Visit", "Shopping", "Appointment"};
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

}
