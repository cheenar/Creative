package com.github.cheenar.creative.modules.movement;

import com.github.cheenar.creative.Creative;
import com.github.cheenar.creative.events.EventOnKeyPress;
import com.github.cheenar.creative.events.EventSendChatMessage;
import com.github.cheenar.creative.flags.FlagArraylistToggle;
import com.github.cheenar.creative.modules.Module;
import org.lwjgl.input.Keyboard;

/**
 * Created by admin on 3/2/16.
 */
public class ModuleFlight extends Module implements EventOnKeyPress, FlagArraylistToggle, EventSendChatMessage
{

    private boolean isFlying;
    private float speed;

    public ModuleFlight()
    {
        Creative.getEventManager().registerEvent(this);
        setName("Flight");
        setAuthor("Admin");
        setDescription("Allows player to fly around");

        speed = 0.1F;
        isFlying = false;
    }

    @Override
    public void onKeyPress(Integer key) {
        if(key == Keyboard.KEY_C)
        {
            isFlying = !isFlying;
        }
        flight();
    }

    private void flight()
    {
        if(isFlying)
        {
            if(Creative.isNocheat)
            {
                isFlying = false;
            }
            else
            {
                Creative.getMinecraft().thePlayer.capabilities.allowFlying = true;
                Creative.getMinecraft().thePlayer.capabilities.isFlying = true;
                Creative.getMinecraft().thePlayer.capabilities.setFlySpeed(speed);
            }
        }
        else
        {
            Creative.getMinecraft().thePlayer.capabilities.allowFlying = false;
            Creative.getMinecraft().thePlayer.capabilities.isFlying = false;
        }
    }


    @Override
    public int color() {
        return 0x8cb63d;
    }

    @Override
    public boolean isEnabled()
    {
        return isFlying;
    }

    @Override
    public void sendChatMessage(String message)
    {
        if(message.startsWith("-flight"))
        {
            String args[] = message.split(" ");
            if(args[1].startsWith("speed"))
            {
                speed = Float.parseFloat(args[2]);
                Creative.chatMessage("flight speed set: " + speed);
            }
            if(args[1].startsWith("toggle"))
            {
                isFlying = !isFlying;
                flight();
                Creative.chatMessage("flight toggled: " + Boolean.toString(isFlying));
            }
            return;
        }
    }
}
