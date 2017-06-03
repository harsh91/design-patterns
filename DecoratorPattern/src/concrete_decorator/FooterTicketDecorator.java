package concrete_decorator;

import component.Ticket;

import decorator.TicketDecorator;

public class FooterTicketDecorator extends TicketDecorator {

	public FooterTicketDecorator(Ticket ticket) {
		super(ticket);
	}
	
	@Override
	public void printTicket() {
		super.printTicket();
		this.printFooter();
	}
	
	private void printFooter() {
		System.out.println("Footer Ticket Decorator");
	}
	
}
