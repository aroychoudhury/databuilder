package org.abhishek.utilities.databuilder.build.impl;

import java.util.Random;

import org.abhishek.utilities.databuilder.build.AbstractBuilder;
import org.abhishek.utilities.databuilder.build.ctx.BuildContext;

public class NumberBuilder extends AbstractBuilder {
    private int[] digitsMultiplier = new int[]{
        1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000
    };
    private Random random = new Random();

    public int getInteger() {
        return this.getIntegerWithDigits(5);
    }

    public String getIntegerAsString() {
        return Integer.toString(this.getInteger());
    }

    public int getIntegerWithDigits(final int digits) {
        this.validateBetween(digits, 1, digitsMultiplier.length);
        return digitsMultiplier[(digits - 1)] 
                + random.nextInt(9 * digitsMultiplier[digits - 1]);
    }

    public String getIntegerWithDigitsAsString(final int digits) {
        return Integer.toString(this.getIntegerWithDigits(digits));
    }

    public long getLong() {
        return Integer.valueOf(this.getInteger()).longValue();
    }

    public String getLongAsString() {
        return Long.toString(this.getLong());
    }

    public long getLongWithDigits(final int digits) {
        return Integer.valueOf(this.getIntegerWithDigits(digits)).longValue();
    }

    public String getLongWithDigitsAsString(final int digits) {
        return Long.toString(this.getLongWithDigits(digits));
    }

    public double getDouble() {
        return (double) this.getInteger();
    }

    public String getDoubleAsString() {
        return Double.toString(this.getDouble());
    }

    public double getDoubleWithDigits(final int digits) {
        return (double) this.getIntegerWithDigits(digits);
    }

    public String getDoubleWithDigitsAsString(final int digits) {
        return Double.toString(this.getDoubleWithDigits(digits));
    }

    public int parseInteger(final String number) {
        try {
            return Integer.parseInt(this.validateEmptyString(number));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not a number", e);
        }
    }

    @Override
    public void constructContext(BuildContext context) {
        context.put("int", this.getInteger());
        context.put("long", this.getLong());
        context.put("double", this.getDouble());
    }

    public static void main(String[] args) {
        NumberBuilder parser = new NumberBuilder();
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
        System.out.println(parser.getLong());
    }
}
