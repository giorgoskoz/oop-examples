package org.afdemp.cb6.ex01;

public class UserUnderLoyalty extends User {
    
    private int points;
    
    public UserUnderLoyalty(String id, String name, String surname, int points) {
        super(id, name, surname);
        setPoints(points);
    }
    
    public UserUnderLoyalty(User user, int points) {
        super(user.getId(), user.getName(), user.getSurname());
        setPoints(points);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        if (points < 0) {
            throw new RuntimeException("Invalid points: " + points); 
        }
        this.points = points;
    }
    
    public float getDiscount(){
        if (points < 100) {
            return 0;
        }else if(points < 200) {
            return 0.01f;
        }else if(points < 300) {
            return 0.02f;
        }else if(points < 400) {
            return 0.03f;
        }else if(points < 500) {
            return 0.04f;
        }else if(points < 600) {
            return 0.05f;
        }else if(points < 700) {
            return 0.06f;
        }else{
            return 0.07f;
        }
    }
    //???
}
