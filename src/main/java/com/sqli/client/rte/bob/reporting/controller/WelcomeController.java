package com.sqli.client.rte.bob.reporting.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sqli.client.rte.bob.reporting.dao.BatchRepository;
import com.sqli.client.rte.bob.reporting.dao.CallProgramRepository;
import com.sqli.client.rte.bob.reporting.dao.ChronicleRepository;
import com.sqli.client.rte.bob.reporting.dao.EcpMarketDocumentRepository;
import com.sqli.client.rte.bob.reporting.dao.PointRepository;
import com.sqli.client.rte.bob.reporting.model.CallProgram;
import com.sqli.client.rte.bob.reporting.model.Chronicle;
import com.sqli.client.rte.bob.reporting.model.EcpStandardOffer;
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
    
    @Autowired
	EcpMarketDocumentRepository ecpMarketDocumentRepository;
    
	private List<CallProgram> callPrograms = new ArrayList<CallProgram>();
	private List<Chronicle> chronics = new ArrayList<Chronicle>();
	private List<SygaBatchExecution> sygaBatchExecutions = new ArrayList<SygaBatchExecution>();
	private List<SygaBatchExecution> sygaBatchRejectedOffers = new ArrayList<SygaBatchExecution>();
	private List<SygaBatchExecution> sygaBatchErroneousOffers = new ArrayList<SygaBatchExecution>();
	private List<SygaBatchExecution> ecpMarketDocument = new ArrayList<SygaBatchExecution>();
	private List<EcpStandardOffer> ecpTimeSeries = new ArrayList<EcpStandardOffer>();
	private List<EcpStandardOffer> ecpSeriesPeriods = new ArrayList<EcpStandardOffer>();
	private List<EcpStandardOffer> ecpPoint = new ArrayList<EcpStandardOffer>();
	private List<EcpStandardOffer> ecpFinancialPrice = new ArrayList<EcpStandardOffer>();
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("totalCallPrograms", callProgramRepository.count());
		callPrograms.clear();
		sygaBatchExecutions.clear();
		sygaBatchRejectedOffers.clear();
		sygaBatchErroneousOffers.clear();
		ecpTimeSeries.clear();
		ecpTimeSeries.clear();
		ecpSeriesPeriods.clear();
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
		
		List<Object[]> ecpTimeSeriesObj =  ecpMarketDocumentRepository.getEcpTimesSeries("topase", BatchStatus.COMPLETED.toString());
		
		for (int i = 0; i < ecpTimeSeriesObj.size(); i++) {
			EcpStandardOffer ecpStandardOffer = new EcpStandardOffer();
			ecpStandardOffer.setBatch_id((Long) ecpTimeSeriesObj.get(i)[0]);
			ecpStandardOffer.setStart_time((Date) ecpTimeSeriesObj.get(i)[1]);
			ecpStandardOffer.setEcp_document_id(((Long) ecpTimeSeriesObj.get(i)[2]));
			ecpStandardOffer.setEcp_timeseries_id(((Long) ecpTimeSeriesObj.get(i)[3]));
			ecpStandardOffer.setEcpTimeSeries_Total(((Long) ecpTimeSeriesObj.get(i)[4]).intValue());
			ecpTimeSeries.add(ecpStandardOffer);
		}
		model.put("ecpTimeSeries", ecpTimeSeries);
		
		List<Object[]> ecpSeriesPeriodObj =  ecpMarketDocumentRepository.getEcpSeriesPeriod("topase", BatchStatus.COMPLETED.toString());
		
		for (int i = 0; i < ecpSeriesPeriodObj.size(); i++) {
			EcpStandardOffer ecpStandardOffer = new EcpStandardOffer();
			ecpStandardOffer.setBatch_id((Long) ecpSeriesPeriodObj.get(i)[0]);
			ecpStandardOffer.setStart_time((Date) ecpSeriesPeriodObj.get(i)[1]);
			ecpStandardOffer.setEcp_document_id(((Long) ecpSeriesPeriodObj.get(i)[2]));
			ecpStandardOffer.setEcp_timeseries_id((Long) ecpSeriesPeriodObj.get(i)[3]);
			ecpStandardOffer.setEcpseriesperiod_Total(((Long) ecpSeriesPeriodObj.get(i)[4]).intValue());
		//	ecpStandardOffer.setEcp_seriesperiod_id((Long) ecpSeriesPeriodObj.get(i)[4]);
		//	ecpStandardOffer.setEcp_point_Total(((Long) ecpSeriesPeriodObj.get(i)[5]).intValue());
			ecpSeriesPeriods.add(ecpStandardOffer);
		}
		model.put("ecpSeriesPeriods", ecpSeriesPeriods);
		
		List<Object[]> ecpPointObj =  ecpMarketDocumentRepository.getEcpPoint("topase", BatchStatus.COMPLETED.toString());

		for (int i = 0; i < ecpPointObj.size(); i++) {
			EcpStandardOffer ecpStandardOffer = new EcpStandardOffer();
			ecpStandardOffer.setBatch_id((Long) ecpPointObj.get(i)[0]);
			ecpStandardOffer.setStart_time((Date) ecpPointObj.get(i)[1]);
			ecpStandardOffer.setEcp_document_id(((Long) ecpPointObj.get(i)[2]));
			ecpStandardOffer.setEcp_timeseries_id((Long) ecpPointObj.get(i)[3]);
			ecpStandardOffer.setEcp_point_id((Long) ecpPointObj.get(i)[4]);
			ecpStandardOffer.setEcp_financialprice_Total(((Long) ecpPointObj.get(i)[5]).intValue());
			ecpSeriesPeriods.add(ecpStandardOffer);
		}
		model.put("ecpPoint", ecpPoint);
		
//		List<Object[]> ecpFinancialPriceObj =  ecpMarketDocumentRepository.getEcpFinancialPrice("topase", BatchStatus.COMPLETED.toString());
//
//		for (int i = 0; i < ecpSeriesPeriodObj.size(); i++) {
//			EcpStandardOffer ecpStandardOffer = new EcpStandardOffer();
//			ecpStandardOffer.setBatch_id((Long) ecpFinancialPriceObj.get(i)[0]);
//			ecpStandardOffer.setStart_time((Date) ecpFinancialPriceObj.get(i)[1]);
//			ecpStandardOffer.setEcp_document_id(((Long) ecpFinancialPriceObj.get(i)[2]));
//			ecpStandardOffer.setEcp_timeseries_id((Long) ecpFinancialPriceObj.get(i)[3]);
//			ecpStandardOffer.setEcp_point_id((Long) ecpPointObj.get(i)[4]);
//			ecpStandardOffer.setEcpseriesperiod_Total(((Long) ecpFinancialPriceObj.get(i)[4]).intValue());
//			ecpSeriesPeriod.add(ecpStandardOffer);
//		}
//		model.put("ecpFinancialPrice", ecpFinancialPrice);
		return "BOB-Reporting-welcome";
	}
}