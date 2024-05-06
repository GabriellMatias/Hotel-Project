import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Importing classes
import classes.Room;
import classes.Guest;
import classes.Housekeeper;
import classes.Receptionist;

public class Main {
    public static void main(String[] args) {
        int numRooms = 10;
        int numGuests = 50;
        int numHousekeepers = 10;
        int numReceptionists = 5;

        List<Room> rooms = new ArrayList<>();
        for (int i = 1; i <= numRooms; i++) {
            rooms.add(new Room(i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(numGuests + numHousekeepers + numReceptionists);
        for (int i = 1; i <= numGuests; i++) {
            executor.submit(new Guest(i, rooms));
        }
        for (int i = 1; i <= numHousekeepers; i++) {
            executor.submit(new Housekeeper(i, rooms));
        }
        for (int i = 1; i <= numReceptionists; i++) {
            executor.submit(new Receptionist(i, rooms));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }
}
