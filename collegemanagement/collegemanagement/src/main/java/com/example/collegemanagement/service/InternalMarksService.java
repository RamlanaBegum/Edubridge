package com.example.collegemanagement.service;

import java.util.List;

import com.example.collegemanagement.model.InternalMarks;

public interface InternalMarksService {
	InternalMarks saveInternalMarks(InternalMarks internalMarks,long id);
	List<InternalMarks> getAllInternalMarks();
	InternalMarks getInternalMarksById(long id);
	InternalMarks updateInternalMarks(InternalMarks internalMarks, long id);
	void deleteInternalMarks(long id);
}