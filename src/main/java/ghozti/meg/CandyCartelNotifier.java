package ghozti.meg;

import database.DataBaseMainMain;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CandyCartelNotifier implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        String name = "", stock = "", price = "";

        if (event.getMessageContent().equals("!meg -get cartel stock")){
            event.getChannel().sendMessage("Here is the candy cartel data: ");
            try {

                String[] data;
                ArrayList<String[]> candyData = new ArrayList<>();
                for (String i : DataBaseMainMain.getCandySheetData()){
                    data = i.split(",");
                    for (String s : data) {
                        if (s.endsWith(" Name")) name = s.substring(0, s.length() - 4).trim();
                        else if (s.endsWith(" Stock")) stock = s.substring(0, s.length() - 5).trim();
                        else if (s.endsWith(" Price")) price = s.substring(0, s.length() - 5).trim();
                    }
                    candyData.add(new String[]{name,stock,price});
                }

                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("Title")
                        .setDescription("Description")
                        .setAuthor("Author Name", "http://google.com/", "https://cdn.discordapp.com/embed/avatars/0.png")
                        .addField("A field", "Some text inside the field")
                        .addInlineField("An inline field", "More text")
                        .addInlineField("Another inline field", "Even more text")
                        .setColor(Color.BLUE)
                        .setFooter("Footer", "https://cdn.discordapp.com/embed/avatars/1.png");
// Send the embed
                event.getChannel().sendMessage(embed);

            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
                event.getChannel().sendMessage("Uh oh something happened that shouldn't have happened, maybe Ghozti should fix me");
            }
        }
    }
}
