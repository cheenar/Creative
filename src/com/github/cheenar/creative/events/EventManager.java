package com.github.cheenar.creative.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by admin on 2/24/16.
 */
public class EventManager
{

    public ArrayList<Event> events;

    public EventManager()
    {
        events = new ArrayList<Event>();
    }

    public void registerEvent(Event e)
    {
        events.add(e);
    }

    public void deregisterEvent(Event e)
    {
        events.remove(e);
    }

    public ArrayList<Event> getEvents()
    {
        return events;
    }

    public void runEvent(Class eventClass, Object[] args)
    {
        for(Event event : getEvents())
        {
            try
            {
                for(Class<?> intf : event.getClass().getInterfaces())
                {
                    if(intf == eventClass)
                    {
                        intf.getMethods()[0].invoke(event, args);
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
