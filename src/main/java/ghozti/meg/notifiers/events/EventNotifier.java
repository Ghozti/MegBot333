package ghozti.meg.notifiers.events;

import database.DataBaseMain;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventNotifier implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        String type = "", description = "", date = "", start = "", end = "", finished = "";

        if (event.getMessageContent().equalsIgnoreCase("!meg -get events")){
            event.getChannel().sendMessage("Here are the events for the month:");
            try {

                String[] data;

                for (String i : DataBaseMain.getEventSheetData()){
                    data = i.split(",");
                    for (String s : data){
                        if (s.endsWith(" Type")) type = s.substring(0,s.length()-4);
                        else if (s.endsWith(" Des")) description = s.substring(0,s.length()-3);
                        else if (s.endsWith(" Date")) date = s.substring(0,s.length()-4);
                        else if (s.endsWith(" Start")) start = s.substring(0,s.length()-5);
                        else if (s.endsWith(" End")) end = s.substring(0,s.length()-3);
                        else if (s.endsWith(" Finished")) finished = s.substring(0,s.length()-8);
                    }

                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                    Date jDate = new Date();
                    String sDate = formatter.format(jDate);

                    if (areDatesClose(date,sDate)) {
                        EmbedBuilder embed = new EmbedBuilder()
                                .setTitle(type)
                                .setDescription(description)
                                .setAuthor("Meg 333", "http://google.com/", "https://cdn.discordapp.com/attachments/915970934215688235/921978568051929158/frc333-8.png")
                                .addInlineField("Date:", date)
                                .addInlineField("Duration: ", start + " - " + end)
                                .addInlineField("Is done:", finished)
                                .setColor(Color.BLUE);
                        event.getChannel().sendMessage(embed);
                    }
                }
            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
                event.getChannel().sendMessage("Uh oh something happened that shouldn't have happened, maybe Ghozti should fix me");
            }
        }
    }

    private boolean areDatesClose(String date1, String date2){//date 1 being the data date, date 2 being the current date
        if (date1.substring(0,3).trim().equals(date2.substring(0,2).trim())){
            return true;
        }
        return false;
    }
}
