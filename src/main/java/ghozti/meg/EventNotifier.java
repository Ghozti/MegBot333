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
        if (event.getMessageContent().equals("!meg -get events".toLowerCase())){
            try {
                for (String i : DataBaseMainMain.getSheetData()){
                    EmbedBuilder embed = new EmbedBuilder()
                            .setTitle("Title")
                            .setDescription("Description")
                            .setAuthor("Author Name", "http://google.com/", "https://cdn.discordapp.com/embed/avatars/0.png")
                            .addField("A field", "Some text inside the field")
                            .addInlineField("An inline field", "More text")
                            .addInlineField("Another inline field", "Even more text")
                            .setColor(Color.BLUE);
                    event.getChannel().sendMessage(embed);
                }
            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
            }
        }
    }
}
