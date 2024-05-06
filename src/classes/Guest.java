package classes;

import java.util.List;
import java.util.Random;

public class Guest implements Runnable  {
    private final int id;
    private final List<Room> rooms;
    private final Random random;

    public Guest(int id, List<Room> rooms) {
        this.id = id;
        this.rooms = rooms;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(5000));
                Room room = null;
                synchronized (rooms) {
                    for (Room r : rooms) {
                        if (r.occupy()) {
                            room = r;
                            break;
                        }
                    }
                }
                if (room != null) {
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("| 🛌 Guest " + id + " occupied Room " + room.getNumber() + "|");
                    System.out.println("+-----------------------------------------------------------+");

                    Thread.sleep(random.nextInt(5000)); // Simulate time staying in the room
                    room.vacate();
                    if (room.isClean()) {
                        System.out.println("+-----------------------------------------------------------+");
                        System.out.println("|   Error: Room " + room.getNumber() + " was not cleaned!   |");
                        System.out.println("+-----------------------------------------------------------+");
                    }
                } else {
                    System.out.println("+-----------------------------------------------------------------------------+");
                    System.out.println("|🚶‍♂️ Guest " + id + " didn't find any available rooms and went out for a walk. |");
                    System.out.println("+-----------------------------------------------------------------------------+");
                    Thread.sleep(random.nextInt(10000)); // Simulate city walk
                }
            }
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }
}
