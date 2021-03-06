package chapter07.recipe7_13;

import java.util.ArrayList;
import java.util.List;

public class TeamInner {
    private Player player;
    private List<Player> playerList;
    private int size = 4;

    // Inner class representing a Player object
    class Player {
        private String firstName = null;
        private String lastName = null;
        private String position = null;
        private int status = -1;

        public Player() { }

        public Player(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        protected String playerStatus() {
            String returnValue = null;
            switch (getStatus()) {
                case 0:
                    returnValue = "ACTIVE";
                    break;
                case 1:
                    returnValue = "INACTIVE";
                    break;
                case 2:
                    returnValue = "INJURY";
                    break;
                default:
                    returnValue = "ON_BENCH";
            }
            return returnValue;
        }

        public String playerString() { return getFirstName() + " " + getLastName() + " - " + getPosition(); }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            if (firstName.length() > 30)
                this.firstName = firstName.substring(0, 29);
            else
                this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

    public TeamInner() {
        playerList = new ArrayList();
        playerList.add(constructPlayer("Josh", "Juneau", "Right Wing", 0));
        playerList.add(constructPlayer("Carl", "Dea", "Left Wing", 0));
        playerList.add(constructPlayer("Mark", "Beaty", "Center", 0));
        playerList.add(constructPlayer("Jonathan", "Gennick", "Goalie", 0));
    }

    public Player constructPlayer(String first, String last, String position, int status) {
        Player player = new Player();
        player.firstName = first;
        player.lastName = last;
        player.position = position;
        player.status = status;
        return player;
    }

    public List<Player> getPlayerList() { return this.playerList; }

    public static void main(String[] args) {
        TeamInner inner = new TeamInner();
        System.out.println("Team Roster");
        System.out.println("===========");
        for (Player player : inner.getPlayerList()) {
            System.out.println(player.playerString());
        }
    }

}
