package healthcare.carta.interview.restcsv.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import healthcare.carta.interview.restcsv.model.ResponseData;
import healthcare.carta.interview.restcsv.service.CartaService;

@RestController
public class CartaController {

	@Autowired
	private CartaService cartaService;
	
	@RequestMapping(value="/getNumberAverage",method=RequestMethod.GET)
	public ResponseData getNumberAverage() throws Exception{
		int numberAverage = cartaService.calculateNumberAvg();
		ResponseData responseData=new ResponseData();
		responseData.setData(numberAverage);
		return responseData;
		
	}
}
