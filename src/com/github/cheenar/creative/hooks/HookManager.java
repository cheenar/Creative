package com.github.cheenar.creative.hooks;

import com.github.cheenar.creative.Creative;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by admin on 2/24/16.
 */

public class HookManager
{

    private HashMap<String, Hook> hooks;

    public HookManager()
    {
        this.hooks = new HashMap<String, Hook>();
        registerHook(new HookMinecraft());
        registerHook(new HookGuiIngame());
        registerHook(new HookEntityPlayer());
    }

    public void registerHook(Hook h)
    {
        getHooks().put(h.identifier, h);
    }

    public HashMap<String, Hook> getHooks()
    {
        return this.hooks;
    }

    public void runHook(String hookName, String hookFunction, Object[] args)
    {
        try
        {
            Hook hook = getHooks().get(hookName);
            Class[] classArgs = new Class[args.length];
            for(int i = 0; i< args.length; i++)
            {
                classArgs[i] = args[i].getClass();
            }
            Method method = hook.getClass().getMethod(hookFunction, classArgs);
            method.invoke(hook, args);
        }
        catch(Exception e)
        {
            Creative.log("Failed hooking", "Something went wrong!");
            e.printStackTrace();
        }
    }

}
