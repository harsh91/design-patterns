package client;

import component.Ticket;
import factory.TicketFactory;

public class OrderTicket {

	public static void main(String[] args) {
		OrderTicket order = new OrderTicket();
		order.printTicket();
	}

	private void printTicket() {
		Ticket ticket = TicketFactory.getSalesTicket();
		ticket.printTicket();
	}

}
