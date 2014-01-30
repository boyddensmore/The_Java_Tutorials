package bicycle;

public class ACMEMountainBike extends ACMEBicycle {

	double tireWidth = 1.734;
	
	public void changeTireWidth(double newWidth) {
		
		if (newWidth > 0.75) {
			tireWidth = newWidth;
		}
	}
}
