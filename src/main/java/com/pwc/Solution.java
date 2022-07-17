package com.pwc;

import java.util.Scanner;

import static com.pwc.Constants.*;

public class Solution {
    private String currentStatus = "UNKNOW";
    private double priviousTemperature = 0;
    private double currentTemperature = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextLine()) {
                try {
                    Double aDouble = Utils.parseConsoleLine(scanner);
                    Utils.echo(aDouble);

                    solution.setTemperature(aDouble);
                    if (!solution.isFluctuating()) {
                        solution.alert();
                    }
                } catch (NumberFormatException nfe) {
                    System.err.println(nfe);
                }
            }
        }
    }

    private void setTemperature(double temperature) {
        double currTemperature = getCurrentTemperature();
        setPriviousTemperature(currTemperature);
        setCurrentTemperature(temperature);
    }

    private void alert() {
        double privTemperature = getPriviousTemperature();
        double curTemperature = getCurrentTemperature();

        if (privTemperature < BOILING_THRESHOLDS &&
                curTemperature >= BOILING_THRESHOLDS) {
            Utils.echoStatus(BOILING);
            setCurrentStatus(BOILING);
        }

        if (privTemperature > BOILING_THRESHOLDS &&
                curTemperature <= BOILING_THRESHOLDS) {
            Utils.echoStatus(UNBOILING);
            setCurrentStatus(UNBOILING);
        }

        if (privTemperature > FREEZING_THRESHOLDS &&
                curTemperature <= FREEZING_THRESHOLDS) {
            Utils.echoStatus(FREEZING);
            setCurrentStatus(FREEZING);
        }

        if (privTemperature < FREEZING_THRESHOLDS &&
                curTemperature >= FREEZING_THRESHOLDS) {
            Utils.echoStatus(UNFREEZING);
            setCurrentStatus(UNFREEZING);
        }
    }

    private boolean isFluctuating() {
        boolean fluctuating = false;

        double privTemperature = getPriviousTemperature();
        double curTemperature = getCurrentTemperature();

        if (getCurrentStatus() == FREEZING) {
            if (curTemperature <= UNFREEZING_THRESHOLDS) {
                fluctuating = true;
                setCurrentTemperature(privTemperature); // ignore currnet Temperature
            }
        }

        if (getCurrentStatus() == BOILING) {
            if (curTemperature >= UNBOILING_THRESHOLDS) {
                fluctuating = true;
                setCurrentTemperature(privTemperature); // ignore currnet Temperature
            }
        }

        return fluctuating;
    }


    /**
     * setter && getter
     */
    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public double getPriviousTemperature() {
        return priviousTemperature;
    }

    public void setPriviousTemperature(double priviousTemperature) {
        this.priviousTemperature = priviousTemperature;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }
}