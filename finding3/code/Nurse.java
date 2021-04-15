package exam;

/**
 * A nurse of a clinic.
 * 
 * @author Franck van Breugel
 */
public class Nurse extends Thread implements Staff {
	private Clinic clinic;
	
	/**
	 * Initializes this nurse with the given name and clinic.
	 * 
	 * @param name the name of this nurse
	 * @param clinic the clinic of this nurse
	 */
	public Nurse(String name, Clinic clinic) {
		super(name);
		this.clinic = clinic;
	}

	/**
	 * Arrives, vaccinates until interrupted, and departs.
	 */
	@Override
	public void run() {
		this.clinic.arrive();
		while (!Thread.interrupted()) {
			this.clinic.vaccinate();
		}
		this.clinic.depart();
	}
}
