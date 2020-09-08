package healthcare.carta.interview.restcsv.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import healthcare.carta.interview.restcsv.exception.ErrorResponse;
import healthcare.carta.interview.restcsv.exception.RecordNotFoundException;

@Service
public class CartaService {

	public int calculateNumberAvg() throws Exception {

		int sum = 0;
		int colCount = 0;
		int average = 0;
		try {
			Resource resource = new ClassPathResource("data.csv");
			BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
			String line;
			while ((line = br.readLine()) != null) {
				String[] cols = line.split(",");
				if (colCount > 0) {
					int numberVal = Integer.parseInt(cols[1]);
					sum += numberVal;
					average = sum / colCount;

				}
				colCount++;
			}
		} catch (FileNotFoundException e) {
			ErrorResponse errorResponse = new ErrorResponse("\"File not found at a given path", null);
			throw new RecordNotFoundException(errorResponse);
		}

		return average;

	}

}
