package com.example.collegemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.collegemanagement.model.InternalMarks;
import com.example.collegemanagement.service.InternalMarksService;

@RestController 
@CrossOrigin(origins="*")
@RequestMapping("/api/internalmarks")
public class InternalMarksController {
@Autowired
	private InternalMarksService internalMarksService;

	public InternalMarksController(InternalMarksService internalMarksService) {
		super();
		this.internalMarksService = internalMarksService;
	}
	@PostMapping("{id}")
	public ResponseEntity<InternalMarks> saveInternalMarks(@RequestBody InternalMarks internalmarks,@PathVariable("id") long Id)
	{
		System.out.println(internalmarks);
		return new ResponseEntity<InternalMarks>(internalMarksService.saveInternalMarks(internalmarks,Id),HttpStatus.CREATED);
	}
	@GetMapping("/getAllInternalMarks")
	public List<InternalMarks> getAllInternalMarks()
	{
		return  internalMarksService.getAllInternalMarks();
	}
	@GetMapping("/getInternalMarks/{id}")
	public ResponseEntity<InternalMarks> getInternalMarksById(@PathVariable("id") long  internalmarksId)
	{
		return new ResponseEntity<InternalMarks>(internalMarksService.getInternalMarksById(internalmarksId),HttpStatus.OK);
	}
	@PutMapping("/updateInternalMarks/{id}")
	public ResponseEntity<InternalMarks> updateInternalMarks(@PathVariable("id") long id, @RequestBody InternalMarks internalmarks)
	{
		return new ResponseEntity<InternalMarks>(internalMarksService.updateInternalMarks(internalmarks, id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteInternalMarks/{id}")
	public ResponseEntity<String> deleteInternalMarks(@PathVariable("id") long id)
	{
		internalMarksService.deleteInternalMarks(id);
		return new ResponseEntity<String>("Marks deleted successfully",HttpStatus.OK);
	}
}
