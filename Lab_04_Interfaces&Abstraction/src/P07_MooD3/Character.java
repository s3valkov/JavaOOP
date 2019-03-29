package P07_MooD3;

public abstract class Character<T> implements GameObject<T> {
    private String username;
    private String characterType;
    private int level;
    private Number specialPoints;
    private T hashedPassword;

    public Character(String username, String characterType, int level, Number specialPoints) {
        this.setUsername(username);
        this.setCharacterType(characterType);
        this.setLevel(level);
        this.setSpecialPoints(specialPoints);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getCharacterType() {
        return characterType;
    }

    @Override
    public Number getSpecialPoints() {
        return specialPoints;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSpecialPoints(Number specialPoints) {
        this.specialPoints = specialPoints;
    }

    @Override
    public T getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public void setHashedPassword(T password) {
        this.hashedPassword = password;
    }

    @Override
    public String toString() {
        return String.format("%s | %s -> %s",
                "\"" + this.getUsername() + "\"",
                "\"" + this.getHashedPassword() + "\"",
                this.getCharacterType());
    }


}
