package cc.aisc.logistics.rest.exception;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by sjf on 16-5-10.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public ResponseEntity<String> sqlExceptionHandler(){
        return ResponseEntity.ok("sql exception");
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> noSuchElementExceptionHandler(NoSuchElementException e){
        LOGGER.error("NoSuchElementException, message = {}", e.getMessage());
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DatabindingException.class)
    public ResponseEntity<Map<String, List<String>>> dataBindingExceptionHandler(DataBindingException e){
        LOGGER.error("DataBindingException, message = {}", e.getMessage());
        return new ResponseEntity<Map<String, List<String>>>(e.getFieldErrors(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /*
        @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)

    @ExceptionHandler(ServerRejectException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)

        @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)

        @ExceptionHandler(SystemException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)

        @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
     */

    /*private ExceptionModel getExceptionModel(HttpStatus httpStatus,
                                             CommonException ex) {
        ExceptionModel exceptionModel = new ExceptionModel();
        ErrorENUM errorEnum = ex.getErrorEnum();
        exceptionModel.setStatus(httpStatus.value());
        exceptionModel.setMoreInfo(ex.getMoreInfo());
        if (errorEnum != null) {
            exceptionModel.setErrorCode(errorEnum.getCode());
            exceptionModel.setMessage(errorEnum.toString());
        }
        return exceptionModel;
    }

    private void handleLog(HttpServletRequest request, Exception ex) {
        Map parameter = request.getParameterMap();
        StringBuffer logBuffer = new StringBuffer();
        if (request != null) {
            logBuffer.append("  request method=" + request.getMethod());
            logBuffer.append("  url=" + request.getRequestURL());
        }
        if (ex instanceof CommonException) {
            logBuffer.append("  moreInfo="
                    + ((CommonException) ex).getMoreInfo());
        }
        if (ex != null) {
            logBuffer.append("  exception:" + ex);
        }
        logger.error(logBuffer.toString());
    }*/
}
