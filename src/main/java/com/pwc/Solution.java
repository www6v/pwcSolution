package com.pwc;

import java.util.Scanner;

import static com.pwc.Constants.*;
import static com.pwc.Utils.*;

public class Solution {
    private String currentStatus = "UNKNOW";
    private double priviousTemperature = 0;
    private double currentTemperature = 0;

    public static void main(String[] args) {
        echoActions();

        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextLine()) {
                try {
                    Double aDouble = parseConsoleLine(scanner);
                    echoNum(aDouble);

                    solution.setTemperature(aDouble);
                    if (!solution.isFluctuating()) {
                        solution.alert();
                    }
                } catch (NumberFormatException nfe) {
                    System.err.println("Please enter a num.");
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

        alertFreeze(privTemperature, curTemperature);

        alertBoiling(privTemperature, curTemperature);
    }

    private void alertFreeze(double privTemperature, double curTemperature) {
        if (privTemperature > FREEZING_THRESHOLDS &&
                curTemperature <= FREEZING_THRESHOLDS) {
            echoStatus(FREEZING);
            setCurrentStatus(FREEZING);
        }

        if (privTemperature < FREEZING_THRESHOLDS &&
                curTemperature >= FREEZING_THRESHOLDS) {
            echoStatus(UNFREEZING);
            setCurrentStatus(UNFREEZING);
        }
    }

    private void alertBoiling(double privTemperature, double curTemperature) {
        if (privTemperature < BOILING_THRESHOLDS &&
                curTemperature >= BOILING_THRESHOLDS) {
            echoStatus(BOILING);
            setCurrentStatus(BOILING);
        }

        if (privTemperature > BOILING_THRESHOLDS &&
                curTemperature <= BOILING_THRESHOLDS) {
            echoStatus(UNBOILING);
            setCurrentStatus(UNBOILING);
        }
    }

    private boolean isFluctuating() {
        boolean fluctuating = false;

        double privTemperature = getPriviousTemperature();
        double curTemperature = getCurrentTemperature();

        if (getCurrentStatus() == FREEZING) {
            if (curTemperature >= FREEZING_THRESHOLDS && curTemperature <= UNFREEZING_THRESHOLDS) {
                fluctuating = true;
                setCurrentTemperature(privTemperature); // ignore currnet Temperature
            }
        }

        if (getCurrentStatus() == BOILING) {
            if (curTemperature <= BOILING_THRESHOLDS && curTemperature >= UNBOILING_THRESHOLDS) {
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