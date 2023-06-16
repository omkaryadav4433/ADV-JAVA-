package pojos;

public enum Course {
	
   DAC(900000),DBDA(1000000),DITISS(800000);

	private double fees;
	
	Course(double fees) {
	   this.fees=fees;
	   
   }

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
	
}
