public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        int id = ticket.getId();

        if (findById(id) != null) {
            throw new AlreadyExistsException(ticket);
        }
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }

        tmp[tmp.length - 1] = ticket;
        tickets = tmp;

    }


    public Ticket[] getItems() {

        return tickets;
    }

    public Ticket findById(int id) {

        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;

    }

    public void removeById(int id) {

        if (findById(id) == null) {
            throw new NotFoundException(id);
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket item : tickets) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

}

