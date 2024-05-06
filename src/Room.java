package classes;

public class Room {
    private final int number;
    private boolean occupied;
    private boolean cleaned;
    private boolean keyAtFrontDesk;

    public Room(int number) {
        this.number = number;
        this.occupied = false;
        this.cleaned = true;
        this.keyAtFrontDesk = true;
    }

    public synchronized boolean occupy() {
        if (!occupied && keyAtFrontDesk) {
            occupied = true;
            cleaned = false;
            keyAtFrontDesk = false;
            return true;
        }
        return false;
    }

    public synchronized void vacate() {
        occupied = false;
        keyAtFrontDesk = true;
        System.out.println("+------------------------------------------------------------+");
        System.out.println("|🔑 Room " + number + " vacated. Key returned to front desk. |");
        System.out.println("+------------------------------------------------------------+");
    }

    public synchronized void clean() {
        cleaned = true;
        System.out.println("+--------------------------------+");
        System.out.println("| 🧹 Room " + number + " cleaned.|");
        System.out.println("+--------------------------------+");
    }

    public int getNumber() {
        return number;
    }

    public boolean isOccupied() {
        return !occupied;
    }

    public boolean isClean() {
        return !cleaned;
    }

    public boolean isKeyAtFrontDesk() {
        return keyAtFrontDesk;
    }
}
