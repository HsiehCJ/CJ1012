package tw.com.fcb.mimosa.examples.gettingstarted;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tw.com.fcb.mimosa.http.APIErrorException;
import tw.com.fcb.mimosa.http.APIErrorT9nException;
import tw.com.fcb.mimosa.tracing.Traced;

@Traced
@AllArgsConstructor
@Service
public class ErrorService {

	final ErrorRepository errrepository;
	
	public ErrorCode getByCode(String code) {
		
	   	 return errrepository.findByCode(code)
	   			 .orElseThrow(() -> {
	   			 return new APIErrorException(err -> err.code("ERR").message("msg not found"));
	   			 });
	    }

	
	public ErrorCode createErrCode(ErrorCode code) {
		return errrepository.save(createErrCode(code));
	}
	
	
}