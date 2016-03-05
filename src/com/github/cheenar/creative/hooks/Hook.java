package com.github.cheenar.creative.hooks;

/**
 * Created by admin on 2/24/16.
 */
public class Hook
{
    protected String identifier;

    public Hook(String id)
    {
        this.identifier = id;
    }

    public String toString()
    {
        return this.identifier;
    }

}
