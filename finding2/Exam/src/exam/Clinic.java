package exam;

/**
 * A vaccination clinic.
 * 
 * @author Franck van Breugel
 */
public class Clinic {
	private int capacity;
	private int occupancy;

	private Screening screening;
	private Vaccination vaccination;

	/**
	 * The default capacity of a clinic.
	 */
	public static final int DEFAULT_CAPACITY = 100;

	/**
	 * Initializes this clinic with the given capacity.
	 * 
	 * @param capacity the capacity of this clinic
	 */
	public Clinic(int capacity) {
		if (capacity <= 0) { throw new IllegalArgumentException("Capacity must be bigger than 0."); }
		this.capacity = capacity;
		this.occupancy = 0;

		this.screening = new Screening();
		this.vaccination = new Vaccination();
	}

	/**
	 * Initializes this clinic with the default capacity.
	 */
	public Clinic() throws Exception {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Person enters this clinic.  Person may have to wait if this clinic is at full capacity.
	 * 
	 * @throws InterruptedException if anyone is interrupted
	 */
	public void enter() throws InterruptedException {
		while (this.occupancy == this.capacity) {
			this.wait();
		}
		this.occupancy++;
		String name = Thread.currentThread().getName();
		System.out.printf("%s enters the clinic%n", name);
	}

	/**
	 * Person leaves this clinic.
	 */
	public void leave() {
		String name = Thread.currentThread().getName();
		System.out.printf("%s leaves the clinic%n", name);
		this.occupancy--;
		this.notifyAll();
	}

	/**
	 * Staff member arrives at this clinic.
	 */
	public synchronized void arrive() {
		Thread thread = Thread.currentThread();
		System.out.printf("%s arrives at the clinic%n", thread.getName());
	}

	/**
	 * Staff member departs from this clinic.
	 */
	public synchronized void depart() {
		Thread thread = Thread.currentThread();
		System.out.printf("%s departs from the clinic%n", thread.getName());
	}

	/**
	 * Screener is ready to screen a person in this clinic.
	 */
	public void screen() {
		this.screening.screen();
	}

	/**
	 * Person gets screened at this clinic.  Person may have to wait until it is their turn.  
	 * Person may have to wait for a screener.
	 * 
	 * @throws InterruptedException if anyone gets interrupted
	 */
	public void getScreened() throws InterruptedException {
		this.screening.getScreened();
	}

	/**
	 * Nurse is ready to vaccinate a person in this clinic.
	 */
	public void vaccinate() {
		this.vaccination.vaccinate();
	}

	/**
	 * Person gets vaccinated.  Person may have to wait until it is their turn.  
	 * Person may have to wait for a nurse.
	 * 
	 * @throws InterruptedException if anyone gets interrupted
	 */
	public void getVaccinated() throws InterruptedException {
		this.vaccination.getVaccinated();
	}
}