package exam;

/**
 * A person that visits a vaccination clinic.
 * 
 * @author Franck van Breugel
 */
public class Person extends Thread {
	private Clinic clinic;
	private boolean isEntered;
	private boolean isScreened;
	private boolean isVaccinated;
	private boolean isLeaved;

	/**
	 * Initializes this person with the given name and clinic.
	 * 
	 * @param name   the name of this person
	 * @param clinic the clinic which this person visits
	 */
	public Person(String name, Clinic clinic) {
		super(name);
		this.clinic = clinic;
		this.isEntered = false;
		this.isScreened = false;
		this.isVaccinated = false;
		this.isLeaved = false;
		clinic.addPerson(this);
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
			this.isEntered = true;
			this.clinic.getScreened();
			this.isScreened = true;
			this.clinic.getVaccinated();
			this.isVaccinated = true;
			this.clinic.leave();
			this.isLeaved = true;
			this.clinic.removePerson(this);
		} catch (InterruptedException e) {
			
		}
	}
	
}