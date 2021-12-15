package ghozti.meg;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class CandyCartelNotifier implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equals("!meg -get cartel stock")){
            event.getChannel().sendMessage("Here is the candy cartel data: ");
        }
    }
}
