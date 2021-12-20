package ghozti.meg.menu;

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
                    .setTitle("Megalodon Bot Help menu")
                    .setDescription("The meg is meant to be a personalized discord bot for the frc team, it provides some utility functions such as:")
                    .addField("Candy Cartel","Search either individual items or the entire list")
                    .addInlineField("!meg -get cartel list", "gets the entire candy cartel stock data")
                    .addInlineField("!meg -get cartel item: <candy name>", "will search for the candy specified (note: do not type <>, just type the name. You must also type the name as specified in the list)")
                    .addField("Event Notifier","will get the month's events (they can be either robotics or JDHS related)")
                    .addInlineField("!meg -get events","will get the events for the month");
            event.getChannel().sendMessage(builder);
        }
    }
}
