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
                    for (String s : data){
                        if (s.endsWith(" Type")) type = s.substring(0,s.length()-4);
                        else if (s.endsWith(" Des")) description = s.substring(0,s.length()-3);
                        else if (s.endsWith(" Date")) date = s.substring(0,s.length()-4);
                        else if (s.endsWith(" Start")) start = s.substring(0,s.length()-5);
                        else if (s.endsWith(" End")) end = s.substring(0,s.length()-3);
                        else if (s.endsWith(" Finished")) finished = s.substring(0,s.length()-8);
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
                }
            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
            }
        }
    }
}
