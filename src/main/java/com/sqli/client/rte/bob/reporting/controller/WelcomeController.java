package com.sqli.client.rte.bob.reporting.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqli.client.rte.bob.reporting.dao.BatchRepository;
import com.sqli.client.rte.bob.reporting.dao.CallProgramRepository;
import com.sqli.client.rte.bob.reporting.dao.ChronicleRepository;
import com.sqli.client.rte.bob.reporting.dao.PointRepository;
import com.sqli.client.rte.bob.reporting.model.CallProgram;
import com.sqli.client.rte.bob.reporting.model.Chronicle;
import com.sqli.client.rte.bob.reporting.model.SygaBatchExecution;
@Controller
public class WelcomeController {

	private static final String SYGA_BATCH = "syga";
	
    @Autowired
    CallProgramRepository callProgramRepository;
    
    @Autowired
    ChronicleRepository chronicleRepository;
    
    @Autowired
    PointRepository pointRepository;
    
    @Autowired
    BatchRepository batchRepository;
    
	private List<CallProgram> callPrograms = new ArrayList<CallProgram>();
	private List<Chronicle> chronics = new ArrayList<Chronicle>();
	private List<SygaBatchExecution> sygaBatchExecutions = new ArrayList<SygaBatchExecution>();
	private List<SygaBatchExecution> sygaBatchRejectedOffers = new ArrayList<SygaBatchExecution>();
	private List<SygaBatchExecution> sygaBatchErroneousOffers = new ArrayList<SygaBatchExecution>();

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("totalCallPrograms", callProgramRepository.count());
		callPrograms.clear();
		sygaBatchExecutions.clear();
		sygaBatchRejectedOffers.clear();
		sygaBatchErroneousOffers.clear();
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
		
		//-----------------------------------------------------------------------------
		//-------------Syga batch execution Report-------------------------------------
		//-----------------------------------------------------------------------------

		List <Object[]> sygaOffers= batchRepository.getSygaOffers(SYGA_BATCH, BatchStatus.COMPLETED.toString());
		for (int i =0; i< sygaOffers.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) sygaOffers.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) sygaOffers.get(i)[1]);	
			sygaBatchExecution.setTotal_offers(((Long) sygaOffers.get(i)[2]).intValue());
			sygaBatchExecutions.add(sygaBatchExecution);
			}
		model.put("batchExecutions", sygaBatchExecutions);
		
		List <Object[]> sygaRejectedOffers= batchRepository.getSygaRejectedOffers(SYGA_BATCH, BatchStatus.COMPLETED.toString());
		for (int i =0; i< sygaRejectedOffers.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) sygaRejectedOffers.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) sygaRejectedOffers.get(i)[1]);	
			sygaBatchExecution.setTotal_offers(((Long) sygaRejectedOffers.get(i)[2]).intValue());
			sygaBatchRejectedOffers.add(sygaBatchExecution);
			}
		model.put("sygaBatchRejectedOffers", sygaBatchRejectedOffers);
		
		List <Object[]> sygaErroneousOffers= batchRepository.getSygaErrorneousOffers(SYGA_BATCH, BatchStatus.COMPLETED.toString());
		for (int i =0; i< sygaErroneousOffers.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) sygaErroneousOffers.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) sygaErroneousOffers.get(i)[1]);	
			sygaBatchExecution.setTotal_offers(((Long) sygaErroneousOffers.get(i)[2]).intValue());
			sygaBatchErroneousOffers.add(sygaBatchExecution);
			}
		model.put("sygaBatchErroneousOffers", sygaBatchErroneousOffers);
		return "BOB-Reporting-welcome";
	}
}