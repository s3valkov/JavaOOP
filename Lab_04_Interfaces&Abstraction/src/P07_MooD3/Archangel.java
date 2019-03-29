package P07_MooD3;

public class Archangel extends Character<String> implements GameObject<String> {
    private static String CHARACTER_TYPE = "Archangel";

    public Archangel(String username, int level, Integer specialPoints) {
        super(username, CHARACTER_TYPE, level, specialPoints);
        this.setHashedPassword(generatePassword());
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", super.toString(), super.getSpecialPoints().intValue() * super.getLevel());
    }

    private String generatePassword() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getUsername());
        sb = sb.reverse();
        sb.append("\"");
        sb.insert(0,"\"");
        sb.append((super.getUsername().length() + 2) * 21);

        return sb.toString();
    }
}
