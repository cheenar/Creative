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
public class ModuleStep extends Module implements FlagArraylistToggle, EventOnKeyPress, EventOnUpdatePost {

    private boolean isStepping;

    public ModuleStep()
    {
        Creative.getEventManager().registerEvent(this);
        setName("Step");
        setAuthor("Admin");
        setDescription("Sends a jump when you hit the wall");
    }

    @Override
    public void onUpdatePost()
    {
        if(isStepping)
        {
            if(Creative.getMinecraft().thePlayer.isCollidedHorizontally && Creative.getMinecraft().thePlayer.onGround)
            {
                Creative.getMinecraft().thePlayer.jump();
                Creative.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
            }
        }
    }

    @Override
    public void onKeyPress(Integer key)
    {
        if(key == Keyboard.KEY_L)
        {
            isStepping = !isStepping;
        }
    }

    @Override
    public int color()
    {
        return 0x33ccff;
    }

    @Override
    public boolean isEnabled() {
        return isStepping;
    }

}
