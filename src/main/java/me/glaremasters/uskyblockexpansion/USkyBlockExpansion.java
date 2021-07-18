package me.glaremasters.uskyblockexpansion;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import us.talabrek.ultimateskyblock.api.uSkyBlockAPI;

import java.text.DecimalFormat;

public final class USkyBlockExpansion extends PlaceholderExpansion {
    private uSkyBlockAPI api;
    private final DecimalFormat level = new DecimalFormat("#.##");

    private final String VERSION = getClass().getPackage().getImplementationVersion();

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin(getRequiredPlugin()) != null;
    }

    @Override
    public boolean register() {
        api = (uSkyBlockAPI) Bukkit.getPluginManager().getPlugin(getRequiredPlugin());
        if (api != null) {
            return super.register();
        }
        return false;
    }

    @Override
    public @NotNull String getAuthor() {
        return "Gianluca";
    }

    @Override
    public String getRequiredPlugin() {
        return "uSkyBlock";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "uskyblock";
    }

    @Override
    public @NotNull String getVersion() {
        return VERSION;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) return "";

        switch (params) {
            case "island_level":
                return String.valueOf(level.format(api.getIslandLevel(player)));
            case "island_rank":
                return String.valueOf(api.getIslandRank(player).getRank());
        }
        return "";
    }
}
