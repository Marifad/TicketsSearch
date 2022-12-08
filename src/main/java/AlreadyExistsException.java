public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(Ticket ticket) {

        super("Element with id: " + ticket.getId() + " already exists");

    }
}
