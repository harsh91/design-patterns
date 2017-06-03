package decorator;

import component.Ticket;

public class TicketDecorator extends Ticket {

	private Ticket ticket;
	
	public TicketDecorator() {
		ticket = null;
	}
	
	public TicketDecorator(Ticket ticket) {
		this.ticket = ticket;
	}
	
	@Override
	public void printTicket() {
		if (ticket != null) {
			ticket.printTicket();
		}
	}
	
}
