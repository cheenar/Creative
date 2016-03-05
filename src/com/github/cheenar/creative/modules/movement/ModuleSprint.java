package com.github.cheenar.creative.modules.movement;

import com.github.cheenar.creative.Creative;
import com.github.cheenar.creative.events.EventOnKeyPress;
import com.github.cheenar.creative.events.EventOnUpdatePost;
import com.github.cheenar.creative.flags.FlagArraylistToggle;
import com.github.cheenar.creative.modules.Module;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import org.lwjgl.input.Keyboard;

/**
 * Created by admin on 3/2/16.
 */
public class ModuleSprint extends Module implements FlagArraylistToggle, EventOnKeyPress, EventOnUpdatePost {

    private boolean isSprint;

    public ModuleSprint()
    {
        Creative.getEventManager().registerEvent(this);
        setName("Running");
        setAuthor("Admin");
        setDescription("Sends the sprint player packet");
    }

    @Override
    public void onUpdatePost()
    {
        if(isSprint)
        {
            if(Creative.isNocheat)
            {
                if(Creative.getMinecraft().thePlayer.getFoodStats().getFoodLevel() > 3)
                {
                    if(Creative.getMinecraft().thePlayer.moveForward > 0)
                    {
                        Creative.getMinecraft().thePlayer.setSprinting(true);
                        Creative.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0BPacketEntityAction(Creative.getMinecraft().thePlayer, C0BPacketEntityAction.Action.START_SPRINTING));
                    }
                }
                else
                {
                    isSprint = false;
                }
            }
            else
            {
                if(Creative.getMinecraft().thePlayer.moveForward > 0)
                {
                    Creative.getMinecraft().thePlayer.setSprinting(true);
                    Creative.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0BPacketEntityAction(Creative.getMinecraft().thePlayer, C0BPacketEntityAction.Action.START_SPRINTING));
                }
            }
        }
        else
        {
            Creative.getMinecraft().thePlayer.setSprinting(false);
            Creative.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0BPacketEntityAction(Creative.getMinecraft().thePlayer, C0BPacketEntityAction.Action.STOP_SPRINTING));
        }
    }

    @Override
    public void onKeyPress(Integer key)
    {
        if(key == Keyboard.KEY_R)
        {
            isSprint = !isSprint;
        }
    }

    @Override
    public int color()
    {
        return 0xff4d94;
    }

    @Override
    public boolean isEnabled() {
        return isSprint;
    }

}
