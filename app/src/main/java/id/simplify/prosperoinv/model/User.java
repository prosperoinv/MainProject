package id.simplify.prosperoinv.model;

/**
 * Created by Keenan on 14/04/2018.
 */

public class User {
    String userId;
    String username;
    String email;
    Integer roles;

    public User(){
    }
    public User(String userId, String username, String email){
        this.userId=userId;
        this.username=username;
        this.email=email;
        this.roles=roles;
    }
    public String getUserId() {
        return userId;
    }
    public String getUsername(){
        return  username;
    }
    public  String getEmail(){
        return email;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }
}
