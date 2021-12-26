package ghozti.meg.calc;

public class Calculator {

    //the calculator utilty class

    private static boolean isListEmpty(double[] nums){return nums.length == 0;}

    public static double add(double[] nums){
        if (isListEmpty(nums)) return 0;
        double sum = 0;
        for (double i : nums) {
            sum += i;
        }
        return sum;
    }

    public static double sub(double[] nums){
        if (isListEmpty(nums)) return 0;
        double remainder = nums[1];
        int runs = 1;
        for (double i : nums) {
            if (runs > 1){
                remainder -= i;
            }
            runs++;
        }
        return remainder;
    }

    public static double mul(double[] nums){
        if (isListEmpty(nums)) return 0;
        double product = nums[0];
        int runs = 1;
        for (double i : nums) {
            if (runs > 1){
                product *= i;
            }
            runs++;
        }
        return product;
    }

    public static double div(double[] nums){
        if (isListEmpty(nums)) return 0;
        double quotient = nums[0];
        int runs = 1;
        try {
            for (double i : nums) {
                if (runs > 1) {
                    quotient /= i;
                }
                runs++;
            }
        }catch (Exception e){
            return 0;
        }
        return quotient;
    }

    public static double pow(double normalNum,double[] nums){
        double total = normalNum;
        for (double i : nums) {
            total = Math.pow(total, i);
        }
        return total;
    }
}
