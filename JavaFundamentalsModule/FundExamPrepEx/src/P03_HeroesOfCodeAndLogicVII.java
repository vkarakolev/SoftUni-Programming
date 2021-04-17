import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Map<String, Hero> party = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] heroData = scanner.nextLine().split("\\s+");
            Hero h = new Hero(heroData[0], Integer.parseInt(heroData[1]), Integer.parseInt(heroData[2]));
            party.put(h.getName(), h);
        }

        String command = scanner.nextLine();
        while(!command.equals("End")){
            String[] commandData = command.split(" - ");
            String heroName = commandData[1];

            switch (commandData[0]){
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(commandData[2]);
                    String spell = commandData[3];

                    if(mpNeeded <= party.get(heroName).getMp()){
                        int currentMP = party.get(heroName).getMp() - mpNeeded;
                        party.get(heroName).setMp(currentMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spell, currentMP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spell);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandData[2]);
                    String attacker = commandData[3];

                    if(damage < party.get(heroName).getHp()){
                        int currentHP = party.get(heroName).getHp() - damage;
                        party.get(heroName).setHp(currentHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP);
                    } else {
                        party.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int mpAmount = Integer.parseInt(commandData[2]);
                    if(party.get(heroName).getMp() + mpAmount <= 200){
                        int currentMP = party.get(heroName).getMp() + mpAmount;
                        party.get(heroName).setMp(currentMP);
                    } else {
                        mpAmount = 200 - party.get(heroName).getMp();
                        party.get(heroName).setMp(200);
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, mpAmount);
                    break;
                case "Heal":
                    int hpAmount = Integer.parseInt(commandData[2]);
                    if(party.get(heroName).getHp() + hpAmount <= 100){
                        int currentHP = party.get(heroName).getHp() + hpAmount;
                        party.get(heroName).setHp(currentHP);
                    } else {
                        hpAmount = 100 - party.get(heroName).getHp();
                        party.get(heroName).setHp(100);
                    }
                    System.out.printf("%s healed for %d HP!%n", heroName, hpAmount);
                    break;
            }

            command = scanner.nextLine();
        }

        party.values()
                .stream()
                .sorted((a, b) -> {
                    if(b.getHp() != a.getHp()){
                        return (Integer.compare(b.getHp(), a.getHp()));
                    } else {
                        return (a.getName().compareTo(b.getName()));
                    }
                })
                .map(e -> String.format("%s%n  HP: %d%n  MP: %d", e.getName(), e.getHp(), e.getMp()))
                .forEach(System.out::println);
    }

    static class Hero{
        String name;
        int hp;
        int mp;

        public Hero(String name, int hp, int mp) {
            this.name = name;
            this.hp = hp;
            this.mp = mp;
        }

        public String getName() {
            return name;
        }

        public int getMp() {
            return mp;
        }

        public void setMp(int mp) {
            this.mp = mp;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }
    }
}
