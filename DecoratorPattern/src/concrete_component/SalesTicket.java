package concrete_component;

import component.Ticket;

public class SalesTicket extends Ticket {

	@Override
	public void printTicket() {
		System.out.println("Ticket Owner Name: Harsh");
		System.out.println("Ticket ID: 109492376");
		System.out.println("Ticket Price: $999");
	}
	
}
