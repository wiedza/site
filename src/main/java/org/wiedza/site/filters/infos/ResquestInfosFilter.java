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

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.wiedza.site.tools.Chrono;
import org.wiedza.site.tools.Loggers;

/**
 * ResquestInfosFilter
 * 
 * @author patrickguillerm
 * @since 1 mars 2018
 */
@WebFilter(urlPatterns = "/rest/*")
public class ResquestInfosFilter implements Filter {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================

    // =========================================================================
    // METHODS
    // =========================================================================
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        RequestInfosContext.build((HttpServletRequest) request);
        try {
            chain.doFilter(request, response);
        } catch (IOException | ServletException e) {
            throw e;
        } finally {
            RequestInfosContext.currentInstance().stopChrono();
            Loggers.DEBUGLOG.info("chrono : {}",RequestInfosContext.currentInstance().getChrono());
        }

    }
    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
}
