package P04_FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int players = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < players; i++) {
            String[] input = reader.readLine().split("\\s+");
            Person person = new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
            people.add(person);
        }

        Team team = new Team("Minior");

        for (Person person : people) {
            team.addPlayer(person);
        }

        System.out.println(team.getFirstTeam().size());
        System.out.println(team.getReserveTeam().size());
    }
}
