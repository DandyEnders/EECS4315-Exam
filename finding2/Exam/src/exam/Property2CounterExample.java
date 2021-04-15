package exam;

public class Property2CounterExample {

	public static void main (String [] agrs)
	{
		Clinic clinic = new Clinic(2);
		Screener sasha = new Screener("Sasha", clinic);
		Screener samantha = new Screener("Samantha", clinic);
		Nurse noah = new Nurse("Noah", clinic);
		Nurse naomi = new Nurse("Naomi", clinic);
		Person peter = new Person("Peter", clinic);
		Person paula = new Person("Paula", clinic);
		sasha.start();
		samantha.start();
		noah.start();
		naomi.start();
		peter.start();
		paula.start();
		try {
			sasha.interrupt();
			samantha.interrupt();
			peter.join();
			paula.join();
		} catch (InterruptedException e) {
			System.err.println("Something went wrong");
			e.printStackTrace();
		}
		noah.interrupt();
		naomi.interrupt();		
	}
	

}
