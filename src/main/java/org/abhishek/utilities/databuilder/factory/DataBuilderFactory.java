/* Copyright 2016 Roychoudhury, Abhishek */

package org.abhishek.utilities.databuilder.factory;

import java.util.HashMap;
import java.util.Map;

import org.abhishek.utilities.databuilder.build.AbstractBuilder;
import org.abhishek.utilities.databuilder.build.ctx.BuildContext;
import org.abhishek.utilities.databuilder.build.impl.CountryBuilder;
import org.abhishek.utilities.databuilder.build.impl.DateTimeBuilder;
import org.abhishek.utilities.databuilder.build.impl.GeneralBuilder;
import org.abhishek.utilities.databuilder.build.impl.NumberBuilder;
import org.abhishek.utilities.databuilder.build.impl.PersonBuilder;
import org.abhishek.utilities.databuilder.build.impl.TextBuilder;
import org.abhishek.utilities.databuilder.build.impl.USAddressBuilder;
import org.abhishek.utilities.databuilder.build.impl.USStateBuilder;

/**
 * @author abhishek
 * @since 1.0
 */
public class DataBuilderFactory {
    // create an object of SingleObject
    private static DataBuilderFactory instance = new DataBuilderFactory();

    private static Map<String, AbstractBuilder> builders;

    // make the constructor private so that this class cannot be instantiated
    private DataBuilderFactory() {
        builders = new HashMap<String, AbstractBuilder>();

        // default registers
        registerBuilder(new TextBuilder());
        registerBuilder(new NumberBuilder());
        registerBuilder(new DateTimeBuilder());
        registerBuilder(new PersonBuilder());
        registerBuilder(new GeneralBuilder());
        registerBuilder(new CountryBuilder());
        registerBuilder(new USStateBuilder());
        registerBuilder(new USAddressBuilder());
    }

    public static void registerBuilder(AbstractBuilder builder) {
        builders.put(builder.getClass().getSimpleName().toLowerCase(), builder);
    }

    //Get the only object available
    public static DataBuilderFactory getInstance() {
       return instance;
    }

    public BuildContext buildContext() {
        BuildContext context = new BuildContext();
        for (AbstractBuilder builder : builders.values()) {
            builder.constructContext(context);
        }
        System.out.println(context.toString());
        return context; 
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("DataBuilderFactory is a singleton class and cannot be cloned");
    }

    public static void main(String[] args) {
        DataBuilderFactory.getInstance().buildContext();
    }
}
