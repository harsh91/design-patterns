package concrete_decorator;

import component.Ticket;

import decorator.TicketDecorator;

public class HeaderTicketDecorator extends TicketDecorator {

	public HeaderTicketDecorator(Ticket ticket) {
		super(ticket);
	}
	
	@Override
	public void printTicket() {
		this.printHeader();
		super.printTicket();
	}
	
	private void printHeader() {
		System.out.println("Header Ticket Decorator");
	}

}
