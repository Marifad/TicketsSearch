import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(
            1,
            8_000,
            "LED",
            "VKO",
            120
    );

    Ticket ticket2 = new Ticket(
            2,
            20_000,
            "IST",
            "SVO",
            300
    );

    Ticket ticket3 = new Ticket(
            3,
            15_000,
            "IST",
            "SVO",
            320
    );

    Ticket ticket4 = new Ticket(
            4,
            35_000,
            "CDG",
            "LED",
            250
    );

    Ticket ticket5 = new Ticket(
            5,
            21_000,
            "IST",
            "SVO",
            300
    );

    TicketTimeComparator comparator = new TicketTimeComparator();

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldFindTickets() {
        Ticket[] expected = {ticket2, ticket5, ticket3};
        Ticket[] actual = manager.findAll("IST", "SVO", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTickets() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("IST", "LED", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindOneTicket() {
        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("LED", "VKO", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

}
