package com.ren.pm;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length >= 1) {
                if(MessageCommand.reply_list.get(player.getPlayer()) != null) {
                    StringBuilder message = new StringBuilder();
                    Player target = MessageCommand.reply_list.get(player.getPlayer());
                    for (int i = 1; i < args.length; i++) {
                        message.append(args[i]).append(" ");
                    }
                    target.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + player.getDisplayName() +  " replied: " + ChatColor.RESET + message);
                    target.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§d§lYou got a Reply!"));
                    MessageCommand.reply_list.remove(player.getPlayer());
                } else {
                    player.sendMessage(ColorCodes.translate(ColorCodes.didnt_get_message));
                }
            } else {
                player.sendMessage(ColorCodes.translate(ColorCodes.please_write));
            }
        }
        return false;
    }
}