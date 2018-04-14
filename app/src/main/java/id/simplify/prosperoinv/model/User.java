package id.simplify.prosperoinv.model;

/**
 * Created by Keenan on 14/04/2018.
 */

public class User {
    String userId;
    String username;
    String email;
    Integer roles;
    public User(String id, String s, String email, Integer roles){

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
}
