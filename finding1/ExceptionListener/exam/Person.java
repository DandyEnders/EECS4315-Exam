package exam;

/**
 * A person that visits a vaccination clinic.
 * 
 * @author Franck van Breugel
 */
public class Person extends Thread {
	private Clinic clinic;
	
	/**
	 * Initializes this person with the given name and clinic.
	 * 
	 * @param name the name of this person
	 * @param clinic the clinic which this person visits
	 */
	public Person(String name, Clinic clinic) {
		super(name);
		this.clinic = clinic;
	}
	
	/**
	 * A person
	 * <ol>
	 * <li>enters the clinic,</li>
	 * <li>gets screened,</li>
	 * <li>gets vaccinated,</li>
	 * <li>leaves the clinic.</li>
	 * </ol>
	 */
	@Override
	public void run() {
		try {
			this.clinic.enter();
			this.clinic.getScreened();
			this.clinic.getVaccinated();
			this.clinic.leave();
		} catch (InterruptedException e) {}
	}
}
