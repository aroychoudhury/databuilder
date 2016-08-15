package org.abhishek.utilities.databuilder.build.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.abhishek.utilities.databuilder.build.AbstractBuilder;
import org.abhishek.utilities.databuilder.build.ctx.BuildContext;
import org.abhishek.utilities.databuilder.data.GeographicalData;

public class CountryBuilder extends AbstractBuilder {
    private Random random = new Random();

    public CountryData getUSA() {
        return this.getCountry("United States of America");
    }

    public CountryData getCountry() {
        return this.parseCountry(
            GeographicalData.COUNTRIES[random.nextInt(GeographicalData.COUNTRIES.length)]);
    }

    public CountryData getCountry(final String country) {
        CountryData[] countryData = this.getCountriesExact(country);
        if (1 < countryData.length) {
            throw new IllegalArgumentException("Country criteria matches multiple entries for: " + country);
        }
        return countryData[0];
    }

    public CountryData[] getCountries(final String criteria) {
        return this._findCountries(this.validateEmptyString(criteria));
    }

    public CountryData[] getCountriesExact(final String criteria) {
        return this._findCountries("|" + this.validateEmptyString(criteria) + "|");
    }

    private CountryData[] _findCountries(final String country) {
        List<CountryData> countries = new ArrayList<CountryData>();
        for (String countryInfo : GeographicalData.COUNTRIES) {
            if (-1 != countryInfo.toLowerCase().indexOf(country.toLowerCase())) {
                countries.add(this.parseCountry(countryInfo));
            }
        }
        if (countries.isEmpty()) {
            throw new IllegalArgumentException("No information found for: " + country);
        }
        return countries.toArray(new CountryData[countries.size()]);
    }

    public CountryData parseCountry(final String countryInfo) {
        String[] countryInfoArr = countryInfo.split("\\|");

        CountryData countryData = new CountryData();
        countryData.country = countryInfoArr[1];
        countryData.code = countryInfoArr[3];
        countryData.code2Char = countryInfoArr[2];
        countryData.isdCode = countryInfoArr[4];
        countryData.currency = countryInfoArr[6];
        countryData.currencyCode = countryInfoArr[5];
        countryData.capital = countryInfoArr[7];
        countryData.webDomain = countryInfoArr[8];

        return countryData;
    }

    class CountryData {
        public String country;
        public String code;
        public String code2Char;
        public String isdCode;
        public String currency;
        public String currencyCode;
        public String capital;
        public String webDomain;

        @Override
        public String toString() {
            return country
                + " [ "
                + code
                + ", "
                + code2Char
                + " ] : isd="
                + isdCode
                + " : pincode=[ "
                + currency
                + ", "
                + currencyCode
                + " ] : capital="
                + capital
                + " ( "
                + webDomain
                + " )";
        }
    }

    @Override
    public void constructContext(BuildContext context) {
        CountryData usaData = this.getUSA();
        CountryData intlData = this.getCountry();

        context.put("country", usaData.country);
        context.put("countryCode", usaData.code);
        context.put("countryIntl", intlData.country);
        context.put("countryCodeIntl", intlData.code);
    }

    public static void main(String[] args) {
        CountryBuilder parser = new CountryBuilder();
        System.out.println(parser.getCountry());
        System.out.println(parser.getUSA());
        for (CountryData country : parser.getCountries("st.")) {
            System.out.println(country);
        }
    }
}
