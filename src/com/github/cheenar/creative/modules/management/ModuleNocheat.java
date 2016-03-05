package com.github.cheenar.creative.modules.management;

import com.github.cheenar.creative.Creative;
import com.github.cheenar.creative.events.EventSendChatMessage;
import com.github.cheenar.creative.flags.FlagArraylistToggle;
import com.github.cheenar.creative.modules.Module;

/**
 * Created by admin on 3/4/16.
 */
public class ModuleNocheat extends Module implements EventSendChatMessage, FlagArraylistToggle {

    public ModuleNocheat()
    {
        Creative.getEventManager().registerEvent(this);
        setName("Nocheat");
        setDescription("Nocheat disables certain hacks");
        setAuthor("Admin");
    }

    private void toggle()
    {
        Creative.isNocheat = !Creative.isNocheat;
    }

    @Override
    public void sendChatMessage(String message)
    {
        if(message.startsWith("-nocheat"))
        {
            String args[] = message.split(" ");
            if(args[1].startsWith("toggle"))
            {
                toggle();
                Creative.chatMessage("toggled nocheat: " + Boolean.toString(Creative.isNocheat));
            }
            else
            {
                Creative.chatMessage("available args: toggle");
            }
            return;
        }
    }

    @Override
    public int color() {
        return 0x5c8a8a;
    }

    @Override
    public boolean isEnabled() {
        return Creative.isNocheat;
    }

}
