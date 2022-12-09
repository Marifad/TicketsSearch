import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repo;
    private Ticket[] tickets = new Ticket[0];
//    private TicketTimeComparator comparator = new TicketTimeComparator();

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }


    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {

        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getItems()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }

                tmp[tmp.length - 1] = ticket;
                result = tmp;

            }
        }
        Arrays.sort(result);
        Arrays.sort(result, comparator);
        return result;

    }


    // метод определения соответствия товара product запросу search
    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equals(from) && (ticket.getTo().equals(to))) {
            return true;
        } else {
            return false;
        }
    }

}


