package com.skriptdev.skbase;

import org.bukkit.plugin.java.JavaPlugin;


public final class SKbase extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("SKbase has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SKbase has been disabled!");
    }
}
