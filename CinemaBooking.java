
import java.util.Scanner;

class Cinema {
    String movie, customer;
    int price, tickets;

    // Constructor overloading
    Cinema() {
        movie = "Avatar";
        price = 200;
    }

    Cinema(String m, int p) {
        movie = m;
        price = p;
    }

    // Method overloading
    void book(int t) {
        tickets = t;
        display();
    }

    void book(int t, String c) {
        tickets = t;
        customer = c;
        display();
    }

    void display() {
        if (tickets <= 0) {
            System.out.println("Invalid number of tickets!");
            return;
        }

        double total = price * tickets;
        double discount = tickets >= 5 ? total * 0.10 : 0;

        System.out.println("\n--- CINEMA BOOKING ---");
        System.out.println("Customer: " + customer.toUpperCase());
        System.out.println("Movie: " + movie.toUpperCase());
        System.out.println("Ticket Price: Rs. " + price);
        System.out.println("Tickets: " + tickets);
        System.out.println("Total: Rs. " + total);
        System.out.println("Discount: Rs. " + discount);
        System.out.println("Final Amount: Rs. " + (total - discount));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.println("\nChoose a movie:");
        System.out.println("1. Avatar - Rs. 200");
        System.out.println("2. Jawan - Rs. 180");
        System.out.println("3. Interstellar - Rs. 250");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        Cinema c;

        switch (choice) {
            case 1:
                c = new Cinema("Avatar", 200);
                break;
            case 2:
                c = new Cinema("Jawan", 180);
                break;
            case 3:
                c = new Cinema("Interstellar", 250);
                break;
            default:
                System.out.println("Invalid movie choice!");
                sc.close();
                return;
        }

        System.out.print("Enter number of tickets: ");
        int tickets = sc.nextInt();

        c.book(tickets, name);

        sc.close();
    }
}
