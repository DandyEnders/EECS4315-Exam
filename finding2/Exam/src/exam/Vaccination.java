package exam;

/**
 * The vaccination at a clinic.
 * 
 * @author Franck van Breugel
 */
public class Vaccination {
	private Nurse nurse; 
	private Person person;
	
	/**
	 * Initializes the vaccination.
	 */
	public Vaccination() {
		this.nurse = null;
		this.person = null;
	}
	
	/**
	 * Person gets vaccinated.  Person may have to wait until it is their turn.  
	 * Person may have to wait for a nurse.
	 * 
	 * @throws InterruptedException if anyone is interrupted
	 */
	public synchronized void getVaccinated() throws InterruptedException {
		if (this.person != null) {
			this.wait();
		}
		this.person = (Person) Thread.currentThread();
		if (this.nurse == null) {
			this.wait();
		}
		System.out.printf("%s vaccinates %s%n", this.nurse.getName(), this.person.getName());
		this.nurse = null;
		this.person = null;
		this.notify();
	}
	
	/**
	 * Nurse is ready to vaccinate.
	 */
	public synchronized void vaccinate() {
		this.nurse = (Nurse) Thread.currentThread();
		this.notify();
	}
}