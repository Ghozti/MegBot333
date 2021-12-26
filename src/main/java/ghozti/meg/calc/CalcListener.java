package ghozti.meg.calc;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.ArrayList;

public class CalcListener implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().toLowerCase().contains("!meg -calc add:")){
            event.getChannel().sendMessage(Calculator.add(splitToArray(event.getMessageContent().split(":"))) + "");
        }else if (event.getMessageContent().toLowerCase().contains("!meg -calc sub:")){
            event.getChannel().sendMessage(Calculator.sub(splitToArray(event.getMessageContent().split(":"))) + "");
        }else if (event.getMessageContent().toLowerCase().contains("!meg -calc mul:")){
            event.getChannel().sendMessage(Calculator.mul(splitToArray(event.getMessageContent().split(":"))) + "");
        }else if (event.getMessageContent().toLowerCase().contains("!meg -calc div:")){
            event.getChannel().sendMessage(Calculator.div(splitToArray(event.getMessageContent().split(":"))) + "");
        }else if (event.getMessageContent().toLowerCase().contains("!meg -calc pow:")){
            double[] nums = splitToArray(event.getMessageContent().split(":"));
            double starting = nums[0];
            ArrayList<Double> newList = new ArrayList<>();
            int runs = 1;
            for (double i : nums){
                if (runs > 1) {
                    newList.add(i);
                }
                runs++;
            }
            event.getChannel().sendMessage(Calculator.pow(starting,newList.stream().mapToDouble(Double::doubleValue).toArray()) + "");
        }
    }

    private double[] splitToArray(String[] s){
        ArrayList<Double> nums = new ArrayList<>();
        try {
            s = s[1].split(",");
        }catch (ArrayIndexOutOfBoundsException e){
            return new double[] {0.0};
        }
        for (String i : s){
            try {
                nums.add(Double.parseDouble(i.trim()));
            }catch (NumberFormatException e){
                nums.add(0.0);
            }
        }
        return nums.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
