package com.github.cheenar.creative.modules;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by admin on 3/2/16.
 */
public class ModuleManager
{

    private HashMap<String, Module> modules;

    public ModuleManager()
    {
        modules = new HashMap<String, Module>();
    }

    public void registerModule(String name, Module module)
    {
        modules.put(name, module);
    }

    public void deregisterModule(String name)
    {
        modules.remove(name);
    }

    public String getName(Module module)
    {
        for(String s : modules.keySet())
        {
            if(modules.get(s).equals(module))
            {
                return s;
            }
        }
        return "N/A";
    }

    public ArrayList<Module> getModules()
    {
        ArrayList<Module> mods = new ArrayList<Module>();
        for(String s : modules.keySet())
        {
            mods.add(modules.get(s));
        }
        return mods;
    }

}
