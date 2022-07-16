public class Solution {
    private long freezing = 0;
    private long boiling = 100;

    private long priviousTemperature;
    private long currentTemperature;

    private String currentStatus;

    private void input(int temperature) {
        this.priviousTemperature = this.currentTemperature;
        this.currentTemperature = temperature;
    }

    private String alert(int temperature) {
          if(temperature <= freezing) {
              return "freezing";
          }

          if(temperature >= boiling) {
              return "boiling";
          }

          return "";
    }


    private void fluctuating() {
    }
}
