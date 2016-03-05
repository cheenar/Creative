package com.github.cheenar.creative.modules.management;

import com.github.cheenar.creative.Creative;
import com.github.cheenar.creative.events.EventRenderOverlay;
import com.github.cheenar.creative.flags.FlagArraylistToggle;
import com.github.cheenar.creative.modules.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

/**
 * Created by admin on 2/24/16.
 */
public class ModuleGameGui extends Module implements EventRenderOverlay
{

    public ModuleGameGui()
    {
        Creative.getEventManager().registerEvent(this);
        setName("GameGui");
        setAuthor("Admin");
        setDescription("The UI when the game gui is enabled");
    }


    @Override
    public void renderOverlay()
    {
        int y = 2;
        fr.drawStringWithShadow("Minecraft 1.8.9 " + Creative.getName(), 2, y, 0x88FFFFFF);
        fr.drawStringWithShadow("\247a" + "X" + "\247f" + ": " + Creative.getMinecraft().thePlayer.getPosition().getX(), 2, y+=10, 0x88FFFFFF);
        fr.drawStringWithShadow("\247a" + "Y" + "\247f" + ": " + Creative.getMinecraft().thePlayer.getPosition().getY(), 2, y+=10, 0x88FFFFFF);
        fr.drawStringWithShadow("\247a" + "Z" + "\247f" + ": " + Creative.getMinecraft().thePlayer.getPosition().getZ(), 2, y+=10, 0x88FFFFFF);
        fr.drawStringWithShadow("\247a" + "YawHead" + "\247f" + ": " + Creative.getMinecraft().thePlayer.getRotationYawHead(), 2, y+=10, 0x88FFFFFF);
        int z = -8;
        ScaledResolution scaledresolution = new ScaledResolution(Creative.getMinecraft());
        int i = scaledresolution.getScaledWidth();
        int j = scaledresolution.getScaledHeight();
        for(Module mod : Creative.getModuleManager().getModules())
        {
            if(mod instanceof FlagArraylistToggle)
            {
                if(((FlagArraylistToggle) mod).isEnabled())
                {
                    fr.drawStringWithShadow(mod.getName(), i - fr.getStringWidth(mod.getName()) - 2, z+=10, ((FlagArraylistToggle) mod).color());
                }
            }
        }
    }

    private FontRenderer fr = Creative.getMinecraft().fontRendererObj;

}
