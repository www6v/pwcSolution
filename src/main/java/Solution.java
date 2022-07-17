import java.util.Scanner;

public class Solution {
    public static final int freezingThresholds = 0;
    private static final int boilingThresholds = 100;
    public static final String FREEZING = "freezing";
    public static final String BOILING = "boiling";
    public static final String UNFREEZING = "unfreezing";
    public static final String UNBOILING = "unboiling";


    private double priviousTemperature;
    private double currentTemperature;

    private String currentStatus;

    private double fluctuation = 0.5;

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
         while(true) {
                 if(scanner.hasNextLine()) {
                     try {
                         String s = scanner.nextLine();
                         Double aDouble = Double.valueOf(s);
                         System.out.println(aDouble);

                         solution.input(aDouble);
                         solution.alert();
                     } catch (NumberFormatException nfe) {
                         System.err.println(nfe);
                     }
                 }
         }
    }

    private  void input(double temperature) {
        this.priviousTemperature = this.currentTemperature;
        this.currentTemperature = temperature;
    }

    /**
     * +警报由方向定义。
     * 如果之前的温度高于冰点，则会触发警报“冻结”，如果之前的温度低于冰点，则会触发警报“解冻”。
     * 类似于“沸腾”和“未沸腾”。
     */
    private  void alert() {
//          if(this.currentTemperature <= freezingThresholds) {
//              System.out.println(FREEZING);
//          }

          if(this.priviousTemperature < boilingThresholds &&
         this.currentTemperature >= boilingThresholds) {
              System.out.println(BOILING);
          }

        if(this.priviousTemperature > boilingThresholds &&
                this.currentTemperature <= boilingThresholds) {
            System.out.println(UNBOILING);
        }

          if(this.priviousTemperature > freezingThresholds &&
                  this.currentTemperature <= freezingThresholds) {
              System.out.println(FREEZING);
          }

          if(this.priviousTemperature < freezingThresholds &&
                  this.currentTemperature >= freezingThresholds) {
                System.out.println(UNFREEZING);
          }
    }


    private void fluctuating() {
    }
}
