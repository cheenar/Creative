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
public class ModuleNofall extends Module implements FlagArraylistToggle, EventOnKeyPress, EventOnUpdatePost {

    private boolean isNofall;

    public ModuleNofall()
    {
        Creative.getEventManager().registerEvent(this);
        setName("Nofall");
        setAuthor("Admin");
        setDescription("Sends the nofall player packet");
    }

    @Override
    public void onUpdatePost()
    {
        if(isNofall)
        {
            if(Creative.isNocheat)
            {
                isNofall = false;
            }
            else
            {
                if(Creative.getMinecraft().thePlayer.fallDistance > 2)
                {
                    Creative.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
                }
            }
        }
        else
        {
        }
    }

    @Override
    public void onKeyPress(Integer key)
    {
        if(key == Keyboard.KEY_N)
        {
            isNofall = !isNofall;
        }
    }

    @Override
    public int color()
    {
        return 0xffff00;
    }

    @Override
    public boolean isEnabled() {
        return isNofall;
    }

}
