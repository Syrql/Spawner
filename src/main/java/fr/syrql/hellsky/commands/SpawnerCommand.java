package fr.syrql.hellsky.commands;

import fr.syrql.hellsky.Hell;
import fr.syrql.hellsky.utils.command.ACommand;
import org.bukkit.command.CommandSender;

public class SpawnerCommand extends ACommand {
    private final Hell hell;
    public SpawnerCommand(Hell hell) {
        super(hell, "spawner", "command.spawner", true);
        this.hell = hell;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        return false;
    }
}
