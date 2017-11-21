package cc.lasmgratel.opensimcity.api.event;

/**
 * Various result type
 */
public enum ResultType {
    /**
     * Return as default value passed.
     */
    PASS,

    /**
     * Return as allowed.
     * Example: an animation when right-clicked.
     */
    ALLOW,

    /**
     * Return as denied.
     * Example: no action on fired.
     */
    DENY
}
