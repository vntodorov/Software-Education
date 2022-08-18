package ObjectsAndClassesLAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {

    static class Song {
        String type;
        String name;
        String time;

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int songsNum = Integer.parseInt(scanner.nextLine());
        List<Song> songsList = new ArrayList<>();
        for (int i = 1; i <= songsNum; i++) {
            String[] songArray = scanner.nextLine().split("_");
            String type = songArray[0];
            String name = songArray[1];
            String time = songArray[2];
            Song currentSong = new Song();
            currentSong.setType(type);
            currentSong.setName(name);
            currentSong.setTime(time);
            songsList.add(currentSong);
        }
        String command = scanner.nextLine();
        if (command.equals("all")) {
            for (Song name : songsList) {
                System.out.println(name.getName());

            }
        } else {
            for (Song name : songsList) {
                if (name.getType().equals(command)) {
                    System.out.println(name.getName());
                }
            }
        }
    }
}
