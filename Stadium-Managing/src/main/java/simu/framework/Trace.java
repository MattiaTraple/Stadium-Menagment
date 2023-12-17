package simu.framework;

/**
 * The Trace class provides a simple mechanism for logging messages at different levels.
 * It supports logging at INFO, WARNING (WAR), and ERROR (ERR) levels.
 */
public class Trace {

    /**
     * Enumeration representing different logging levels: INFO, WARNING (WAR), and ERROR (ERR).
     */
    public enum Level {INFO, WAR, ERR}

    private static Level traceLevel;

    /**
     * Sets the global logging level for the Trace class.
     *
     * @param lvl The desired logging level.
     */
    public static void setTraceLevel(Level lvl) {
        traceLevel = lvl;
    }

    /**
     * Outputs a log message at the specified level if the level is greater than or equal
     * to the global logging level.
     *
     * @param lvl The logging level of the message.
     * @param txt The text message to be logged.
     */
    public static void out(Level lvl, String txt) {
        if (lvl.ordinal() >= traceLevel.ordinal()) {
            System.out.println(txt);
        }
    }
}
