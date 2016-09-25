package AlgorithmAssignment;

public class DoublePoint implements Comparable<DoublePoint> {
	private double x;
	private double y;
	
	public DoublePoint(){
		x =0;
		y=0;
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
	
}
