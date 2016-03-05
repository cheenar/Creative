package com.github.cheenar.creative.hooks;

import com.github.cheenar.creative.Creative;
import com.github.cheenar.creative.events.EventOnUpdatePost;
import com.github.cheenar.creative.events.EventOnUpdatePre;
import com.github.cheenar.creative.events.EventSendChatMessage;
import net.minecraft.network.play.client.C01PacketChatMessage;

/**
 * Created by admin on 3/2/16.
 */
public class HookEntityPlayer extends Hook
{

    public HookEntityPlayer()
    {
        super("EntityPlayer");
    }

    public void sendChatMessage(String message)
    {
        Creative.getEventManager().runEvent(EventSendChatMessage.class, new Object[] { message });
        if(!message.startsWith("-"))
        {
            Creative.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(message));
        }
    }

    public void onUpdatePre()
    {
        Creative.getEventManager().runEvent(EventOnUpdatePre.class, new Object[] { });
    }

    public void onUpdatePost()
    {
        Creative.getEventManager().runEvent(EventOnUpdatePost.class, new Object[] { });
    }

}
