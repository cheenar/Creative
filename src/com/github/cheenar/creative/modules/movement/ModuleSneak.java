package com.github.cheenar.creative.modules.movement;

import com.github.cheenar.creative.Creative;
import com.github.cheenar.creative.events.EventOnKeyPress;
import com.github.cheenar.creative.events.EventOnUpdatePost;
import com.github.cheenar.creative.flags.FlagArraylistToggle;
import com.github.cheenar.creative.modules.Module;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import org.lwjgl.input.Keyboard;

/**
 * Created by admin on 3/2/16.
 */
public class ModuleSneak extends Module implements FlagArraylistToggle, EventOnKeyPress, EventOnUpdatePost {

    private boolean isSneaking;

    public ModuleSneak()
    {
        Creative.getEventManager().registerEvent(this);
        setName("Sneak");
        setAuthor("Admin");
        setDescription("Sends the sneak packet");
    }

    @Override
    public void onUpdatePost()
    {
        if(isSneaking)
        {
            if(Creative.isNocheat)
            {
                Creative.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0BPacketEntityAction(Creative.getMinecraft().thePlayer, C0BPacketEntityAction.Action.START_SNEAKING));
                Creative.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0BPacketEntityAction(Creative.getMinecraft().thePlayer, C0BPacketEntityAction.Action.STOP_SNEAKING));
            }
            else
            {
                Creative.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0BPacketEntityAction(Creative.getMinecraft().thePlayer, C0BPacketEntityAction.Action.START_SNEAKING));
            }
        }
        else
        {
            Creative.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C0BPacketEntityAction(Creative.getMinecraft().thePlayer, C0BPacketEntityAction.Action.STOP_SNEAKING));
        }
    }

    @Override
    public void onKeyPress(Integer key)
    {
        if(key == Keyboard.KEY_Z)
        {
            isSneaking = !isSneaking;
        }
    }

    @Override
    public int color()
    {
        return 0x00e64d;
    }

    @Override
    public boolean isEnabled() {
        return isSneaking;
    }

}
