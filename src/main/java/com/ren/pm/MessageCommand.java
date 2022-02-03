package com.ren.pm;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 2) {
                if(Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    assert target != null;
                    target.sendMessage(ChatColor.GREEN + player.getDisplayName() + ": " + args[1]);
                    target.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§d§lA new message appeared!"));
                } else { //Error
                    player.sendMessage(ColorCodes.translate(ColorCodes.player_not_found));
                }
            } else { //Error
                player.sendMessage(ColorCodes.translate(ColorCodes.message_error));
            }
        }

        return false;
    }
}
