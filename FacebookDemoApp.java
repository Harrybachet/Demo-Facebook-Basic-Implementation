import java.util.Scanner;

public class FacebookDemoApp {
    public static void main(String[] args) {
        SocialMediaPlatform platform = new SocialMediaPlatform();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Demo Facebook!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Friend");
            System.out.println("4. Post Update");
            System.out.println("5. View Posts");
            System.out.println("6. Send Message");
            System.out.println("7. View Messages");
            System.out.println("8. Logout");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        platform.registerUser(username, password);
                        break;
                    case 2:
                        System.out.print("Enter username: ");
                        username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        password = scanner.nextLine();
                        platform.loginUser(username, password);
                        break;
                    case 3:
                        System.out.print("Enter friend's username: ");
                        String friendUsername = scanner.nextLine();
                        platform.addFriend(friendUsername);
                        break;
                    case 4:
                        System.out.print("Enter your update: ");
                        String update = scanner.nextLine();
                        platform.postUpdate(update);
                        break;
                    case 5:
                        System.out.print("Enter the username to view posts: ");
                        username = scanner.nextLine();
                        platform.viewPosts(username);
                        break;
                    case 6:
                        System.out.print("Enter friend's username: ");
                        friendUsername = scanner.nextLine();
                        System.out.print("Enter your message: ");
                        String message = scanner.nextLine();
                        platform.sendMessage(friendUsername, message);
                        break;
                    case 7:
                        System.out.print("Enter friend's username to view messages: ");
                        friendUsername = scanner.nextLine();
                        platform.viewMessages(friendUsername);
                        break;
                    case 8:
                        platform.logoutUser();
                        break;
                    case 9:
                        running = false;
                        System.out.println("Exiting Demo Facebook. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a number between 1 and 9.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
