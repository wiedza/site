/* WIEDZA
 * -----------------
 * Apache License
 * Version 2.0, January 2004
 * http://www.apache.org/licenses/
 */
package org.wiedza.site.filters.infos;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.wiedza.site.tools.Chrono;

/**
 * ResquestInfos
 * 
 * @author patrickguillerm
 * @since 1 mars 2018
 */
public class ResquestInfos {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private final String service;

    private final String correlationId;

    private final String requestId;

    private final Chrono chrono;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    public ResquestInfos(HttpServletRequest request) {
        this.service = request.getRequestURI().substring(request.getContextPath().length());
        correlationId = UUID.randomUUID().toString();
        requestId = UUID.randomUUID().toString();
        chrono = Chrono.startChrono();
    }

    // =========================================================================
    // OVERRIDES
    // =========================================================================
    /* package */void stopChrono() {
        this.chrono.stop();
    }

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
    public String getService() {
        return service;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public String getRequestId() {
        return requestId;
    }

    public Chrono getChrono() {
        return chrono.clone();
    }

}
