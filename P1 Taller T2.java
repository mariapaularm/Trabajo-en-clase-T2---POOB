import java.Util.ArrayList;

public class Board {
    private ArrayList<Fleet> fleets;

    public Board() {
        this.fleets = new ArrayList<>();
    }
}

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

public class Main {
    public static void main(String[] args) {
     
        Board board = new Board();

        Fleet fleet = new Fleet(1, board);

        Machine machine1 = new Machine(new Position(50, 80)); 
        Machine machine2 = new Machine(new Position(100, 30));

     
        fleet.addMachine(machine1);
        fleet.addMachine(machine2);

        fleet.moveNorth();

        System.out.println("Máquina 1: " + machine1.getLocation().getLatitude());
        System.out.println("Máquina 2: " + machine2.getLocation().getLatitude());
    }
}
