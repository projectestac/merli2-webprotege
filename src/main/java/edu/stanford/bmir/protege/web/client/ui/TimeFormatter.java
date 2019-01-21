package edu.stanford.bmir.protege.web.client.ui;

import java.util.Date;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.shared.DateTimeFormat;
import edu.stanford.bmir.protege.web.shared.TimeUtil;


/**
 * Utility methods to convert dates to strings on the client.
 *
 * This implementation delegates the actual conversions to the shared
 * {@code TimeUtil} class.This is provided to make it easy for external
 * modules to overwrite the default implementation (i.e. for
 * internationalization purposes).
 */
public class TimeFormatter {

    /** Instance of this interface */
    private static final TimeFormatter INSTANCE =
        GWT.create(TimeFormatter.class);


    /** Protects the instantiation of this class */
    protected TimeFormatter() {}


    /**
     * Returns an instance of this class.
     *
     * @return              A singleton
     */
    public static final TimeFormatter get() {
        return TimeFormatter.INSTANCE;
    }


    /**
     * Converts the given timestamp to a human-readable time string.
     * Returns a time-ago string if the time stamp is within the current
     * month; otherwise returns a short date string representation.
     *
     * @param timestamp     Unix timestamp
     * @return              Localized string
     */
    public String toTimeAgo(long timestamp) {
        return TimeUtil.getTimeRendering(timestamp);
    }


    /**
     * Converts the given date to a locale aware human-readable date
     * string without the time part.
     *
     * @param date          Date object
     * @return              Localized string
     */
    public String toFullDate(Date date) {
        return DateTimeFormat.getFormat("EEE, d MMM yyyy")
            .format(date instanceof Date ? date : new Date());
    }

}
