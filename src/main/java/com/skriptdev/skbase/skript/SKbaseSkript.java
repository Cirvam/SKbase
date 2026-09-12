package com.skriptdev.skbase.skript;

import com.skriptdev.skbase.skript.modules.SKbaseSkriptModule;
import com.skriptdev.skbase.skript.expressions.SKbaseVersionExpression;
import org.bukkit.plugin.java.JavaPlugin;
import org.skriptlang.skript.addon.SkriptAddon;
import org.skriptlang.skript.registration.DefaultSyntaxInfos;
import org.skriptlang.skript.registration.SyntaxRegistry;

/**
 * Handles the integration between SKbase and Skript.
 */
public class SKbaseSkript {

    private final JavaPlugin plugin;
    private SkriptAddon addon;

    /**
     * Creates a new SKbase Skript integration.
     *
     * @param plugin The SKbase plugin instance.
     */
    public SKbaseSkript(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Registers SKbase with Skript and its custom syntax.
     */
    public void register() {
        org.skriptlang.skript.Skript skript =
                ch.njol.skript.Skript.instance();

        addon = skript.registerAddon(
                plugin.getClass(),
                "SKbase"
        );

        addon.loadModules(
                new SKbaseSkriptModule()
        );
    }

    /**
     * Registers all SKbase expressions with Skript.
     */
    private void registerExpressions() {
        SyntaxRegistry registry = addon.syntaxRegistry();

        registry.register(
                SyntaxRegistry.EXPRESSION,
                DefaultSyntaxInfos.Expression.simple(
                        SKbaseVersionExpression.class,
                        SKbaseVersionExpression::new,
                        String.class,
                        "SKbase version"
                )
        );
        plugin.getLogger().info("Registered SKbase expression: SKbase version");

    }
}