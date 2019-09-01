package com.practice;

import org.tempuri.Converter;
import org.tempuri.ConverterSoap;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

public class CurrencyConverterClient {

	public static void main(String[] args) throws DatatypeConfigurationException {
		
		Converter converter = new Converter();
		ConverterSoap converterSoap = converter.getConverterSoap();
		LocalDate today = LocalDate.now();
		//System.out.println(today);
		final GregorianCalendar gc = new GregorianCalendar(today.getYear(),today.getMonthValue()-1,today.getDayOfMonth());//jan is 0
		XMLGregorianCalendar xmlGC = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		String rateDate = xmlGC.getYear()  + "-"+
		                  xmlGC.getMonth() + "-"+
				          xmlGC.getDay();
		System.out.println(rateDate);
		/*
		BindingProvider bp = (BindingProvider)converterSoap;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8090/converter.asmx");
		*/
		BigDecimal rate = converterSoap.getConversionRate("USD", "EUR", xmlGC);
		System.out.println(rate);
		
	}

}