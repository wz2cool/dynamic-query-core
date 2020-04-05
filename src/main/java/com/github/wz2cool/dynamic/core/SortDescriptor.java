package com.github.wz2cool.dynamic.core;

/**
 * The type Sort descriptor.
 *
 * @author Frank
 */
public class SortDescriptor implements ISortDescriptor {
    private String propertyName;
    private SortDirection direction = SortDirection.ASC;

    /**
     * Instantiates a new Sort descriptor.
     */
    public SortDescriptor() {
        // create a empty instance.
    }

    /**
     * Instantiates a new Sort descriptor.
     *
     * @param propertyName the property path
     * @param direction    the sort direction
     */
    public SortDescriptor(String propertyName, SortDirection direction) {
        this.propertyName = propertyName;
        this.direction = direction;
    }


    /**
     * Gets property path.
     *
     * @return the property path
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets property path.
     *
     * @param propertyName the property path
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Gets sort direction.
     *
     * @return the sort direction
     */
    public SortDirection getDirection() {
        return direction;
    }

    /**
     * Sets sort direction.
     *
     * @param direction the sort direction
     */
    public void setDirection(SortDirection direction) {
        this.direction = direction;
    }
}
