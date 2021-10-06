import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Scanner;

public class RPG implements game_vars {
    public static void main(String[] args) throws SQLException {

        //Decoration
        System.out.println(title);
        System.out.println(about);


        //Start
        Start();

    }

    public static void Start() throws SQLException {
        Character current_player;
        Scanner sc = new Scanner(System.in);
        Connection conn = DriverManager.getConnection(URL, username, password);
        PreparedStatement preparedStatement;
        Statement statement;
        ResultSet result;

        System.out.println(start_message);

        char choice = sc.next().toLowerCase().charAt(0);

        if (choice == 'y') {

            System.out.println(enter_new_name);
            String name = sc.next().toUpperCase();
            System.out.println(enter_new_UID);
            String UID = sc.next();
            current_player = new Character(name, UID);

            //SQL for player_data.
            preparedStatement = conn.prepareStatement(query_1);
            preparedStatement.setString(1, current_player.getName());
            preparedStatement.setInt(2, current_player.getAtk());
            preparedStatement.setInt(3, current_player.getDef());
            preparedStatement.setInt(4, current_player.getMoney());
            preparedStatement.setInt(5, current_player.getXp());
            preparedStatement.setInt(6, current_player.getLevel());
            preparedStatement.setInt(7, current_player.getHealth());
            preparedStatement.setInt(8, current_player.getEnergy());
            int key = preparedStatement.executeUpdate();
            if (key > 0) {


                Notification(player_loaded);
            }

            //SQL for verify_player.
            preparedStatement = conn.prepareStatement(query_2);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, UID);
            key = preparedStatement.executeUpdate();
            if (key > 0) {


                Notification(database_updated);

                //Load Player;
                current_player = loadPlayer(name, UID, conn);
                System.out.println("Player " + current_player.getName() + "(Lv " + current_player.getLevel() + ") loaded.");

                //Display Menu;
                displayMenu(current_player, conn);

            }

        } else if (choice == 'n') {

            System.out.println(enter_name);
            String name = sc.next().toUpperCase();

            System.out.println(enter_UID);
            String UID = sc.next();

            statement = conn.createStatement();
            result = statement.executeQuery(query_3 + "'" + name + "'");

            if (result.next()) {

                if (result.getString("player_name").equals(name)) {

                    if (result.getString("player_id").equals(UID)) {

                        //Load Player;
                        current_player = loadPlayer(name, UID, conn);
                        System.out.println("Player " + current_player.getName() + "(Lv " + current_player.getLevel() + ") loaded.");

                        //Display Menu;
                        displayMenu(current_player, conn);

                    } else {

                        Notification(UID_error);
                        Start();
                    }
                } else {

                    Notification(name_error);
                    Start();
                }
            }

        }
    }

    public static Character loadPlayer(String name, String UID, Connection conn) throws SQLException {
        Character player = null;
        int atk, def, money, xp, level, health, energy;
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(query_4 + "'" + name + "'");
        if (result.next()) {
            atk = result.getInt("atk");
            def = result.getInt("def");
            money = result.getInt("money");
            xp = result.getInt("xp");
            level = result.getInt("level");
            health = result.getInt("health");
            energy = result.getInt("energy");


            player = new Character(atk, def, energy, xp, level, money, health, name, UID);
        }
        return player;

    }

    public static void displayMenu(Character player, Connection connection) throws SQLException {
        System.out.println(menu_bar_graphics);
        System.out.println(menu_train_graphic);
        System.out.println(menu_fight_graphic);
        System.out.println(menu_shop_graphic);
        System.out.println("*****************************************************\n");
        System.out.println("*                       STATS                       *");
        System.out.println("* ------------------------------------------------- *");
        System.out.println("* Level : "+player.getLevel());
        System.out.println("* Money : "+player.getMoney());
        System.out.println("* Attack Power : "+player.getAtk());
        System.out.println("* Defense Power : "+player.getDef());
        System.out.println("* ------------------------------------------------- *\n\n");



        int i = choiceGate();
        if (i == 1) {
            gameTrain(player, connection);
        } else if (i == 2) {
            gameFight(player, connection);
        } else if (i == 3) {
            gameShop(player, connection);
        } else if (i == 4) {
            onClose(player, connection);
        }
        else{
            Notification(menu_choice_error);
            displayMenu(player, connection);
        }
    }

    public static int choiceGate() {
        Scanner sc = new Scanner(System.in);
        System.out.println(menu_choice);
        return sc.nextInt();
    }

    public static void gameTrain(Character character, Connection connection) throws SQLException {

        int level = character.getLevel();
        int xp = character.getXp();
        int energy = character.getEnergy();

        if (energy >= train_energy_cost) {

            energy = energy - train_energy_cost;
            int newXP = randomizer(train_min_xp,train_max_xp);
            character.setXp(xp);

            if (character.getLevel() > level) levelUp(character);

            character.setEnergy(energy);

            if (newXP <= 150) {

                Notification(character.getName() + " got tired very easily. He earned only " + newXP + " XP!");

            } else if (newXP <= 400) {

                String msg = (character.getName() + " trained hard. He earned " + newXP + " XP!");
                Notification(msg);

            } else if (newXP <= 600) {

                String msg = (character.getName() + " trained extremely hard. He earned a whopping " + newXP + " XP!");
                Notification(msg);

            }
        } else {

            Notification(low_energy);

        }

        displayMenu(character, connection);
    }

    public static void gameFight(@NotNull Character player, Connection connection) throws SQLException {
        Character opponent = null;
        int atk, def, money, xp, level, health, energy;
        String name;
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet result = statement.executeQuery(query_5 + "'" + player.getName() + "'");
        int count = 0;
        while (result.next()) {
            ++count;
        }
        int key = randomizer(1,count);
        if (result.absolute(key)) {
            name = result.getString("player_name");
            atk = result.getInt("atk");
            def = result.getInt("def");
            money = result.getInt("money");
            xp = result.getInt("xp");
            level = result.getInt("level");
            health = result.getInt("health");
            energy = result.getInt("energy");


            opponent = new Character(atk, def, energy, xp, level, money, health, name);
        }
        assert opponent != null;
        System.out.println("Your opponent is " + opponent.getName());

        //FIGHT LOGIC
        int toss; //this will be used to find who strikes first


        toss = randomizer(0,1);

        while (player.getHealth() > 0 && opponent.getHealth() > 0) {
            if (toss == 0) {
                int opponent_def = opponent.getDef();
                int player_atk = player.getAtk();

                player_atk = randomizer(0, player_atk);
                opponent_def = randomizer(0, opponent_def);

                System.out.println(player.getName() + " strikes!");

                if (player_atk > opponent_def) {

                    int damage = player_atk - opponent_def;
                    toss = 1;
                    opponent.setHealth(opponent.getHealth() - damage);

                    System.out.println(player.getName() + " inflicted " + damage + " damage to " + opponent.getName() + " (" + opponent.getHealth() + ")");
                } else {
                    System.out.println(player.getName() + " couldn't damage " + opponent.getName());
                    toss = 1;
                }



            } else if (toss == 1) {
                int player_def = player.getDef();
                int opponent_atk = opponent.getAtk();

                player_def = randomizer(0, player_def);
                opponent_atk = randomizer(0, opponent_atk);

                System.out.println(opponent.getName() + " strikes!");

                if (opponent_atk > player_def) {

                    int damage = opponent_atk - player_def;
                    toss = 0;
                    player.setHealth(player.getHealth() - damage);

                    System.out.println(opponent.getName() + " inflicted " + damage + " damage to " + player.getName() + " (" + player.getHealth() + ")");
                } else {
                    System.out.println(opponent.getName() + " couldn't damage " + player.getName());
                    toss = 0;
                }
            }
        }
        if (player.getHealth() <= 0) {

            int win_xp = randomizer(fight_win_min_xp,fight_win_max_xp);
            int win_money = randomizer(fight_win_min_money,fight_win_max_money);
            int lose_xp = player.getXp() - fight_lose_xp_fixed;

            opponent.setXp(win_xp + opponent.getXp());
            opponent.setMoney(win_money + opponent.getMoney());
            player.setXp(lose_xp);

            String highlight = opponent.getName() + " defeated " + player.getName() + "!\n Opponent earned " + win_xp + " XP and " + win_money + " coins!";
            Notification(highlight);

        } else {
            int playerLevel = player.getLevel();
            int win_xp = randomizer(fight_win_min_xp,fight_win_max_xp);
            int win_money = randomizer(fight_win_min_money,fight_win_max_money);
            int lose_xp = opponent.getXp() - fight_lose_xp_fixed;

            player.setXp(win_xp + player.getXp());
            player.setMoney(win_money + player.getMoney());
            opponent.setXp(lose_xp);

            if (player.getLevel() > playerLevel) levelUp(player);


            String highlight = player.getName() + " defeated " + opponent.getName() + "!\n You earned " + win_xp + " XP and " + win_money + " coins!";
            Notification(highlight);
        }

        player.setHealth(100); //Re-initialise health parameter for future duels.
        opponent.setHealth(100);

        PreparedStatement preparedStatement = connection.prepareStatement(query_6 + "'" + player.getName() + "'");
        PreparedStatement preparedStatement_2 = connection.prepareStatement(query_6 + "'" + opponent.getName() + "'");

        preparedStatement.setInt(1, player.getAtk());
        preparedStatement.setInt(2, player.getDef());
        preparedStatement.setInt(3, player.getMoney());
        preparedStatement.setInt(4, player.getXp());
        preparedStatement.setInt(5, player.getLevel());
        preparedStatement.setInt(6, player.getHealth());
        preparedStatement.setInt(7, player.getEnergy());

        preparedStatement_2.setInt(1, opponent.getAtk());
        preparedStatement_2.setInt(2, opponent.getDef());
        preparedStatement_2.setInt(3, opponent.getMoney());
        preparedStatement_2.setInt(4, opponent.getXp());
        preparedStatement_2.setInt(5, opponent.getLevel());
        preparedStatement_2.setInt(6, opponent.getHealth());
        preparedStatement_2.setInt(7, opponent.getEnergy());

        int a = preparedStatement.executeUpdate();
        int b = preparedStatement_2.executeUpdate();
        if (a > 0 && b > 0) {
            displayMenu(player, connection);
        }

    }

    public static void gameShop(Character character, Connection connection) throws SQLException {
         Scanner sc = new Scanner(System.in);
         System.out.println(shop_menu_title);
         System.out.println(shop_options);
         int i = sc.nextInt();
         if(i == 1){

             character.setEnergy(character.getEnergy()+shop_energy_1);
             character.setMoney(character.getMoney() - 150);
             Notification("Thank you for purchasing Potion of Energy I");

         }
         else if(i == 2){

             character.setEnergy(character.getEnergy()+shop_energy_2);
             character.setMoney(character.getMoney() - 220);
             Notification("Thank you for purchasing Potion of Energy II");

         }
         else if(i == 3){

             character.setAtk(character.getAtk()+shop_attack_1);
             character.setMoney(character.getMoney() - 180);
             Notification("Thank you for purchasing Potion of Attack I");

         }
         else if(i == 4){

             character.setAtk(character.getAtk()+shop_attack_2);
             character.setMoney(character.getMoney() - 300);
             Notification("Thank you for purchasing Potion of Attack II");

         }
         else if(i == 5){

             character.setDef(character.getDef()+shop_def_1);
             character.setMoney(character.getMoney() - 200);
             Notification("Thank you for purchasing Potion of Defence I");

         }
         else if(i == 6){

             character.setDef(character.getDef()+shop_def_2);
             character.setMoney(character.getMoney() - 350);
             Notification("Thank you for purchasing Potion of Defence II");

         }
         else{
             Notification(shop_choice_error);
         }

         displayMenu(character, connection);

    }

    public static void levelUp(Character player) {

        int atk = player.getAtk();
        atk = atk + lvlup_atk;
        player.setAtk(atk);

        int def = player.getDef();
        def = def + lvlup_def;
        player.setDef(def);


        String congratulations = "Congratulations! " + player.getName() + " levelled up! Current level : " + player.getLevel();
        Notification(congratulations);

    }

    public static void onClose(Character current_player, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query_6 + "'" + current_player.getName() + "'");
        preparedStatement.setInt(1, current_player.getAtk());
        preparedStatement.setInt(2, current_player.getDef());
        preparedStatement.setInt(3, current_player.getMoney());
        preparedStatement.setInt(4, current_player.getXp());
        preparedStatement.setInt(5, current_player.getLevel());
        preparedStatement.setInt(6, current_player.getHealth());
        preparedStatement.setInt(7, current_player.getEnergy());

        int key = preparedStatement.executeUpdate();
        if (key > 0) {
            Notification(player_saved);
        }
        System.out.println(end_message);

        connection.close();

    }

    public static int randomizer(int min, int max){
        return (min + (int)((Math.random()*(max-min)+1)));
    }

    public static void Notification(String message){

        int i = 1;
        int msg_len = message.length();
        int decor = (int)(msg_len * 0.25);
        int length = 2*decor + msg_len;
        while(i <= length){
            System.out.print("*");
            i++;
        }
        i = 1;
        System.out.println();
        while(i <= decor){
            System.out.print(" ");
            i++;
        }
        i = 1;

        System.out.print(message); //message

        while(i <= decor){
            System.out.print(" ");
            i++;
        }
        i = 1;
        System.out.println();
        while(i <= length){
            System.out.print("*");
            i++;
        }
        System.out.println("\n\n");

    }

}
