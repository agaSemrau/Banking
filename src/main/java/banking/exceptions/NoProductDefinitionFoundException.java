package banking.exceptions;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Resource
public class NoProductDefinitionFoundException extends RuntimeException{
    public NoProductDefinitionFoundException(String message) {
        super(message);
    }


}
