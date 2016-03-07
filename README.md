# Creative
Creative is a client-side modification to the game: Minecraft. 

Currently the source code available on github cannot build properly into the game unless the necessary hooks are added to the game. Right now the classes that are modified are as follows:

- Minecraft
- GuiIngame
- EntityClientMP
- EntityClientSP
- GuiNewChat

Add the hooks

```Creative.getHookManager().runHook("HookClassName", "methodName", new Object[] { args });```

Add the event calls

```Creative.getEventManager().runEvent(EventClass.class, new Object[] { args });```
