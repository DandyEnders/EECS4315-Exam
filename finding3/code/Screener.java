package exam;

/**
 * A screener of a clinic.
 * 
 * @author Franck van Breugel
 */
public class Screener extends Thread implements Staff {
	private Clinic clinic;
	
	/**
	 * Initializes this screener with the given name and clinic.
	 * 
	 * @param name the name of this screener
	 * @param clinic the clinic of this screener
	 */
	public Screener(String name, Clinic clinic) {
		super(name);
		this.clinic = clinic;
	}

	/**
	 * Arrives, screens until interrupted, and departs.
	 */
	@Override
	public void run() {
		this.clinic.arrive();
		while (!Thread.interrupted()) {
			this.clinic.screen();
		}
		this.clinic.depart();
	}
}
