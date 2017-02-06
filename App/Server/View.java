package Server;

/**
 * Meer informatie over views:
 * http://www.baeldung.com/jackson-json-view-annotation
 *
 * @author Peter van Vliet <peter@actorius.nl>
 * @since 1.0
 */
public class View
{
    /**
     * The type Internal.
     */
    public static class Internal extends Private {}

    /**
     * The type Private.
     */
    public static class Private extends Protected {}

    /**
     * The type Protected.
     */
    public static class Protected extends Public {}

    /**
     * The type Public.
     */
    public static class Public {}
}
