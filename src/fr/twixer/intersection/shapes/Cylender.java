package fr.twixer.intersection.shapes;

public class Cylender {

	double mX;
	double mY;
	double mZ;
	double vX;
	double vY;
	double vZ;
	double radius;
	
	
	public Cylender(int mX, int mY, int mZ, int vX, int vY, int vZ, int radius) {
		super();
		this.mX = mX;
		this.mY = mY;
		this.mZ = mZ;
		this.vX = vX;
		this.vY = vY;
		this.vZ = vZ;
		this.radius = radius;
	}


	public double getmX() {
		return mX;
	}


	public void setmX(double mX) {
		this.mX = mX;
	}


	public double getmY() {
		return mY;
	}


	public void setmY(double mY) {
		this.mY = mY;
	}


	public double getmZ() {
		return mZ;
	}


	public void setmZ(double mZ) {
		this.mZ = mZ;
	}


	public double getvX() {
		return vX;
	}


	public void setvX(double vX) {
		this.vX = vX;
	}


	public double getvY() {
		return vY;
	}


	public void setvY(double vY) {
		this.vY = vY;
	}


	public double getvZ() {
		return vZ;
	}


	public void setvZ(double vZ) {
		this.vZ = vZ;
	}


	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void init() {
		System.out.printf("Cylinder of radius %.0f", this.radius);
		System.out.printf("\nLine passing through the point (%.0f, %.0f, %.0f) and parallel to the vector (%.0f, %.0f, %.0f)", this.mX, this.mY, this.mZ, this.vX, this.vY, this.vZ);
		
		double a = Math.pow(this.vX, 2) + Math.pow(this.vY, 2);
		double b = 2 * (this.vX * this.mX) + (this.vY * this.mY);
		double c = (Math.pow(this.mX, 2) + Math.pow(this.mY, 2)) - Math.pow(radius, 2);
		double delta = b * 2 - (4 * a * c);
		
		if(delta > 0) {
			double x1 = -b - (Math.sqrt(delta)/(2*a));
			double x2 = -b + (Math.sqrt(delta)/(2*a));
			double x = this.vX * x1 + this.mX;
			double y = this.vY * x1 + this.mY;
			double z = this.vZ * x1 + this.mZ;
			
			double s = this.vX * x2 + this.mX;
			double t = this.vY * x2 + this.mY;
			double u = this.vZ * x2 + this.mZ;
			
			System.out.printf("\n2 intersection points:");
			System.out.printf("\n(%.3f, %.3f, %.3f)", s, t, u);
			System.out.printf("\n(%.3f, %.3f, %.3f)", x, y, z);
		} else if(delta == 0) {
			if(2 * a != 0) {
				double f = -b/(2 * a);
				double g = this.vX * f + this.mX;
				double h = this.vY * f + this.mY;
				double i = this.vZ * f + this.mZ;
				
				System.out.printf("\n1 intersection point:");
				System.out.printf("\n(%.3f, %.3f, %.3f)", g, h, i);
			} else {
				System.out.println("\nThere is an infinite number of intersection points.");
			}
		} else {
			System.out.println("\nNo intersection point.");
		}
		System.exit(0);
	}
}

