package com.sqli.client.rte.bob.reporting.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqli.client.rte.bob.reporting.dao.CallProgramRepository;
import com.sqli.client.rte.bob.reporting.dao.ChronicleRepository;
import com.sqli.client.rte.bob.reporting.dao.PointRepository;
import com.sqli.client.rte.bob.reporting.model.CallProgram;
import com.sqli.client.rte.bob.reporting.model.Chronicle;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
    @Autowired
    CallProgramRepository callProgramRepository;
    
    @Autowired
    ChronicleRepository chronicleRepository;
    
    @Autowired
    PointRepository pointRepository;
    
	private int totalcallPrograms;
	private List<CallProgram> callPrograms = new ArrayList<CallProgram>();
	private List<Chronicle> chronics = new ArrayList<Chronicle>();;
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("totalCallPrograms", callProgramRepository.count());
		callPrograms.clear();
		for (int i =0; i<chronicleRepository.getPANbChronicles().size(); i++) {
			CallProgram callProgram = new CallProgram();
			callProgram.setId((Long) chronicleRepository.getPANbChronicles().get(i)[0]);
			callProgram.setChronicalTotal(((Long)chronicleRepository.getPANbChronicles().get(i)[1]).intValue());
			callPrograms.add(callProgram);
		}
		model.put("callPrograms", callPrograms);
		chronics.clear();
		List<Object[]> chroniclePoints = pointRepository.getChronicleNbPoints();
		for (int i =0; i<chroniclePoints.size(); i++) {
			Chronicle chronicle = new Chronicle();
			chronicle.setProgrammeappel_id((Long) chroniclePoints.get(i)[0]);
			chronicle.setId((Long) chroniclePoints.get(i)[1]);
			chronicle.setPointsTotal(((Long)chroniclePoints.get(i)[2]).intValue());
			chronics.add(chronicle);
		}
		model.put("chronics", chronics);
		return "BOB-Reporting-welcome";
	}
}