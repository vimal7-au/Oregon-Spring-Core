package  com.nike.oregon.spring.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by VRadh1 on 1/22/2017.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.FORBIDDEN.value());
        error.setMessage("Please Contact Sydney Cruises Administrator");
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }


    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<ErrorResponse>  handleConflict() {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NO_CONTENT.value());
        error.setMessage("There are no Service found for the requested parameters");
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }
}
