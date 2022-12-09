public class Ticket implements Comparable<Ticket> {

    private int id;
    private double price;
    private String from;
    private String to;
    private int time;

    public Ticket(int id, double price, String from, String to, int time) {

        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.time = time;

    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}

