import java.util.HashMap;
import java.util.Scanner;

class SocialMediaPlatform {
    private HashMap<String, User> users;
    private User loggedInUser;

    public SocialMediaPlatform() {
        this.users = new HashMap<>();
        this.loggedInUser = null;
    }

    public void registerUser(String username, String password) throws IllegalArgumentException {
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("Username already taken.");
        }
        users.put(username, new User(username, password));
        System.out.println("User registered successfully.");
    }

    public void loginUser(String username, String password) throws IllegalArgumentException {
        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("No such user exists.");
        }
        User user = users.get(username);
        if (!user.checkPassword(password)) {
            throw new IllegalArgumentException("Incorrect password.");
        }
        loggedInUser = user;
        System.out.println("Logged in successfully.");
    }

    public void logoutUser() {
        if (loggedInUser != null) {
            System.out.println(loggedInUser.getUsername() + " logged out.");
            loggedInUser = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public void addFriend(String friendUsername) throws IllegalStateException, IllegalArgumentException {
        if (loggedInUser == null) {
            throw new IllegalStateException("You must be logged in to add a friend.");
        }
        if (!users.containsKey(friendUsername)) {
            throw new IllegalArgumentException("No such user exists.");
        }
        loggedInUser.addFriend(friendUsername);
        System.out.println("Friend added successfully.");
    }

    public void postUpdate(String update) throws IllegalStateException {
        if (loggedInUser == null) {
            throw new IllegalStateException("You must be logged in to post an update.");
        }
        loggedInUser.postUpdate(update);
        System.out.println("Update posted successfully.");
    }

    public void viewPosts(String username) throws IllegalArgumentException {
        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("No such user exists.");
        }
        User user = users.get(username);
        System.out.println(username + "'s posts:");
        for (String post : user.getPosts()) {
            System.out.println("- " + post);
        }
    }

    public void sendMessage(String friendUsername, String message) throws IllegalStateException, IllegalArgumentException {
        if (loggedInUser == null) {
            throw new IllegalStateException("You must be logged in to send a message.");
        }
        if (!users.containsKey(friendUsername)) {
            throw new IllegalArgumentException("No such user exists.");
        }
        if (!loggedInUser.getFriends().contains(friendUsername)) {
            throw new IllegalArgumentException("You must be friends with " + friendUsername + " to send a message.");
        }
        loggedInUser.sendMessage(friendUsername, message);
        System.out.println("Message sent successfully.");
    }

    public void viewMessages(String friendUsername) throws IllegalStateException, IllegalArgumentException {
        if (loggedInUser == null) {
            throw new IllegalStateException("You must be logged in to view messages.");
        }
        if (!users.containsKey(friendUsername)) {
            throw new IllegalArgumentException("No such user exists.");
        }
        if (!loggedInUser.getFriends().contains(friendUsername)) {
            throw new IllegalArgumentException("You must be friends with " + friendUsername + " to view messages.");
        }
        System.out.println("Messages with " + friendUsername + ":");
        for (String message : loggedInUser.getMessages(friendUsername)) {
            System.out.println("- " + message);
        }
    }
}
