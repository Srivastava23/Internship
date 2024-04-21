import java.util.*;

// Template class representing a CV template
class Template {
    private String name;
    private String format;

    public Template(String name, String format) {
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public void displayTemplate() {
        System.out.println("Template Name: " + name);
        System.out.println("Template Format: " + format);
    }
}

// CVBuilder class for building CVs/Resumes
class CVBuilder {
    private String name;
    private int age;
    private String address;
    private String email;
    private String[] education;
    private String[] experience;

    public CVBuilder(String name, int age, String address, String email, String[] education, String[] experience) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.education = education;
        this.experience = experience;
    }

    public void displayCV(Template template) {
        System.out.println("\n---------------------------------");
        System.out.println("CV / Resume (Using " + template.getName() + " template):");
        System.out.println("---------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("\nEducation:");
        for (String edu : education) {
            System.out.println("- " + edu);
        }
        System.out.println("\nExperience:");
        for (String exp : experience) {
            System.out.println("- " + exp);
        }
    }
}

// Main class
public class OnlineCVBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Gather user information
        System.out.println("Welcome to Online CV/Resume Builder!");

        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("\nEnter your educational qualifications (press enter after each):");
        String[] education = gatherInformation(scanner);
        System.out.println("\nEnter your work experience (press enter after each):");
        String[] experience = gatherInformation(scanner);

        // Create available templates
        Template[] templates = {
            new Template("Template 1", "Chronological"),
            new Template("Template 2", "Functional"),
            new Template("Template 3", "Combination"),
            new Template("Template 4", "Creative"),
            new Template("Template 5", "Professional")
        };

        // Allow user to choose templates and display CVs
        boolean exit = false;
        while (!exit) {
            // Display available templates
            System.out.println("\nAvailable Templates:");
            for (int i = 0; i < templates.length; i++) {
                System.out.println((i + 1) + ". " + templates[i].getName());
            }

            // Choose template
            System.out.print("\nEnter the number of the template you want to use (or enter 0 to exit): ");
            int templateChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (templateChoice == 0) {
                exit = true;
                continue;
            }

            if (templateChoice < 1 || templateChoice > templates.length) {
                System.out.println("Invalid template choice. Please try again.");
                continue;
            }

            // Build CV using chosen template
            CVBuilder cvBuilder = new CVBuilder(name, age, address, email, education, experience);
            cvBuilder.displayCV(templates[templateChoice - 1]);
        }

        System.out.println("\nThank you for using Online CV/Resume Builder!");
        scanner.close();
    }

    // Helper method to gather information (education or experience)
    private static String[] gatherInformation(Scanner scanner) {
        List<String> infoList = new ArrayList<>();
        System.out.println("(Press Enter to stop entering)");
        while (true) {
            System.out.print("- ");
            String info = scanner.nextLine();
            if (info.isEmpty()) {
                break;
            }
            infoList.add(info);
        }
        return infoList.toArray(new String[0]);
    }
}
