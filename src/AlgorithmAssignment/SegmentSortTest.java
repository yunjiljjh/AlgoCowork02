package AlgorithmAssignment;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SegmentSortTest {
	public interface SegmentSort {

		class lineSegment implements Comparable<lineSegment>{
			public double x1, x2, y1, y2;
			public lineSegment(double x1, double y1, double x2, double y2){
				this.x1 = x1;
				this.y1 = y1;
				this.x2 = x2;
				this.y2 = y2;
			}
			
			@Override
			public int compareTo(lineSegment other){
				if (this.x1 < other.x1){
					return -1;
				}else if (this.x1 > other.x1){
					return 1;
				}else {
					return 0;
				}
			}
		}
	}

	@Test
	public void sortSegs() {
		lineSegment[] segments = {
				new lineSegment(1.1, 3.2, 0, 4.3),
				new lineSegment(0.9, 4.4, 7.5, 0)				
		};
		
		Arrays.sort(segments);
		System.out.printf("\n%.2f %.2f\n", segments[0].x1, segments[1].x1);
		System.out.printf("%.2f %.2f\n", segments[0].y1, segments[1].y1);
		System.out.printf("%.2f %.2f\n", segments[0].x2, segments[1].x2);
		System.out.printf("%.2f %.2f\n", segments[0].y2, segments[1].y2);

	}

}
