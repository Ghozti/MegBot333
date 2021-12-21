package ghozti.meg.notifiers.extras;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class CurrentReleaseNotifier implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!meg -release")){
            EmbedBuilder builder = new EmbedBuilder().setAuthor("Meg 333", "http://google.com/", "https://cdn.discordapp.com/attachments/915970934215688235/921978568051929158/frc333-8.png")
                    .setTitle("Current Release: 0.1.0")
                    .setDescription("0.1.0 is the first stable release of this bot, It is only able to send data from the candy cartel and event info database. Please feel free to send feedback on bugs/errors/suggestions")
                    .addField("Developers and helpers:", "Yesi, Britney and the rest of the Candy Cartel");
            event.getChannel().sendMessage(builder);
        }
    }
}
