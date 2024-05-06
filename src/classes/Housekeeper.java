package classes;
import java.util.List;

public class Housekeeper implements Runnable {
    private final List<Room> rooms;

    public Housekeeper(int id, List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(15000);
                synchronized (rooms) {
                    for (Room room : rooms) {
                        if (room.isOccupied() && room.isClean() && room.isKeyAtFrontDesk()) {
                            room.clean();
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }
}
