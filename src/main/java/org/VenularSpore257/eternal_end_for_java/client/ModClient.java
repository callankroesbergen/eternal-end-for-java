package org.VenularSpore257.eternal_end_for_java.client;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import org.slf4j.Logger;
import org.VenularSpore257.eternal_end_for_java.client.particle.ModParticles;
import org.VenularSpore257.eternal_end_for_java.client.ModSounds;

/**
 * Client-side initialization for Eternal End mod.
 *
 * This class handles all client-side registrations including:
 * - Entity renderers
 * - Sound events
 * - Particle types
 * - Block/Item color handlers
 *
 * Note: This class is initialized manually via ModClient.init(), not via @EventBusSubscriber.
 * Event subscriptions are in separate classes (ModEntityRenderers, ModClientEvents).
 */
public class ModClient {

    private static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Initialize all client-side components.
     * Call this from the main mod class constructor.
     *
     * @param modEventBus The mod event bus
     */
    public static void init(IEventBus modEventBus) {
        LOGGER.info("Eternal End client initialization starting...");

        // Register sounds
        ModSounds.register(modEventBus);

        // Register particles
        ModParticles.register(modEventBus);

        LOGGER.info("Eternal End client initialization complete!");
    }

}
