package com.infinity.ec2;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EmotionCommands2 extends JavaPlugin {
	
	private static EmotionCommands2 instance;
	
	public static EmotionCommands2 getInstance(){
		return instance;
	}
	
	public void consoleBroadcast(String s){
		Bukkit.getServer().getLogger().info(s);
	}
	
	@Override
	public void onEnable(){
		consoleBroadcast("[EmotionCommands] The plugin has been enabled!");
		instance = this;
	}
	
	@Override
	public void onDisable(){
		consoleBroadcast("[EmotionCommands] The plugin has been disabled!");
		instance = null;
	}
	
	String ecs = ChatColor.GOLD + "[Emotion Commands]" + ChatColor.RESET;
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ecs + ChatColor.RED + "You must be a player to use this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("emotion")){
			if(p.hasPermission("EC.command")){
				if(args.length == 0){
					p.sendMessage(ecs + ChatColor.RED + "No emotion defined! Please use /emotion list for a list of emotions.");
					return true;
				}
				
				if(args[0].equalsIgnoreCase("fear")){
					if(p.hasPermission("EC.command.fear")){
						Bukkit.broadcastMessage(ChatColor.GRAY + p.getName() + " is feeling fearful...");
						return true;
					}else if(!p.hasPermission("EC.command.fear")){
						noPermMessage(p);
						return true;
					}
				}else if(args[0].equalsIgnoreCase("angry")){
					if(p.hasPermission("EC.command.angry")){
						Bukkit.broadcastMessage(ChatColor.DARK_RED + p.getName() + " is angry.. Watch out!");
						return true;
					}else if(!p.hasPermission("EC.command.angry")){
						noPermMessage(p);
						return true;
					}
				}else if(args[0].equalsIgnoreCase("sad")){
					if(p.hasPermission("EC.command.sad")){
						Bukkit.broadcastMessage(ChatColor.DARK_BLUE + p.getName() + " is sad...");
						return true;
					}else if(!p.hasPermission("EC.command.sad")){
						noPermMessage(p);
						return true;
					}
				}else if(args[0].equalsIgnoreCase("joy")){
					if(p.hasPermission("EC.command.joy")){
						Bukkit.broadcastMessage(ChatColor.YELLOW + p.getName() + " is feeling joyful!");
						return true;
					}else if(!p.hasPermission("EC.command.joy")){
						noPermMessage(p);
						return true;
					}
				}else if(args[0].equalsIgnoreCase("disgust")){
					if(p.hasPermission("EC.command.disgust")){
						Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + p.getName() + " is feeling disgusted.");
						return true;
					}else if(!p.hasPermission("EC.command.disgust")){
						noPermMessage(p);
						return true;
					}
				}else if(args[0].equalsIgnoreCase("anticipation")){
					if(p.hasPermission("EC.command.anticipation")){
						Bukkit.broadcastMessage(ChatColor.GOLD + p.getName() + " is feeling anticipation!");
						return true;
					}else if(!p.hasPermission("EC.command.anticipation")){
						noPermMessage(p);
						return true;
					}
				}else if(args[0].equalsIgnoreCase("suprised")){
					if(p.hasPermission("EC.command.suprised")){
						Bukkit.broadcastMessage(ChatColor.BLUE + p.getName() + " is feeling suprised!");
						return true;
					}else if(!p.hasPermission("EC.command.suprised")){
						noPermMessage(p);
						return true;
					}
				}else if(args[0].equalsIgnoreCase("relaxed")){
					if(p.hasPermission("EC.command.relaxed")){
						Bukkit.broadcastMessage(ChatColor.AQUA + p.getName() + " is feeling relaxed.");
						return true;
					}else if(!p.hasPermission("EC.command.relaxed")){
						noPermMessage(p);
						return true;
					}
				}else if(args[0].equalsIgnoreCase("facepalm")){
					if(p.hasPermission("EC.command.facepalm")){
						Bukkit.broadcastMessage(ChatColor.RED + p.getName() + " just facepalmed.");
						return true;
					}else if(!p.hasPermission("EC.command.facepalm")){
						noPermMessage(p);
						return true;
					}
				}else if(args[0].equalsIgnoreCase("list")){
					if(p.hasPermission("EC.command.list")){
						p.sendMessage("" + ChatColor.GOLD + "The commands are:");
						p.sendMessage("" + ChatColor.GRAY + "/emotion fear");
						p.sendMessage("" + ChatColor.DARK_RED + "/emotion angry");
						p.sendMessage("" + ChatColor.DARK_BLUE + "/emotion sad");
						p.sendMessage("" + ChatColor.YELLOW + "/emotion joy");
						p.sendMessage("" + ChatColor.LIGHT_PURPLE + "/emotion disgust");
						p.sendMessage("" + ChatColor.GOLD + "/emotion anticipation");
						p.sendMessage("" + ChatColor.BLUE + "/emotion suprised");
						p.sendMessage("" + ChatColor.AQUA + "/emotion relaxed");
						p.sendMessage("" + ChatColor.RED + "/emotion facepalm");
						return true; 
					}else if(!p.hasPermission("EC.command.list")){
						noPermMessage(p);
						return true;
					}
				}else if(!args[0].isEmpty()){
					p.sendMessage(ecs + ChatColor.RED + "Unrecognized emotion. To see a list of emotions, use /emotion list.");
					return true;
				}
			}else if(!p.hasPermission("EC.command")){
				noPermMessage(p);
				return true;
			}
			
		}
		
		return false;
	}
	
	public void noPermMessage(Player p){
		p.sendMessage(ecs + ChatColor.RED + " You don't have permission to use this command!");
	}

}
