/* Copyright 2016 Roychoudhury, Abhishek */

package org.abhishek.utilities.databuilder.build;

import org.abhishek.utilities.databuilder.build.ctx.BuildContext;



/**
 * @author abhishek
 * @since 1.0
 */
public abstract class AbstractBuilder {
    public abstract void constructContext(BuildContext context);

    /* ************* Utility Methods ************* */
    protected int validateNonNegative(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Input cannot be zero or negative");
        }
        return number;
    }

    protected int validateBetween(final int number, final int min, final int max) {
        this.validateNonNegative(number);
        if (!(min <= number && number <= max)) {
            throw new IllegalArgumentException(
                String.format("Input not within limits (min=%d, max=%d)", min, max));
        }
        return number;
    }

    protected String validateEmptyString(final String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        return text.trim();
    }

    protected boolean validateMinMax(final int min, final int max) {
        if (min < 0) {
            throw new IllegalArgumentException("Min must be a non-negative number");
        }

        if (max < 0) {
            throw new IllegalArgumentException("Max must be a non-negative number");
        }

        if (max < min) {
            throw new IllegalArgumentException(
                String.format("Min must be less than max (min=%d, max=%d)", min, max));
        }

        return true;
    }
}
