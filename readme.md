Design and implement a console application in any program language that adds alerts for temperature values from console input. The application should,
On startup, defines thresholds for freezing and boiling.
Alerts are generated when a specific threshold has been reached or exceeded.
Alerts should not be repeatedly triggered if the temperature is fluctuating around the thresholds.
The fluctuation limit should be set on startup along with the threshold definitions.
Alerts are defined with directions. Alert “freezing” is triggered if the previous temperature was above freezing point, and alert “unfreezing” is triggered if the previous temperature was below freezing point. Similar for “boiling” and “unboiling”.

For example, considering a freezing threshold is set to 0 and accepted fluctuation limit is set to +/-0.5, with the following temperature inputs,
4.0 1.5 1.0 0.5 0.0 -0.5 0.5 0.0 -1.0 -3.0 1.0 2.0 5.0
The output will be
4.0 1.5 1.0 0.5 0.0 freezing -0.5 0.5 0.0 -1.0 -3.0 1.0 unfreezing 2.0 5.0



Explanation about “fluctuating”:

“fluctuating” condition only be applied when previous temperature is freezing or boiling. For example if previous temperature is -1, then temperature is 0.5, then will not trigger “unfreezing” alert, only temperature above 0.5 will trigger “unfreezing”.  But if previous temperature is 0.6, only when temperature reach 0, the “freezing” alert will be triggered. 