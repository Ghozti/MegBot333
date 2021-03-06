package ghozti.meg;

import ghozti.meg.calc.CalcListener;
import ghozti.meg.memberManager.MemberJoinEvent;
import ghozti.meg.menu.HelpMenu;
import ghozti.meg.notifiers.cartel.CandyCartelNotifier;
import ghozti.meg.notifiers.cartel.CandyCartelSingleNotifier;
import ghozti.meg.notifiers.events.EventNotifier;
import ghozti.meg.notifiers.extras.CurrentReleaseNotifier;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main {

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        DiscordApi api = new DiscordApiBuilder().setAllIntents().setToken(TokenClass.token).login().join();
        api.addMessageCreateListener(new EventNotifier());
        api.addMessageCreateListener(new CandyCartelNotifier());
        api.addMessageCreateListener(new CandyCartelSingleNotifier());
        api.addServerMemberJoinListener(new MemberJoinEvent());
        api.addMessageCreateListener(new HelpMenu());
        api.addMessageCreateListener(new CurrentReleaseNotifier());
        api.addMessageCreateListener(new CalcListener());
        api.updateActivity("With Dispenza's pumpkin droid");
    }
}

