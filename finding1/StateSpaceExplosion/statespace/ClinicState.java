package statespace;

public class ClinicState {

	public static void main(String[] args) {
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < Integer.parseInt(args[0]); i++) {
					for(int j=0; j<Integer.parseInt(args[0]); j++){
						for(int k = 0;k<Integer.parseInt(args[0]); k++){
					Volatile v = new Volatile();
						}
					}
				 }
			 }

		};

		thread1.start();

	}

}
