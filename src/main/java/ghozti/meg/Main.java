package ghozti.meg;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static void main(String[] args){
        DiscordApi api = new DiscordApiBuilder().setToken(Token.token).login().join();
    }
}
