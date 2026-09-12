package com.skriptdev.skbase.skript.modules;

import com.skriptdev.skbase.skript.expressions.SKbaseVersionExpression;
import org.skriptlang.skript.addon.AddonModule;
import org.skriptlang.skript.addon.SkriptAddon;
import org.skriptlang.skript.registration.DefaultSyntaxInfos;
import org.skriptlang.skript.registration.SyntaxRegistry;

/**
 * Registers the Skript syntax provided by SKbase.
 */
public class SKbaseSkriptModule implements AddonModule {

    /**
     * Creates a new SKbase Skript module.
     */
    public SKbaseSkriptModule() {
    }

    @Override
    public String name() {
        return "SKbase";
    }

    @Override
    public void load(SkriptAddon addon) {
        SyntaxRegistry registry = moduleRegistry(addon);

        registry.register(
                SyntaxRegistry.EXPRESSION,
                DefaultSyntaxInfos.Expression.simple(
                        SKbaseVersionExpression.class,
                        SKbaseVersionExpression::new,
                        String.class,
                        "SKbase version"
                )
        );
    }
}