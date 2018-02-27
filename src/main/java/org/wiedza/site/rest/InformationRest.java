package org.wiedza.site.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.wiedza.site.models.Information;

/**
 * Information
 * @author patrickguillerm
 * @since 27 févr. 2018
 */
@Path("information")
public class InformationRest {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================

    // =========================================================================
    // METHODS
    // =========================================================================
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Information get() {
        return new Information("Test"); 
    }
    
}
