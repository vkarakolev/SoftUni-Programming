import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E04_Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] songData = scanner.nextLine().split("_");

            Song s = new Song();

            s.setTypeList(songData[0]);
            s.setName(songData[1]);
            s.setTime(songData[2]);

            songs.add(s);
        }

        String printTypeList = scanner.nextLine();

        if(printTypeList.equals("all")){
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if(song.getTypeList().equals(printTypeList)){
                    System.out.println(song.getName());
                }
            }

        }

    }

    static class Song {
        String typeList;
        String name;
        String time;

        public String getTypeList() {
            return typeList;
        }

        public String getName() {
            return name;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
