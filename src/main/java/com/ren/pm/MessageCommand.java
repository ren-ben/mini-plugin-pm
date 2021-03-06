package com.ren.pm;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageCommand implements CommandExecutor {

    public static HashMap<Player, Player> reply_list = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length >= 2) {
                if(Bukkit.getPlayer(args[0]) != null) {
                    StringBuilder message = new StringBuilder();
                    Player target = Bukkit.getPlayer(args[0]);
                    assert target != null;
                    for (int i = 1; i < args.length; i++) {
                        message.append(args[i]).append(" ");
                    }
                    target.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + player.getDisplayName() + ": " + ChatColor.RESET +  message);
                    target.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§d§lA new message appeared!"));
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§2§lMessage sent Successfully!"));
                    reply_list.put(target.getPlayer(), player.getPlayer());
                } else { //Error
                    player.sendMessage(ColorCodes.translate(ColorCodes.player_not_found));
                }
            } else { //Error
                if(args.length == 1 && args[0].equalsIgnoreCase("help")) {
                    player.sendMessage(ColorCodes.translate(ColorCodes.help));
                } else {
                    player.sendMessage(ColorCodes.translate(ColorCodes.message_error));
                }
            }
        }

        return false;
    }
}
