package P06_FootballTeamGenerator;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team() {
        this.players = new ArrayList<>();
    }

    public Team(String name) {
        this();
        this.setName(name);
    }

    private void setName(String name) {
        if (name.trim().equals("") || name == null) {
            throw new InvalidParameterException("A name should not be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String name) {
        Player playerToRemove = this.players.stream().filter(p -> p.getName().equals(name)).findFirst().orElseThrow(InvalidParameterException::new);
        players.remove(playerToRemove);
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %.f", this.name, getRating());
    }
}
