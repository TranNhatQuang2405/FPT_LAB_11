package fpt.lab.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SiteVisitorCount implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long totalVisit;

	public Long getTotalVisit() {
		return totalVisit;
	}

	public void setTotalVisit(Long totalVisit) {
		this.totalVisit = totalVisit;
	}

	public SiteVisitorCount(Long totalVisit) {
		this.totalVisit = totalVisit;
	}

	public SiteVisitorCount() {
	}
	
	public List<Integer> getVisitorCount(){
		List<Integer> result = new ArrayList<Integer>();
		long tmpTotal = this.totalVisit;
		while(tmpTotal > 0) {
			result.add((int) (tmpTotal % 10));
			tmpTotal = tmpTotal / 10;
		}
		while(result.size() < 6) {
			result.add(0);
		}
		Collections.reverse(result);
		return result;
	}
}
