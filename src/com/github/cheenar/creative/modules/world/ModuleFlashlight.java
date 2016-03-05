package com.github.cheenar.creative.modules.world;

import com.github.cheenar.creative.Creative;
import com.github.cheenar.creative.events.EventOnKeyPress;
import com.github.cheenar.creative.events.EventOnUpdatePost;
import com.github.cheenar.creative.flags.FlagArraylistToggle;
import com.github.cheenar.creative.modules.Module;
import org.lwjgl.input.Keyboard;

/**
 * Created by admin on 3/4/16.
 */
public class ModuleFlashlight extends Module implements FlagArraylistToggle, EventOnKeyPress, EventOnUpdatePost
{

    private boolean isFlashlight;

    public ModuleFlashlight()
    {
        Creative.getEventManager().registerEvent(this);
        setName("Flashlight");
        setDescription("Flashlight for the game");
        setAuthor("Cheenar");
    }

    @Override
    public void onKeyPress(Integer key) {
        if(key == Keyboard.KEY_X)
        {
            isFlashlight = !isFlashlight;
        }
    }

    @Override
    public int color() {
        return 0xffffe6;
    }

    @Override
    public boolean isEnabled() {
        return isFlashlight;
    }

    @Override
    public void onUpdatePost()
    {
        if(isFlashlight)
        {
            if(Creative.getMinecraft().gameSettings.gammaSetting < 16.0F)
            {
                Creative.getMinecraft().gameSettings.gammaSetting += 0.5F;
            }
        }
        else
        {
            if(Creative.getMinecraft().gameSettings.gammaSetting > 0.5F)
            {
                Creative.getMinecraft().gameSettings.gammaSetting -= 0.5F;
            }
        }
    }
}
