package concrete_decorator;

import component.Ticket;

import decorator.TicketDecorator;

public class SubHeaderTicketDecorator extends TicketDecorator {

	public SubHeaderTicketDecorator(Ticket ticket) {
		super(ticket);
	}
	
	@Override
	public void printTicket() {
		this.printHeader();
		super.printTicket();
	}

	private void printHeader() {
		System.out.println("Sub Header Ticket Decorator");
	}
	
}
