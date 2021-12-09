package ghozti.meg;

import database.DataBaseMainMain;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.EventListener;
import java.util.Locale;

public class EventNotifier implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equals("!meg -get events".toLowerCase())){
            try {
                for (String i : DataBaseMainMain.getSheetData()){
                    event.getChannel().sendMessage(i);
                }
            } catch (IOException | GeneralSecurityException e) {
                e.printStackTrace();
            }
        }
    }
}
