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
import com.sqli.client.rte.bob.reporting.dao.EcpFinancialPriceRepository;
import com.sqli.client.rte.bob.reporting.dao.EcpMarketDocumentRepository;
import com.sqli.client.rte.bob.reporting.dao.EcpPointRepository;
import com.sqli.client.rte.bob.reporting.dao.EcpSeriesPeriodRepository;
import com.sqli.client.rte.bob.reporting.dao.EcpTimeSeriesRepository;
import com.sqli.client.rte.bob.reporting.dao.PointRepository;
import com.sqli.client.rte.bob.reporting.model.CallProgram;
import com.sqli.client.rte.bob.reporting.model.Chronicle;
import com.sqli.client.rte.bob.reporting.model.EcpMarketDocument;
import com.sqli.client.rte.bob.reporting.model.SygaBatchExecution;
import com.sqli.client.rte.bob.reporting.model.SygaOfferErroneous;
import com.sqli.client.rte.bob.reporting.model.SygaOfferRejected;

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

	@Autowired
	BatchRepository batchRepository;
	@Autowired
	EcpMarketDocumentRepository ecpMarketDocumentRepository;
	
	@Autowired
	EcpPointRepository ecpPointRepository;
	
	@Autowired
	EcpSeriesPeriodRepository ecpSeriesPeriodRepository;
	
	@Autowired
	EcpTimeSeriesRepository ecpTimeSeriesRepository;
	
	@Autowired
	EcpFinancialPriceRepository ecpFinancialPriceRepository;
	
	

	private int totalcallPrograms;
	private List<CallProgram> callPrograms = new ArrayList<CallProgram>();
	private List<Chronicle> chronics = new ArrayList<Chronicle>();
	private List<SygaBatchExecution> sygaBatchExecutions = new ArrayList<SygaBatchExecution>();
	private List<SygaBatchExecution> sygaBatchRejectedOffers = new ArrayList<SygaBatchExecution>();
	private List<SygaBatchExecution> sygaBatchErroneousOffers = new ArrayList<SygaBatchExecution>();
	
	//private List<SygaBatchExecution> ecpSeriesPeriod = new ArrayList<SygaBatchExecution>();
	private List<SygaBatchExecution> ecpTimeSerie = new ArrayList<SygaBatchExecution>();
	//private List<SygaBatchExecution> ecpPoint = new ArrayList<SygaBatchExecution>();
	//private List<SygaBatchExecution> ecpFinancialPrice = new ArrayList<SygaBatchExecution>();
	private List<SygaBatchExecution> ecpMarketDocument = new ArrayList<SygaBatchExecution>();

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("totalCallPrograms", callProgramRepository.count());
		callPrograms.clear();
		sygaBatchExecutions.clear();
		sygaBatchRejectedOffers.clear();
		sygaBatchErroneousOffers.clear();
		ecpMarketDocument.clear();
		for (int i = 0; i < chronicleRepository.getPANbChronicles().size(); i++) {
			CallProgram callProgram = new CallProgram();
			callProgram.setId((Long) chronicleRepository.getPANbChronicles().get(i)[0]);
			callProgram.setChronicalTotal(((Long) chronicleRepository.getPANbChronicles().get(i)[1]).intValue());
			callPrograms.add(callProgram);
		}
		model.put("callPrograms", callPrograms);
		chronics.clear();
		List<Object[]> chroniclePoints = pointRepository.getChronicleNbPoints();
		for (int i = 0; i < chroniclePoints.size(); i++) {
			Chronicle chronicle = new Chronicle();
			chronicle.setProgrammeappel_id((Long) chroniclePoints.get(i)[0]);
			chronicle.setId((Long) chroniclePoints.get(i)[1]);
			chronicle.setPointsTotal(((Long) chroniclePoints.get(i)[2]).intValue());
			chronics.add(chronicle);
		}
		model.put("chronics", chronics);

		// -----------------------------------------------------------------------------
		// -------------Syga batch execution Report-------------------------------------
		// -----------------------------------------------------------------------------

		List<Object[]> sygaOffers = batchRepository.getSygaOffers("topase", BatchStatus.COMPLETED.toString());
		for (int i = 0; i < sygaOffers.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) sygaOffers.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) sygaOffers.get(i)[1]);
			sygaBatchExecution.setTotal_offers(((Long) sygaOffers.get(i)[2]).intValue());
			sygaBatchExecutions.add(sygaBatchExecution);
		}
		model.put("batchExecutions", sygaBatchExecutions);

		List<Object[]> sygaRejectedOffers = batchRepository.getSygaRejectedOffers("topase",
				BatchStatus.COMPLETED.toString());
		for (int i = 0; i < sygaRejectedOffers.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) sygaRejectedOffers.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) sygaRejectedOffers.get(i)[1]);
			sygaBatchExecution.setTotal_offers(((Long) sygaRejectedOffers.get(i)[2]).intValue());
			sygaBatchRejectedOffers.add(sygaBatchExecution);
		}
		model.put("sygaBatchRejectedOffers", sygaBatchRejectedOffers);

		List<Object[]> sygaErroneousOffers = batchRepository.getSygaErrorneousOffers("topase",
				BatchStatus.COMPLETED.toString());
		for (int i = 0; i < sygaErroneousOffers.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) sygaErroneousOffers.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) sygaErroneousOffers.get(i)[1]);
			sygaBatchExecution.setTotal_offers(((Long) sygaErroneousOffers.get(i)[2]).intValue());
			sygaBatchErroneousOffers.add(sygaBatchExecution);
		}
		model.put("sygaBatchErroneousOffers", sygaBatchErroneousOffers);
		
		
		
		//-----------------------------------------------------------------------------
		//-------------ECP* batch execution Report-------------------------------------
		//-----------------------------------------------------------------------------
		
		List<Object[]> ecpMarketDocuments = ecpMarketDocumentRepository.getEcpMarketDocument("topase",
				BatchStatus.COMPLETED.toString());
		for (int i = 0; i < ecpMarketDocuments.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) ecpMarketDocuments.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) ecpMarketDocuments.get(i)[1]);
			sygaBatchExecution.setTotal_offers(((Long) ecpMarketDocuments.get(i)[2]).intValue());
			ecpMarketDocument.add(sygaBatchExecution);
		}
		model.put("ecpMarketDocuments", ecpMarketDocument);
		/*
		List<Object[]> ecpPoints = ecpPointRepository.getEcpPoint("topase",
				BatchStatus.COMPLETED.toString());
		for (int i = 0; i < ecpPoints.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) ecpPoints.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) ecpPoints.get(i)[1]);
			sygaBatchExecution.setTotal_offers(((Long) ecpPoints.get(i)[2]).intValue());
			ecpPoint.add(sygaBatchExecution);
		}
		model.put("ecpPoints", ecpPoint);
		
		
		List<Object[]> ecpSeriesPeriods = ecpSeriesPeriodRepository.getEcpSeriesPeriod("topase",
				BatchStatus.COMPLETED.toString());
		for (int i = 0; i < ecpSeriesPeriods.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) ecpSeriesPeriods.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) ecpSeriesPeriods.get(i)[1]);
			sygaBatchExecution.setTotal_offers(((Long) ecpSeriesPeriods.get(i)[2]).intValue());
			ecpSeriesPeriod.add(sygaBatchExecution);
		}
		model.put("ecpSeriesPeriods", ecpSeriesPeriod);
		
		
		List<Object[]> ecpFinancialPrices = ecpFinancialPriceRepository.getEcpFinancialPrice("topase",
				BatchStatus.COMPLETED.toString());
		for (int i = 0; i < ecpFinancialPrices.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) ecpFinancialPrices.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) ecpFinancialPrices.get(i)[1]);
			sygaBatchExecution.setTotal_offers(((Long) ecpFinancialPrices.get(i)[2]).intValue());
			ecpFinancialPrice.add(sygaBatchExecution);
		}
		model.put("ecpFinancialPrices", ecpFinancialPrice);
		*/
		/*
		List<Object[]> ecpTimeSeries = ecpTimeSeriesRepository.getEcpTimeSeries("topase",
				BatchStatus.COMPLETED.toString());
		for (int i = 0; i < ecpTimeSeries.size(); i++) {
			SygaBatchExecution sygaBatchExecution = new SygaBatchExecution();
			sygaBatchExecution.setBatch_id((Long) ecpTimeSeries.get(i)[0]);
			sygaBatchExecution.setStart_time((Date) ecpTimeSeries.get(i)[1]);
			sygaBatchExecution.setTotal_offers(((Long) ecpTimeSeries.get(i)[2]).intValue());
			ecpTimeSerie.add(sygaBatchExecution);
		}
		model.put("ecpTimeSeries", ecpTimeSerie);
		*/
		
		return "BOB-Reporting-welcome";
	}
}