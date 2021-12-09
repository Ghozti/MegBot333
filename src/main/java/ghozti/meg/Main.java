package ghozti.meg;

import database.DataBaseMainMain;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main {

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        DiscordApi api = new DiscordApiBuilder().setToken(Token.token).login().join();
        api.addMessageCreateListener(new EventNotifier());
    }
}
