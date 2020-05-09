package sample;

public class User {
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String location;
    private String gender;


    public User(){

    }
    public User(String firstName, String lastName, String password, String username, String location, String gender){
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
        this.username=username;
        this.location=location;
        this.gender=gender;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location=location;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender=gender;
    }
}
