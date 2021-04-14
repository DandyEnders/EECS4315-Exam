package exam;

/**
 * The screening at a clinic.
 * 
 * @author Franck van Breugel
 */
public class Screening {
	private Screener screener; 
	private Person screenee;
	
	/**
	 * Initializes the screening.
	 */
	public Screening() {
		this.screener = null;
		this.screenee = null;
	}
	
	/**
	 * Person gets screened.  Person may have to wait until it is their turn.  
	 * Person may have to wait for a screener.
	 * 
	 * @throws InterruptedException if anyone is interrupted
	 */
	public synchronized void getScreened() throws InterruptedException {
		if (this.screenee != null) {
			this.wait();
		}
		this.screenee = (Person) Thread.currentThread();
		if (this.screener == null) {
			this.wait();
		}
		System.out.printf("%s screens %s%n", this.screener.getName(), this.screenee.getName());
		this.screener = null;
		this.screenee = null;
		this.notify();
	}
	
	/**
	 * Screener is ready to screen.
	 */
	public synchronized void screen() {
		this.screener = (Screener) Thread.currentThread();
		this.notify();
	}
}