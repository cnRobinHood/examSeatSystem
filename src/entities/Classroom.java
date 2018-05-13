package entities;

/**
 * Created by liu on 18-5-12.
 * Enjoy it.
 */
public class Classroom {
    private int roomid;
    private String imagePath;
    private int seats;

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
