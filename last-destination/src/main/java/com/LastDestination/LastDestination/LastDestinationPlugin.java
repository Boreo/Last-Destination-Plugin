package com.LastDestination.LastDestination;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Last Destination"
)
public class LastDestinationPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private LastDestinationConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Last Destination started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Last Destination stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Last Destination says " + config.greeting(), null);
		}
	}

	@Provides
	LastDestinationConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LastDestinationConfig.class);
	}
}
