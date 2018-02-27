package org.wiedza.site.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.wiedza.site.tools.Loggers;


/**
 * ExceptionHandler
 * @author patrickguillerm
 * @since 27 févr. 2018
 */
@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {
    
    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    
    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
 
    
    // =========================================================================
    // METHODS
    // =========================================================================
    
    @Override
    public Response toResponse(Exception error) {
        //TODO
        Loggers.DEBUGLOG.error(error.getMessage(), error);
        return Response.status(500).entity(error.getMessage()).build();
    }
    
}
