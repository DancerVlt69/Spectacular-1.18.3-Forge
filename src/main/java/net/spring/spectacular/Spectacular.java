package net.spring.spectacular;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Spectacular.MOD_ID)
public class Spectacular {
    public static final String MOD_ID = "spectacular";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Spectacular() {
        // Register the setup method for modloading
        // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::onCommonSetup);
		eventBus.addListener(this::onClientSetup);

		// enter your Item, Block, Sound, Effect Registering here
		// e.g like this ModBlocks.register(eventBus)

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        // some common setup code
		LOGGER.info("Starting Common Setup...");

		// enter your CommonSetup-Code here or call the methods

		LOGGER.info("Common Setup finished.");
		// LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

	private void onClientSetup(final FMLClientSetupEvent event) {
		// some client setup code
		LOGGER.info("Starting Client Setup...");
		// LOGGER.info("HELLO FROM PREINIT");

		// enter your ClientOnlySetup-Code here or call the methods

		LOGGER.info("Client Setup finished.");
		// LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
	}
}

