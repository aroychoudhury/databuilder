package org.abhishek.utilities.databuilder.build.impl;

import java.util.Random;

import org.abhishek.utilities.databuilder.build.AbstractBuilder;
import org.abhishek.utilities.databuilder.build.ctx.BuildContext;
import org.abhishek.utilities.databuilder.data.TextData;

public class TextBuilder extends AbstractBuilder {
    private String[][] textArraySelector = new String[][]{
        TextData.CHARACTERS_01, TextData.CHARACTERS_02, TextData.CHARACTERS_03, TextData.CHARACTERS_04,
        TextData.CHARACTERS_05, TextData.CHARACTERS_06, TextData.CHARACTERS_07, TextData.CHARACTERS_08,
        TextData.CHARACTERS_09, TextData.CHARACTERS_10
    };
    private Random random = new Random();

    public String getText() {
        return this.getTextWithChars(8);
    }

    public String getTextWithChars(final int character) {
        this.validateBetween(character, 1, textArraySelector.length);
        return _getText(character);
    }

    public String getTextLength20() {
        return this.capitalizeFirstLetter(this.getTextWithChars(2)) + " " + 
            this.getTextWithChars(7) + " " + 
            this.getTextWithChars(3) + " " + 
            this.getTextWithChars(4) + ".";
    }

    public String getTextLength50() {
        return this.getTextLength20() + " " +
            this.capitalizeFirstLetter(this.getTextWithChars(3)) + " " + 
            this.getTextWithChars(1) + " " + 
            this.getTextWithChars(7) + ", " + 
            this.getTextWithChars(3) + " " + 
            this.getTextWithChars(2) + " " + 
            this.getTextWithChars(6) + ".";
    }

    public String getTextLength100() {
        return this.getTextLength50() + " " +
            this.capitalizeFirstLetter(this.getTextWithChars(5)) + " " + 
            this.getTextWithChars(2) + " " +
            this.getTextWithChars(3) + " " + 
            this.getTextWithChars(10) + " " + 
            this.getTextWithChars(3) + " " + 
            this.getTextWithChars(5) + ". " + 
            this.capitalizeFirstLetter(this.getTextWithChars(3)) + " " + 
            this.getTextWithChars(2) + " " + 
            this.getTextWithChars(6) + ".";
    }

    private String _getText(final int character) {
        return textArraySelector[character - 1][random.nextInt(10)];
    }

    private String capitalizeFirstLetter(final String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    @Override
    public void constructContext(BuildContext context) {
        context.put("text", this.getText());
        context.put("textLen20", this.getTextLength20());
        context.put("textLen50", this.getTextLength50());
        context.put("textLen100", this.getTextLength100());
    }

    public static void main(String[] args) {
        TextBuilder parser = new TextBuilder();
        System.out.println(parser.getTextLength20().length());
        System.out.println(parser.getTextLength20());
        System.out.println(parser.getTextLength100());
        System.out.println(parser.getTextLength100());
        System.out.println(parser.getTextLength100());
        System.out.println(parser.getTextLength100());
        System.out.println(parser.getTextLength100());
        System.out.println(parser.getTextLength100());
        System.out.println(parser.getTextLength100());
        System.out.println(parser.getTextLength100());
        System.out.println(parser.getTextLength100());
        System.out.println(parser.getTextLength100());
        System.out.println(parser.getTextLength100());
    }
}
