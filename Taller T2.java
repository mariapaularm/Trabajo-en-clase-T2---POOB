import java.util.ArrayList;
import java.awt*;

public class Fleet {
    private int name;
    private ArrayList<Machine> machines;
    private ArrayList<Sailor> sailors;
    private Board board;

    public Fleet(int name, Board board) {
        this.name = name;
        this.machines = new ArrayList<>();
        this.sailors = new ArrayList<>();
        this.board = board;
    }

    public void moveNorth() {
        for (Machine machine : machines) {
            Position position = machine.getLocation();
            int newLatitude = position.getLatitude() + 1;
            position.setLatitude(newLatitude);
        }
    }

    public ArrayList<Machine> willBeDestroyed(int longitude, int latitude) {
        ArrayList<Machine> destroyedMachines = new ArrayList<>();

        for (Machine machine : machines) {
            Position position = machine.getLocation();

           
            if (position.getLongitude() == longitude && position.getLatitude() == latitude) {
             
                if (machine instanceof Plane) {
                    Plane plane = (Plane) machine;
                    if (!plane.isInAir()) {
                        destroyedMachines.add(machine);
                    }
                } else {
                    destroyedMachines.add(machine);
                }
            }
        }

        return destroyedMachines;
    }

    public void addMachine(Machine machine) {
        machines.add(machine);
    }
}


    public void addMachine(Machine machine) {
        machines.add(machine);
    }
}

public class Machine {
    private Position location;

    public Machine(Position location) {
        this.location = location;
    }

    public Position getLocation() {
        return location;
    }
}

public class Position {
    private int longitude;
    private int latitude;

    public Position(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
}

