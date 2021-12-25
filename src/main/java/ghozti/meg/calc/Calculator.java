package ghozti.meg.calc;

public class Calculator {

    //the calculator utilty class

    private static boolean isListEmpty(float[] nums){return nums.length == 0;}

    public static float add(float[] nums){
        if (isListEmpty(nums)) return 0;
        float sum = 0;
        for (float i : nums) {
            sum += i;
        }
        return sum;
    }

    public static float sub(float[] nums){
        if (isListEmpty(nums)) return 0;
        float remainder = nums[1];
        int runs = 1;
        for (float i : nums) {
            if (runs > 1){
                remainder -= i;
            }
            runs++;
        }
        return remainder;
    }

    public static float mul(float[] nums){
        if (isListEmpty(nums)) return 0;
        float product = nums[0];
        int runs = 1;
        for (float i : nums) {
            if (runs > 1){
                product *= i;
            }
            runs++;
        }
        return product;
    }

    public static float div(float[] nums){
        if (isListEmpty(nums)) return 0;
        float quotient = nums[0];
        int runs = 1;
        try {
            for (float i : nums) {
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
}
