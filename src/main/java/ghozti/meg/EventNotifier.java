package ghozti.meg;

import database.DataBaseMainMain;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.EventListener;
import java.util.Locale;

public class EventNotifier implements MessageCreateListener {
    //todo handle formated data
    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        String type = "", description = "", date = "", start = "", end = "", finished = "";

        if (event.getMessageContent().equals("!meg -get events".toLowerCase())){
            try {

                String[] data = new String[]{};

                for (String i : DataBaseMainMain.getSheetData()){
                    data = i.split(",");
                }

                for (String i : data){
                    if (i.endsWith(" Type")) type = i.substring(0,i.length()-4);
                    else if (i.endsWith(" Des")) description = i.substring(0,i.length()-3);
                    else if (i.endsWith(" Date")) date = i.substring(0,i.length()-4);
                    else if (i.endsWith(" Start")) start = i.substring(0,i.length()-5);
                    else if (i.endsWith(" End")) end = i.substring(0,i.length()-3);
                    else if (i.endsWith(" Finished")) finished = i.substring(0,i.length()-8);
                }

                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle(type)
                        .setDescription(description)
                        .setAuthor("Meg 333")
                        .addInlineField("Date", date)
                        .addInlineField("Time Interval: ", start + " - " + end)
                        .addInlineField("Is done", finished)
                        .setColor(Color.BLUE);
                event.getChannel().sendMessage(embed);
            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
            }
        }
    }
}
