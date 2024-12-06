import java.util.ArrayList;
import java.util.Scanner;

// Base class for fitness users
class FitnessUser {
    protected String name;
    protected int age;
    protected String fitnessGoal;
    protected ArrayList<String> workouts;

    public FitnessUser(String name, int age) {
        this.name = name;
        this.age = age;
        this.workouts = new ArrayList<>();
        this.fitnessGoal = "Not set";
    }

    public void logWorkout(String workout) {
        workouts.add(workout);
    }

    public void setFitnessGoal(String goal) {
        this.fitnessGoal = goal;
    }

    public ArrayList<String> getWorkouts() {
        return workouts;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void viewProgress() {
        System.out.println("User: " + name + ", Age: " + age);
        System.out.println("Fitness Goal: " + fitnessGoal);
        System.out.println("Workouts logged: " + workouts);
    }
}

// Fitness Tracker application class
public class FitnessTrackerApp {
    private static ArrayList<FitnessUser> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Register as a new user");
            System.out.println("2. Log a workout");
            System.out.println("3. View activity progress");
            System.out.println("4. Set or update fitness goals");
            System.out.println("5. Get workout recommendations");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    logWorkout();
                    break;
                case 3:
                    viewActivityProgress();
                    break;
                case 4:
                    setFitnessGoals();
                    break;
                case 5:
                    getWorkoutRecommendations();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the application. Stay fit!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }

    private static void registerUser() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        FitnessUser user = new FitnessUser(name, age);
        users.add(user);
        System.out.println("User registered successfully!");
    }

    private static void logWorkout() {
        FitnessUser user = findUser();
        if (user != null) {
            System.out.print("Enter workout details: ");
            String workout = scanner.nextLine();
            user.logWorkout(workout);
            System.out.println("Workout logged successfully!");
        }
    }

    private static void viewActivityProgress() {
        FitnessUser user = findUser();
        if (user != null) {
            user.viewProgress();
        }
    }

    private static void setFitnessGoals() {
        FitnessUser user = findUser();
        if (user != null) {
            System.out.print("Enter your fitness goal: ");
            String goal = scanner.nextLine();
            user.setFitnessGoal(goal);
            System.out.println("Fitness goal set successfully!");
        }
    }

    private static void getWorkoutRecommendations() {
        System.out.println("General workout recommendations:");
        System.out.println("1. Cardio: Running, Cycling, Swimming");
        System.out.println("2. Strength Training: Weightlifting, Bodyweight Exercises");
        System.out.println("3. Flexibility: Yoga, Stretching");
    }

    private static FitnessUser findUser() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        for (FitnessUser user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        System.out.println("User not found.");
        return null;
    }
}
