/* WIEDZA
 * -----------------
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
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
