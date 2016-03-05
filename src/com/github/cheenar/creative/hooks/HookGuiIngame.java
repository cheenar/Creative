package com.github.cheenar.creative.hooks;

import com.github.cheenar.creative.Creative;
import com.github.cheenar.creative.events.EventRenderOverlay;
import net.minecraft.client.gui.FontRenderer;

/**
 * Created by admin on 2/24/16.
 */
public class HookGuiIngame extends Hook
{

    public HookGuiIngame()
    {
        super("HookGuiIngame");
    }

    public void renderOverlay()
    {
        Creative.getEventManager().runEvent(EventRenderOverlay.class, new Object[] { });
    }

    private FontRenderer fr = Creative.getMinecraft().fontRendererObj;

}
