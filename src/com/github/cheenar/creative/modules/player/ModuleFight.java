package com.github.cheenar.creative.modules.player;

import com.github.cheenar.creative.Creative;
import com.github.cheenar.creative.events.EventOnKeyPress;
import com.github.cheenar.creative.events.EventOnUpdatePre;
import com.github.cheenar.creative.flags.FlagArraylistToggle;
import com.github.cheenar.creative.modules.Module;
import net.minecraft.entity.EntityLivingBase;

/**
 * Created by admin on 3/5/16.
 */
public class ModuleFight extends Module implements FlagArraylistToggle, EventOnKeyPress, EventOnUpdatePre
{

    public ModuleFight()
    {
        Creative.getEventManager().registerEvent(this);
        setName("Fight");
        setDescription("Fighting");
        setAuthor("Cheenar");
    }

    @Override
    public void onKeyPress(Integer key)
    {

    }

    @Override
    public void onUpdatePre()
    {
        for(EntityLivingBase entity : Creative.getMinecraft().thePlayer.)
    }

    @Override
    public int color() {
        return 0xFFFFFF;
    }

    @Override
    public boolean isEnabled() {
        return isFighting;
    }

    private boolean isFighting;

}
