package classes;
import java.util.ArrayList;
import java.util.List;

public class Receptionist implements Runnable {
    private final int id;
    private final List<Room> rooms;
    private final List<Integer> waitingQueue;

    public Receptionist(int id, List<Room> rooms) {
        this.id = id;
        this.rooms = rooms;
        this.waitingQueue = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000); // Simulate interval time between checking for vacant rooms
                synchronized (rooms) {
                    boolean foundEmptyRoom = false;
                    for (Room room : rooms) {
                        if (room.isOccupied() && room.isKeyAtFrontDesk()) {
                            System.out.println("+-------------------------------------------------------------------------+");
                            System.out.println("| 🔑 Receptionist " + id + " found a vacant room: " + room.getNumber() + "|");
                            System.out.println("+-------------------------------------------------------------------------+");

                            foundEmptyRoom = true;
                            break;
                        }
                    }
                    if (!foundEmptyRoom) {
                        waitingQueue.add(id);
                        System.out.println("+-----------------------------------------------------------+");
                        System.out.println("| 🙇‍♂️ Receptionist " + id + " added to the waiting queue.    |");
                        System.out.println("+-----------------------------------------------------------+");
                        if (waitingQueue.size() >= 2) {
                            int complaint = waitingQueue.get(0);
                            System.out.println("+---------------------------------------------------------------+");
                            System.out.println("| 📢 Receptionist " + complaint + " lodged a complaint and left.|");
                            System.out.println("+---------------------------------------------------------------+");
                            waitingQueue.remove(0);
                        }
                    } else {
                        waitingQueue.remove(Integer.valueOf(id));
                    }
                }
            }
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }
}
