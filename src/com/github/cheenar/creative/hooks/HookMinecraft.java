package com.github.cheenar.creative.hooks;

import com.github.cheenar.creative.Creative;
import com.github.cheenar.creative.events.EventOnKeyPress;
import net.minecraft.client.Minecraft;

/**
 * Created by admin on 2/24/16.
 */
public class HookMinecraft extends Hook
{
    public HookMinecraft()
    {
        super("HookMinecraft");
    }

    public static void onKeyPress(Integer key)
    {
        Creative.getEventManager().runEvent(EventOnKeyPress.class, new Object[] { key });
        System.out.println(key);
    }

}
