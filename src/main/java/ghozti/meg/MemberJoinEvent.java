package ghozti.meg;

import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.javacord.api.listener.server.member.ServerMemberJoinListener;

public class MemberJoinEvent implements ServerMemberJoinListener {

    @Override
    public void onServerMemberJoin(ServerMemberJoinEvent event) {
        event.getServer().getTextChannelById(915970934215688235L).get().sendMessage("Welcome to the server: " + event.getUser().getDisplayName(event.getServer()) + "! please read the rules and have a team member confirm your identity in order to have full access to team chats.");
    }
}
