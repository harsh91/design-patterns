package factory;

import component.Ticket;
import concrete_component.SalesTicket;
import concrete_decorator.FooterTicketDecorator;
import concrete_decorator.HeaderTicketDecorator;
import concrete_decorator.SubHeaderTicketDecorator;

public class TicketFactory {
	
	public static Ticket getSalesTicket() {
		return new HeaderTicketDecorator(new SubHeaderTicketDecorator(new FooterTicketDecorator(new SalesTicket())));
	}
	
}
