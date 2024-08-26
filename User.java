import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class User {
    private String username;
    private String password;
    private List<String> friends;
    private List<String> posts;
    private HashMap<String, List<String>> messages;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.messages = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public List<String> getFriends() {
        return friends;
    }

    public void addFriend(String friendUsername) {
        if (!friends.contains(friendUsername)) {
            friends.add(friendUsername);
        } else {
            System.out.println("You are already friends with " + friendUsername);
        }
    }

    public void postUpdate(String update) {
        posts.add(update);
    }

    public List<String> getPosts() {
        return posts;
    }

    public void sendMessage(String friendUsername, String message) {
        if (!messages.containsKey(friendUsername)) {
            messages.put(friendUsername, new ArrayList<>());
        }
        messages.get(friendUsername).add(message);
    }

    public List<String> getMessages(String friendUsername) {
        return messages.getOrDefault(friendUsername, new ArrayList<>());
    }
}
