package data_structure.arrays;

import java.util.Scanner;




//sample input LINE 5 10
//4000
public class HalfAreaPoint {
	public double findHalfAreaPoint(Curve curve, double p) {
		double area = curve.areaUnderCurve(p);
		System.out.println("AREA UNDER CURVE @P:"+area);
		double harea = area/2;
        return getHalfPoint(curve, 0,p, harea);
	}



	private double getHalfPoint(Curve curve, double start,double end, double harea) {
		
		double midPoint = start + (end-start)/2;
		midPoint = getRoundValue(midPoint);
		System.out.println("MIDLE POINT:"+midPoint);
		double midArea = curve.areaUnderCurve(midPoint);
		
		
		
		if(getRoundValue(harea) == getRoundValue(midArea)){
        	return midPoint;
        }else if(midArea > harea ){
        	//System.out.println("RANGE IS BETWEEN :"+start+" "+midPoint);
        	midPoint = getHalfPoint(curve, start,midPoint,harea);
        }else{
        	//System.out.println("RANGE IS BETWEEN :"+midPoint+" "+end);
        	midPoint = getHalfPoint(curve, midPoint,end,harea);
        }
		return midPoint;
		
	}



	private double getRoundValue(double midPoint) {
		midPoint = Math.round(midPoint*100)/100.00d;
		return midPoint;
	}
	
	

    // DO NOT MODIFY CODE BELOW THIS LINE
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(" ");
			Curve c = null;
			switch (tokens[0]) {
			case "LINE":
				c = new Line(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
				break;
			case "EXP":
				c = new Exp();
				break;
			case "POWER":
				c = new Power(Double.parseDouble(tokens[1]));
				break;
			}

			if (c == null) {
				break;
			}
			HalfAreaPoint t=new HalfAreaPoint();
			double p = 10.0d;
			double h = t.findHalfAreaPoint(c, p);
			System.out.println(Math.round(h));
		}

		scanner.close();
	}
}

	interface Curve {
		double areaUnderCurve(double x);
	}

	class Line implements Curve {
		private double m;
		private double c;

		public Line(double m, double c) {
			this.m = m;
			this.c = c;
		}

		@Override
		public double areaUnderCurve(double x) {
			return m * x + c;
		}
	}

	class Exp implements Curve {
		@Override
		public double areaUnderCurve(double x) {
			return Math.exp(x);
		}
	}

	class Power implements Curve {
		private double power;

		public Power(double power) {
			this.power = power;
		}

		@Override
		public double areaUnderCurve(double x) {
			return Math.pow(x, power);
		}
	}