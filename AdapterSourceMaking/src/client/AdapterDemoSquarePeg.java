package client;

import adaptee.RoundHole;
import adapter.SquarePegAdapter;

class AdapterDemoSquarePeg {
	public static void main(String[] args) {
		RoundHole rh = new RoundHole(5);
		SquarePegAdapter spa;

		for (int i = 6; i < 15; i++) {
			spa = new SquarePegAdapter((double) i);
			// The client uses (is coupled to) the new interface
			spa.makeFit(rh);
		}
	}
}