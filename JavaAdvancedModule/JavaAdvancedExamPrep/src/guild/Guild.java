package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    List<Player> roster;
    String name;
    int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public int count() {
        return roster.size();
    }

    public boolean removePlayer(String name) {
        Player player = getPlayerByName(name);

        if (player != null) {
            roster.remove(player);
            return true;
        }

        return false;
    }

    public void promotePlayer(String name) {
        Player player = getPlayerByName(name);

        player.setRank("Member");
    }

    public void demotePlayer(String name) {
        Player player = getPlayerByName(name);

        player.setRank("Trial");
    }

    public Player getPlayerByName(String name) {
        return roster.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removed = roster.stream()
                .filter(p -> p.getClazz().equals(clazz))
                .collect(Collectors.toList());

        roster.removeAll(removed);
        return removed.toArray(new Player[0]);
    }

    public String report() {
        return String.format("Players in the guild: %s:%n%s", name,
                roster.stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
        ).trim();
    }
}
