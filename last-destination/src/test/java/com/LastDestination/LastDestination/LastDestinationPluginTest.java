package com.LastDestination.LastDestination;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class LastDestinationPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(LastDestinationPlugin.class);
		RuneLite.main(args);
	}
}