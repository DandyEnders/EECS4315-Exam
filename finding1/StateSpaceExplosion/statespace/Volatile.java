package statespace;

import java.util.Random;

import exam.Clinic;

public class Volatile {
	public volatile Clinic clinic;
	
	public Volatile() {
		Random rand = new Random();
		int capacity = rand.nextInt();
		clinic = new Clinic(capacity);
	}

}
