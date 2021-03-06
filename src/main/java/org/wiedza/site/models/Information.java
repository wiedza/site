/* WIEDZA
 * -----------------
 * Apache License
 * Version 2.0, January 2004
 * http://www.apache.org/licenses/
 */
package org.wiedza.site.models;

/**
 * Information
 * 
 * @author patrickguillerm
 * @since 27 févr. 2018
 */
public class Information {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private String title;
    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================

    public Information(String title) {
        super();
        this.title = title;
    }

    // =========================================================================
    // OVERRIDES
    // =========================================================================
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName());
        builder.append('@');
        builder.append(System.identityHashCode(this));
        builder.append("[title=");
        builder.append(title);
        builder.append("]");
        return builder.toString();
    }
    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================
    public String getTitle() {
        return title;
    }

 

    public void setTitle(String title) {
        this.title = title;
    }

}
