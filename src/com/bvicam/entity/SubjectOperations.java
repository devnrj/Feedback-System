package com.bvicam.entity;

public class SubjectOperations {
	public static boolean isGeneral(Subject sub) {
		if(sub.getId() >= 44101 && sub.getId() <= 44362) {
			if(sub.getId() > 11104 && sub.getId() < 11101) {
				return false;
			}else {
				return true;
			}
			
		}
		return false;
	}
}
