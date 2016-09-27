package AlgorithmAssignment;

public class DoublePoint implements Comparable<DoublePoint> {
	private double x;
	private double y;
	
	public DoublePoint(){
		x = 0;
		y = 0;
	}
	public DoublePoint(double x, double y){
		this.x=x;
		this.y=y;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public String print(){
		String xS = Double.toString(x);
		String yS = Double.toString(y);
		if ((x*10)%10 == 0){
			xS = Integer.toString((int) x);
		}
		if ((y*10)%10 == 0){
			yS = Integer.toString((int) y);
		}
		return xS + " " + yS;
	}

	@Override
	public int compareTo(DoublePoint other){
		if (this.x < other.x){
			return -1;
		}else if (this.x > other.x){
			return 1;
		}else {
			return 0;
		}
	}
	
//eclipse generated equals and hashCode for DoublePoint	
@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoublePoint other = (DoublePoint) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

}
