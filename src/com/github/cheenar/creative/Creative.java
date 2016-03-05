package com.github.cheenar.creative;

import com.github.cheenar.creative.events.EventManager;
import com.github.cheenar.creative.hooks.HookManager;
import com.github.cheenar.creative.modules.*;
import com.github.cheenar.creative.modules.management.ModuleGameGui;
import com.github.cheenar.creative.modules.management.ModuleNocheat;
import com.github.cheenar.creative.modules.movement.*;
import com.github.cheenar.creative.modules.world.ModuleFlashlight;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

/**
 * @author Cheenar
 * @description Main class
 */

public class Creative
{

    private static Creative creative = new Creative();
    private static HookManager hookManager;
    private static EventManager eventManager;
    private static ModuleManager moduleManager;

    public static boolean isNocheat;

    public Creative()
    {
        hookManager = new HookManager();
        eventManager = new EventManager();
        moduleManager = new ModuleManager();

        moduleManager.registerModule("GameGui", new ModuleGameGui());
        moduleManager.registerModule("Flight", new ModuleFlight());
        moduleManager.registerModule("Sneak", new ModuleSneak());
        moduleManager.registerModule("Nofall", new ModuleNofall());
        moduleManager.registerModule("Sprint", new ModuleSprint());
        moduleManager.registerModule("Nocheat", new ModuleNocheat());
        moduleManager.registerModule("Step", new ModuleStep());
        moduleManager.registerModule("Flashlight", new ModuleFlashlight());

        isNocheat = false;
    }

    public static Minecraft getMinecraft()
    {
        return Minecraft.getMinecraft();
    }

    public static Creative getCreative()
    {
        return creative;
    }

    public static HookManager getHookManager()
    {
        return hookManager;
    }

    public static EventManager getEventManager()
    {
        return eventManager;
    }

    public static ModuleManager getModuleManager()
    {
        return moduleManager;
    }

    public static String getName()
    {
        return new String("TeamR3D");
    }

    public static String getVerison()
    {
        return new String("1.0.0");
    }

    public static String getAuthor()
    {
        return new String("Cheenar");
    }

    public static boolean isDebugMode()
    {
        return true;
    }

    public static void log(String name, String description)
    {
        System.out.println("[" + getName() + "] " + name + ": " + description);
    }

    public static void chatMessage(String message)
    {
        getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("[" + "\247c" + "TR" + "\247f" + "] " + message));
    }

}
