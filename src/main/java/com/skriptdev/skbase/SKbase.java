package com.skriptdev.skbase;

import com.skriptdev.skbase.skript.SKbaseSkript;
import org.bukkit.plugin.java.JavaPlugin;
import com.skriptdev.skbase.database.DatabaseManager;
import com.skriptdev.skbase.database.Database;
import com.skriptdev.skbase.database.SQLiteDatabase;

import java.io.File;
import java.sql.SQLException;

public final class SKbase extends JavaPlugin {



    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {

        if (getServer().getPluginManager().getPlugin("Skript") == null) {
            getLogger().severe("Skript is not installed!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        SKbaseSkript skript = new SKbaseSkript(this);
        skript.register();

        getLogger().info("Skript has been found!");

        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        databaseManager = new DatabaseManager();

        Database database = new SQLiteDatabase(
                new File(getDataFolder(), "database.db").getPath()
        );
        databaseManager.register("main", database);

        try {
            databaseManager.connectAll();


            getLogger().info("Database connected successfully!");
            getLogger().info("SKbase has been enabled!");

        } catch (SQLException e) {
            getLogger().severe("Database connection failed!");
            e.printStackTrace();
        }


    }

    @Override
    public void onDisable() {
        if (databaseManager != null) {
            try {
                databaseManager.disconnectAll();
            } catch (SQLException e) {
                getLogger().severe("Database disconnection failed!");
                e.printStackTrace();
            }
        }


    }


}