package org.abhishek.utilities.databuilder.build.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.abhishek.utilities.databuilder.build.AbstractBuilder;
import org.abhishek.utilities.databuilder.build.ctx.BuildContext;
import org.abhishek.utilities.databuilder.data.GeographicalData;

public class USAddressBuilder extends AbstractBuilder {
    private Random random = new Random();

    public AddressData getAddress() {
        return this.parseAddress(
            GeographicalData.US_ADDRESSES[random.nextInt(GeographicalData.US_ADDRESSES.length)]);
    }

    public AddressData getAddress(final String criteria) {
        AddressData[] addressData = this.getAddresses(criteria);
        if (1 < addressData.length) {
            throw new IllegalArgumentException("Address criteria matches multiple entries for: " + criteria);
        }
        return addressData[0];
    }

    public AddressData[] getAddresses(final String criteria) {
        return this._findAddresses(this.validateEmptyString(criteria));
    }

    public AddressData[] getAddressesExact(final String criteria) {
        return this._findAddresses("|" + this.validateEmptyString(criteria) + "|");
    }

    private AddressData[] _findAddresses(final String address) {
        List<AddressData> addresses = new ArrayList<AddressData>();
        for (String addressInfo : GeographicalData.US_ADDRESSES) {
            if (-1 != addressInfo.toLowerCase().indexOf(address.toLowerCase())) {
                addresses.add(this.parseAddress(addressInfo));
            }
        }
        if (addresses.isEmpty()) {
            throw new IllegalArgumentException("No information found for: " + address);
        }
        return addresses.toArray(new AddressData[addresses.size()]);
    }

    public AddressData parseAddress(final String addressInfo) {
        String[] addressInfoArr = addressInfo.split("\\|");

        AddressData addressData = new AddressData();
        addressData.city = addressInfoArr[1];
        addressData.state = addressInfoArr[2];
        addressData.stateCode = addressInfoArr[3];
        addressData.address = addressInfoArr[4];
        addressData.pincode = addressInfoArr[5];
        addressData.intPincode = Integer.parseInt(addressInfoArr[5]);

        return addressData;
    }

    class AddressData {
        public String city;
        public String state;
        public String stateCode;
        public String address;
        public String pincode;
        public int intPincode;

        @Override
        public String toString() {
            return city
                + " [ "
                + state
                + ", "
                + stateCode
                + " ] : "
                + address
                + " : pin=[ "
                + pincode
                + ", "
                + intPincode
                + " ]";
        }
    }

    @Override
    public void constructContext(BuildContext context) {
        AddressData addressData = this.getAddress();

        context.put("address", addressData.address);
        context.put("city", addressData.city);
        context.put("pincode", addressData.intPincode);
        context.put("state", addressData.state);
        context.put("stateCode", addressData.stateCode);
    }

    public static void main(String[] args) {
        USAddressBuilder parser = new USAddressBuilder();
        System.out.println(parser.getAddress());
        for (AddressData address : parser.getAddressesExact("new york")) {
            System.out.println(address);
        }
        for (AddressData address : parser.getAddresses("new")) {
            System.out.println(address);
        }
    }
}
