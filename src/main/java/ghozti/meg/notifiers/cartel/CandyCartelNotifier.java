package ghozti.meg.notifiers.cartel;

import database.DataBaseMain;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class CandyCartelNotifier implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        String name = "", stock = "", price = "";

        if (event.getMessageContent().equalsIgnoreCase("!meg -get cartel list")){
            event.getChannel().sendMessage("Here is the candy cartel data: ");
            try {

                String[] data;
                ArrayList<String[]> candyData = new ArrayList<>();
                for (String i : DataBaseMain.getCandySheetData()){
                    data = i.split(",");
                    for (String s : data) {
                        if (s.endsWith(" Name")) name = s.substring(0, s.length() - 4).trim();
                        else if (s.endsWith(" Stock")) stock = s.substring(0, s.length() - 5).trim();
                        else if (s.endsWith(" Price")) price = s.substring(0, s.length() - 5).trim();
                    }
                    candyData.add(new String[]{name,stock,price});
                }

                int size = candyData.size()/3;
                int remainder = candyData.size() % 3;
                float finalSize = remainder == 0 ? size : size+1;
                int candyDataIndexMin = 0;
                int candyDataIndexMax = 3;

                for (int j = 0; j < finalSize; j++){
                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setColor(Color.BLUE);
                    for (int i = candyDataIndexMin; i < candyDataIndexMax; i++) {
                        if (i == 0) {
                            embed.setAuthor("Meg 333", "http://google.com/", "https://cdn.discordapp.com/attachments/915970934215688235/921978568051929158/frc333-8.png");
                            embed.setDescription("Candy cartel Data             " + (j+1) + "/" + (int)finalSize);
                        }else if (i > 0){
                            embed.setDescription("Candy cartel Data             " + (j+1) + "/" + (int)finalSize);
                        }

                        embed.addInlineField("Name:", candyData.get(i)[0]);
                        embed.addInlineField("In Stock:", candyData.get(i)[1]);
                        embed.addInlineField("Price:", candyData.get(i)[2]);
                    }
                    if ((candyDataIndexMax + 3) > candyData.size()){
                        candyDataIndexMax = candyData.size();
                        candyDataIndexMin = candyData.size() - remainder;
                    }else {
                        candyDataIndexMax += 3;
                        candyDataIndexMin += 3;
                    }
                    event.getChannel().sendMessage(embed);
                }

            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
                event.getChannel().sendMessage("Uh oh something happened that shouldn't have happened, maybe Ghozti should fix me");
            }
        }
    }
}
