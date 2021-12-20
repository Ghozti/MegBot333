package ghozti.meg.notifiers.cartel;

import database.DataBaseMainMain;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class CandyCartelSingleNotifier implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().toLowerCase().contains("!meg -get cartel item:")){
            String item = event.getMessageContent().split(":")[1];
            String candyName = null, stock = null, price = null;
            item = item.trim().toLowerCase();

            try {
                String[] data;
                ArrayList<String[]> candyData = new ArrayList<>();

                for (String i : DataBaseMainMain.getCandySheetData()){
                    data = i.split(",");
                    for (String s : data) {
                        if (s.endsWith(" Name")) candyName = s.substring(0, s.length() - 4).trim();
                        else if (s.endsWith(" Stock")) stock = s.substring(0, s.length() - 5).trim();
                        else if (s.endsWith(" Price")) price = s.substring(0, s.length() - 5).trim();
                    }
                    candyData.add(new String[]{candyName,stock,price});
                }

                for (String[] i : candyData) {
                    if (i[0].toLowerCase().equals(item)){
                        EmbedBuilder embed = new EmbedBuilder()
                                .setAuthor("Meg 333", "http://google.com/", "https://cdn.discordapp.com/attachments/915970934215688235/921978568051929158/frc333-8.png")
                                .setDescription("Candy cartel Data")
                                .addInlineField("Name:", i[0])
                                .addInlineField("In Stock:", i[1])
                                .addInlineField("Price:", i[2])
                                .setColor(Color.ORANGE);
                        event.getChannel().sendMessage(embed);
                        return;
                    }
                }
                event.getChannel().sendMessage("There seems to be no candy/snack under this name, please make sure you entered the name as marked in labels or the cartel list. If your item has multiple variants, type the candy name then the variant in parenthesis ex: Hershey's (Classic) , Cup Noodles (Beef Flavor), m&m's (Milk Chocolate), Pretzels (Rainbow Sprinkles). You can also get the entire cartel list to get the name of your item. Otherwise: ");
                event.getChannel().sendMessage("https://tenor.com/view/it-doesnt-exist-not-existing-none-no-nope-gif-11708231");
            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
                event.getChannel().sendMessage("Uh oh something happened that shouldn't have happened, maybe Ghozti should fix me");
            }
        }
    }
}
