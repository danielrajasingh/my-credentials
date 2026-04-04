package chapter6.Jukebox.src.main.java.coding.challenge.user;
 
import chapter6.Jukebox.src.main.java.coding.challenge.jukebox.Jukebox;

public class User {
    private final Jukebox jukebox;

    public User(Jukebox jukebox) {
        this.jukebox = jukebox;
    }

    public Jukebox getJukebox() {
        return jukebox;
    }        
}
