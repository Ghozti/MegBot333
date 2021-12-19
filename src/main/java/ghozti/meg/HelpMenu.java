package ghozti.meg;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class HelpMenu implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!meg -help")){
            EmbedBuilder builder = new EmbedBuilder().setAuthor("Meg 333", "http://google.com/", "https://cdn.discordapp.com/attachments/915970934215688235/921978568051929158/frc333-8.png")
                    .setColor(Color.MAGENTA)
                    .setTitle("Help menu");
            event.getChannel().sendMessage(builder);
        }
    }
}
