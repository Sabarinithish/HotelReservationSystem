import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String category;
    private boolean isBooked;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom() {
        isBooked = true;
    }

    public void releaseRoom() {
        isBooked = false;
    }
}

public class HotelReservationSystem {

    private ArrayList<Room> rooms;

    public HotelReservationSystem() {
        rooms = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Single"));
        rooms.add(new Room(201, "Double"));
        rooms.add(new Room(202, "Double"));
        rooms.add(new Room(301, "Suite"));
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println("Room Number: " + room.getRoomNumber() + ", Category: " + room.getCategory());
            }
        }
    }

    public void bookRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (!room.isBooked()) {
                    room.bookRoom();
                    System.out.println("Room " + roomNumber + " successfully booked.");
                } else {
                    System.out.println("Room " + roomNumber + " is already booked.");
                }
                return;
            }
        }
        System.out.println("Room " + roomNumber + " does not exist.");
    }

    public void displayBookingDetails() {
        System.out.println("Booking Details:");
        for (Room room : rooms) {
            if (room.isBooked()) {
                System.out.println("Room Number: " + room.getRoomNumber() + ", Category: " + room.getCategory());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelReservationSystem system = new HotelReservationSystem();

        int choice;

        do {
            System.out.println("\n--- Hotel Reservation Menu ---");
            System.out.println("1. Display Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    system.bookRoom(roomNumber);
                    break;
                case 3:
                    system.displayBookingDetails();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
