package org.abhishek.utilities.databuilder.build.impl;

import java.util.Random;

import org.abhishek.utilities.databuilder.build.AbstractBuilder;
import org.abhishek.utilities.databuilder.build.ctx.BuildContext;
import org.abhishek.utilities.databuilder.data.PersonData;

public class PersonBuilder extends AbstractBuilder {
    private Random random = new Random();

    public String getGender() {
        return PersonData.GENDER[random.nextInt(PersonData.GENDER.length)];
    }

    public String getGenderCharacter() {
        return this.getGender().substring(0, 1);
    }

    public String getSSN() {
        return PersonData.SSN[random.nextInt(PersonData.SSN.length)];
    }

    public String getPhone() {
        return PersonData.PHONE[random.nextInt(PersonData.PHONE.length)];
    }

    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getPrefixedName() {
        return PersonData.PREFIX[random.nextInt(PersonData.PREFIX.length)]
                + ". " + this.getFirstName() + " " + this.getLastName();
    }

    public String getSuffixedName() {
        return this.getFirstName() + " " + this.getLastName()
                + " " + PersonData.SUFFIX[random.nextInt(PersonData.SUFFIX.length)];
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getMiddleInitial() + ". " + this.getLastName();
    }

    public String getFirstName() {
        return PersonData.FIRST_NAMES[random.nextInt(PersonData.FIRST_NAMES.length)];
    }

    public String getLastName() {
        return PersonData.LAST_NAMES[random.nextInt(PersonData.LAST_NAMES.length)];
    }

    public String getMiddleInitial() {
        return PersonData.MIDDLE_INITIALS[random.nextInt(PersonData.MIDDLE_INITIALS.length)];
    }

    @Override
    public void constructContext(BuildContext context) {
        context.put("fullName", this.getFullName());
        context.put("prefixedName", this.getPrefixedName());
        context.put("suffixedName", this.getSuffixedName());
        context.put("ssn", this.getSSN());
        context.put("gender", this.getGender());
        context.put("genderChar", this.getGenderCharacter());
        context.put("phone", this.getPhone());
    }

    public static void main(String[] args) {
        PersonBuilder parser = new PersonBuilder();
        System.out.println(parser.getFullName());
        System.out.println(parser.getPrefixedName());
        System.out.println(parser.getSuffixedName());
        System.out.println(parser.getSSN());
        System.out.println(parser.getGender());
        System.out.println(parser.getGenderCharacter());
        System.out.println(parser.getPhone());
    }
}
