package fr.twixer.intersection;

import fr.twixer.intersection.shapes.Cone;
import fr.twixer.intersection.shapes.Cylender;
import fr.twixer.intersection.shapes.Sphere;

public class Main {

	public static void main(String[] args) {
		if(args.length == 1) {
			if (args[0].equals("-h")) {
				System.out.println(
						"USAGE\n" + 
						"\t./104intersection opt xp yp zp xv yv zv p\n" + 
						"\nDESCRIPTION\n" + 
						"\topt\t\tsurface option: 1 for a sphere, 2 for a cylinder, 3 for a cone\n" + 
						"\t(xp, yp, zp)\tcoordinates of a point by which the light ray passes through\n" + 
						"\t(xv, yv, zv)\tcoordinates of a vector parallel to the light ray\n" + 
						"\tp\t\tparameter: radius of the sphere, radius of the cylinder, or angle formed by the cone and the Z-axis");
				System.exit(0);
			} else {
				System.exit(84);
			}
		} else if(args.length == 8) {
			Shapes(args);
		} else {
			System.exit(84);
		}

	}
	
	private static void Shapes(String[] args) {
		int opt = 0;
		int xp = 0;
		int yp = 0;
		int zp = 0;
		int xv = 0;
		int yv = 0;
		int zv = 0;
		int p = 0;
		try {
			opt = Integer.valueOf(args[0]);
			xp = Integer.valueOf(args[1]);
			yp = Integer.valueOf(args[2]);
			zp = Integer.valueOf(args[3]);
			xv = Integer.valueOf(args[4]);
			yv = Integer.valueOf(args[5]);
			zv = Integer.valueOf(args[6]);
			p = Integer.valueOf(args[7]);
		} catch (Exception e) {
			System.exit(84);
		}
		if (p == 0 || (xv == 0 && yv == 0 && zv == 0)) {
			System.exit(84);
		}
		if (opt == 1) {
			new Sphere(xp, yp, zp, xv, yv, zv, p).init();
		}
		if (opt == 2) {
			new Cylender(xp, yp, zp, xv, yv, zv, p).init();
		}
		if (opt == 3) {
			new Cone(xp, yp, zp, xv, yv, zv, p).init();
		} else {
			System.exit(84);
		}
	}

}
