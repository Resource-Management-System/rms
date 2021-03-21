package callum.project.uni.rms.parent.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
@Slf4j
public class InternalServiceException extends RuntimeException {

    public InternalServiceException(String message, Throwable cause){
        super(message, cause);
        log.error(message);
    }
}
