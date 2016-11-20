package uottawa.winter.problems.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class MaxBandwidth {
	
	public static void main(String[] args) {
		List<MyBandwidth> bandwidths = new ArrayList<MyBandwidth>();
		MyBandwidth bandwidth = new MyBandwidth();
		bandwidth.setStart(1);
		bandwidth.setEnd(3);
		bandwidth.setValue(10);
		
		bandwidths.add(bandwidth);
		
		bandwidth = new MyBandwidth();
		bandwidth.setStart(2);
		bandwidth.setEnd(3);
		bandwidth.setValue(10);
		
		bandwidths.add(bandwidth);
		
		bandwidth = new MyBandwidth();
		bandwidth.setStart(3);
		bandwidth.setEnd(5);
		bandwidth.setValue(10);
		
		bandwidths.add(bandwidth);
		
		bandwidth = new MyBandwidth();
		bandwidth.setStart(5);
		bandwidth.setEnd(8);
		bandwidth.setValue(10);
		
		bandwidths.add(bandwidth);
		
		bandwidth = new MyBandwidth();
		bandwidth.setStart(6);
		bandwidth.setEnd(7);
		bandwidth.setValue(20);
		
		bandwidths.add(bandwidth);
		
		bandwidth = new MyBandwidth();
		bandwidth.setStart(9);
		bandwidth.setEnd(10);
		bandwidth.setValue(20);
		
		bandwidths.add(bandwidth);
		
		bandwidth = new MyBandwidth();
		bandwidth.setStart(1);
		bandwidth.setEnd(5);
		bandwidth.setValue(40);
		
		bandwidths.add(bandwidth);
		
		List<MyBandwidth> rbs = new ArrayList<MyBandwidth>();
		for (MyBandwidth bw: bandwidths) {
			for (int start = bw.getStart(); start<=bw.getEnd(); start++) {
				MyBandwidth b = new MyBandwidth();
				b.setStart(start);
				b.setEnd(start+1);
				b.setValue(bw.getValue());
				rbs.add(b);
			}
		}
		
		HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
		for (MyBandwidth bw: rbs) {
			Integer start = bw.getStart();
			Integer value = bw.getValue();
			Integer existingValue = values.get(start);
			if (null != existingValue) {
				value += existingValue;
			}
			values.put(start, value);
		}
		
		Set<Entry<Integer, Integer>> entries = values.entrySet();
		Iterator<Entry<Integer, Integer>> itr = entries.iterator();
		int max = 0, maxIndex = -1;
		while(itr.hasNext()) {
			Entry<Integer, Integer> entry = itr.next();
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			if (max < value) {
				max = value;
				maxIndex = key;
			}
		}
		
		System.out.println("Maximum bandwidth is at " + maxIndex + " - " + (maxIndex + 1) + " and the maximum bandwidth is " + max);
	}
	

}

class MyBandwidth {
	public int start;
	public int end;
	public int value;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
