package slimebukkit.slimebukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class SlimeCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            int xPos = player.getLocation().getChunk().getX();
            int zPos = player.getLocation().getChunk().getZ();
            long seed = player.getWorld().getSeed();

            Random rnd = new Random(
                    seed +
                            (int) (xPos * xPos * 0x4c1906) +
                            (int) (xPos * 0x5ac0db) +
                            (int) (zPos * zPos) * 0x4307a7L +
                            (int) (zPos * 0x5f24f) ^ 0x3ad8025fL
            );

            boolean isSlimeChunk = (rnd.nextInt(10) == 0);

            if (isSlimeChunk) {
                player.sendMessage("Chunk " + xPos + ", " + zPos + " is a slime chunk");
            } else {
                player.sendMessage("Chunk " + xPos + ", " + zPos + " is NOT a slime chunk");
            }
            player.sendMessage("seed: " + seed);
        }

        return true;
    }
}
