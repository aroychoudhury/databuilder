package org.abhishek.utilities.databuilder.build.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.abhishek.utilities.databuilder.build.AbstractBuilder;
import org.abhishek.utilities.databuilder.build.ctx.BuildContext;
import org.abhishek.utilities.databuilder.data.GeographicalData;

public class USStateBuilder extends AbstractBuilder {
    private Random random = new Random();

    public StateData getState() {
        return this.parseState(
            GeographicalData.US_STATES_AND_CAPITALS[random.nextInt(GeographicalData.US_STATES_AND_CAPITALS.length)]);
    }

    public StateData getState(final String criteria) {
        StateData[] stateData = this.getStatesExact(criteria);
        if (1 < stateData.length) {
            throw new IllegalArgumentException("State criteria matches multiple entries for: " + criteria);
        }
        return stateData[0];
    }

    public StateData[] getStates(final String criteria) {
        return this._findStates(this.validateEmptyString(criteria));
    }

    public StateData[] getStatesExact(final String criteria) {
        return this._findStates("|" + this.validateEmptyString(criteria) + "|");
    }

    private StateData[] _findStates(final String state) {
        List<StateData> states = new ArrayList<StateData>();
        for (String addressInfo : GeographicalData.US_STATES_AND_CAPITALS) {
            if (-1 != addressInfo.toLowerCase().indexOf(state.toLowerCase())) {
                states.add(this.parseState(addressInfo));
            }
        }
        if (states.isEmpty()) {
            throw new IllegalArgumentException("No information found for: " + state);
        }
        return states.toArray(new StateData[states.size()]);
    }

    public StateData parseState(final String stateInfo) {
        String[] stateInfoArr = stateInfo.split("\\|");

        StateData stateData = new StateData();
        stateData.state = stateInfoArr[1];
        stateData.stateCode = stateInfoArr[2];
        stateData.capital = stateInfoArr[3];

        return stateData;
    }

    class StateData {
        public String state;
        public String stateCode;
        public String capital;

        @Override
        public String toString() {
            return state
                + " : "
                + stateCode
                + " : "
                + capital;
        }
    }

    @Override
    public void constructContext(BuildContext context) {
        StateData stateData = this.getState();

        context.put("state", stateData.state);
        context.put("stateCode", stateData.stateCode);
        context.put("stateCapital", stateData.capital);
    }

    public static void main(String[] args) {
        USStateBuilder parser = new USStateBuilder();
        System.out.println(parser.getState("NY"));
        System.out.println("----------------");
        for (StateData address : parser.getStates("new")) {
            System.out.println(address);
        }
    }
}
