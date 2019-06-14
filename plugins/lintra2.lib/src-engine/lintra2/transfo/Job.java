package lintra2.transfo;

import java.io.Serializable;

import lintra2.blackboard.IArea;
import lintra2.blackboard.IdentifiableElement;

public class Job implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	IArea area;
	double minID;
	double maxID;
	
	/**
	 * Elements in area whose identifiers go from minID to maxID 
	 * @param area
	 * @param minID
	 * @param maxID
	 */
	public Job(IArea area, double minID, double maxID){
		this.area = area;
		this.minID = minID;
		this.maxID = maxID;
	}

	public double getMinID() {
		return minID;
	}

	public void setMinID(int minID) {
		this.minID = minID;
	}

	public double getMaxID() {
		return maxID;
	}

	public void setMaxID(int maxID) {
		this.maxID = maxID;
	}
	
	public IArea getArea() {
		return area;
	}

	public void setArea(IArea area) {
		this.area = area;
	}

	public String toString(){
		return "[" + minID + ".." + maxID + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Job(area, minID, maxID);
	}
	
}
