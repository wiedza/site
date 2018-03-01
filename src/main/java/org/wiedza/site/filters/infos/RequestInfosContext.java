/* WIEDZA
 * -----------------
 * GNU GENERAL PUBLIC LICENSE
 *  Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package org.wiedza.site.filters.infos;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.wiedza.site.tools.Chrono;

/**
 * RequestInfosContext
 * 
 * @author patrickguillerm
 * @since 1 mars 2018
 */
public class RequestInfosContext {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static ThreadLocal<RequestInfosContext> localThreadCxt = new ThreadLocal<>();

    private final ResquestInfos                     infos;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    /* package */ static void build(HttpServletRequest request) {
        final RequestInfosContext instance = new RequestInfosContext(request);
        localThreadCxt.set(instance);
    }

    private RequestInfosContext(HttpServletRequest request) {
        infos = new ResquestInfos(request);
        initializeMdc();

    }

    public static RequestInfosContext currentInstance() {
        RequestInfosContext result = localThreadCxt.get();
        if (result == null) {
            build(null);
            result = localThreadCxt.get();
        }
        return result;
    }
    // =========================================================================
    // METHODS
    // =========================================================================
    /* package */void stopChrono() {
        this.infos.stopChrono();
    }

    // =========================================================================
    // MDC
    // =========================================================================
    private void initializeMdc() {

        setMdc("service", infos.getService());
        setMdc("correlationId", infos.getCorrelationId());
        setMdc("requestId", infos.getRequestId());
    }

    // =========================================================================
    // TOOLS
    // =========================================================================
    private void setMdc(String key, Object value) {
        if (value != null) {
            MDC.put(key, String.valueOf(value));
        }
    }

    // =========================================================================
    // GETTERS
    // =========================================================================
    public ResquestInfos getInfos() {
        return infos;
    }

    public String getCorrelationId() {
        return infos.getCorrelationId();
    }

    public String getRequestId() {
        return infos.getRequestId();
    }

    public Chrono getChrono() {
        return infos.getChrono();
    }

}
