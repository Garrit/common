package org.garrit.common.statuses;

/**
 * Each service provides one or more capabilities. This enum permits services to
 * programmatically identify their capabilities.
 *
 * @author Samuel Coleman <samuel@seenet.ca>
 * @since 1.0.0
 */
public enum CapabilityType
{
    EXECUTOR("executor"),
    JUDGE("judge"),
    REPORTER("reporter"),
    NEGOTIATOR("negotiator");

    public static final int SIZE = CapabilityType.values().length;

    private String name;

    private CapabilityType(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}