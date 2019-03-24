package P06_FootballTeamGenerator;

import java.security.InvalidParameterException;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new InvalidParameterException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (endurance < 0 || endurance > 100) {
            throw new InvalidParameterException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (sprint < 0 || sprint > 100) {
            throw new InvalidParameterException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (dribble < 0 || dribble > 100) {
            throw new InvalidParameterException("Dribble should be between 0 and 100.");
        }

        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (passing < 0 || passing > 100) {
            throw new InvalidParameterException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (shooting < 0 || shooting > 100) {
            throw new InvalidParameterException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.shooting + this.dribble + this.endurance + this.passing + this.sprint) / 5.0;
    }


}
