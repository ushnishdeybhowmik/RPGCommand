public interface game_vars {

    //SQL CONNECTION
    String URL = "jdbc:mysql://localhost:3306/hoshi_saga";
    String username = "root";
    String password = "delta#123";

    //TITLE DECORATION
    String title = "\n\n\n             ██╗░░██╗░█████╗░░██████╗██╗░░██╗██╗        ░██████╗░█████╗░░██████╗░░█████╗░             \n" +
            "             ██║░░██║██╔══██╗██╔════╝██║░░██║██║        ██╔════╝██╔══██╗██╔════╝░██╔══██╗             \n" +
            "             ███████║██║░░██║╚█████╗░███████║██║        ╚█████╗░███████║██║░░██╗░███████║             \n" +
            "             ██╔══██║██║░░██║░╚═══██╗██╔══██║██║        ░╚═══██╗██╔══██║██║░░╚██╗██╔══██║             \n" +
            "             ██║░░██║╚█████╔╝██████╔╝██║░░██║██║        ██████╔╝██║░░██║╚██████╔╝██║░░██║             \n" +
            "             ╚═╝░░╚═╝░╚════╝░╚═════╝░╚═╝░░╚═╝╚═╝        ╚═════╝░╚═╝░░╚═╝░╚═════╝░╚═╝░░╚═╝             ";
    String about = "\n\nWelcome to a world of Magic. Fight your way through other characters and become the King of this Chaos.\n" +
            ".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n" +
            ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Made with love by VULC4N<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n";


    //MENU
    String menu_bar_graphics = "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
            "██ ▄▄ █ ▄▄▀██ ▄▀▄ ██ ▄▄▄████ ▄▀▄ ██ ▄▄▄██ ▀██ ██ ██ █\n" +
            "██ █▀▀█ ▀▀ ██ █ █ ██ ▄▄▄████ █ █ ██ ▄▄▄██ █ █ ██ ██ █\n" +
            "██ ▀▀▄█ ██ ██ ███ ██ ▀▀▀████ ███ ██ ▀▀▀██ ██▄ ██▄▀▀▄█\n" +
            "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n";

    String menu_train_graphic = "                  ░▀█▀▒█▀▄▒▄▀▄░█░█▄░█                \n" +
            "                  ░▒█▒░█▀▄░█▀█░█░█▒▀█                \n";

    String menu_fight_graphic = "                   ▒█▀░█░▄▀▒░█▄█░▀█▀                 \n" +
            "                   ░█▀░█░▀▄█▒█▒█░▒█▒                 \n";

    String menu_shop_graphic = "                   ░▄▀▀░█▄█░▄▀▄▒█▀▄                  \n" +
            "                   ▒▄██▒█▒█░▀▄▀░█▀▒                  \n";


    //SHOP
    String shop_menu_title = "                         .▄▄ ·  ▄ .▄       ▄▄▄·                         \n" +
            "                         ▐█ ▀. ██▪▐█ ▄█▀▄ ▐█ ▄█                         \n" +
            "                         ▄▀▀▀█▄██▀▀█▐█▌.▐▌ ██▀·                         \n" +
            "                         ▐█▄▪▐███▌▐▀▐█▌.▐▌▐█▪·•                         \n" +
            "                          ▀▀▀▀ ▀▀▀ · ▀█▄▀▪.▀                            \n";

    String shop_options = "                    [1] Potion of Energy I - 150 coins\n                    [2] Potion of Energy II - 220 coins\n                    [3] Potion of Attack I - 180 coins\n                    [4] Potion of Attack II - 300 coins\n                    [5] Potion of Defense I - 200 coins\n                    [6] Potion of Defense II - 350 coins";


    //END
    String end_message = "    ████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗    ██╗   ██╗ ██████╗ ██╗   ██╗\n" +
                         "    ╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝    ╚██╗ ██╔╝██╔═══██╗██║   ██║\n" +
                         "       ██║   ███████║███████║██╔██╗ ██║█████╔╝      ╚████╔╝ ██║   ██║██║   ██║\n" +
                         "       ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗       ╚██╔╝  ██║   ██║██║   ██║\n" +
                         "       ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗       ██║   ╚██████╔╝╚██████╔╝\n" +
                         "       ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝       ╚═╝    ╚═════╝  ╚═════╝ \n";

    //SQL QUERIES
    String query_1 = "INSERT INTO player_data(player_name,atk,def,money,xp,level,health,energy) VALUES(?,?,?,?,?,?,?,?)";
    String query_2 = "INSERT INTO verify_player(player_name,player_id) VALUES(?,?)";
    String query_3 = "SELECT * FROM verify_player WHERE player_name = ";
    String query_4 = "SELECT * FROM player_data WHERE player_name = ";
    String query_5 = "SELECT * FROM player_data WHERE player_name <> ";
    String query_6 = "UPDATE player_data SET atk = ?, def = ?, money = ?, xp = ?, level = ?, health = ?, energy = ? WHERE player_name = ";

    //MISC
    String menu_choice = "TYPE [1] FOR TRAINING, [2] FOR FIGHT, [3] FOR SHOP, [4] FOR QUIT";
    String menu_choice_error = "You gotta know your ABCs, kid";             //error_message
    String name_error = "Name doesn't exist.";                              //error_message
    String UID_error = "UID is incorrect";                                  //error_message
    String shop_choice_error = "Numbers kid, numbers....SMH";               //error_message
    String enter_name = "Enter Player Name";
    String enter_UID = "Enter UID";
    String player_loaded = "New player loaded.";
    String database_updated = "Database updated";
    String enter_new_name = "\n\nEnter new Character name";
    String enter_new_UID = "\nEnter UID. [This will be used as a password]";
    String start_message = "\n\nARE YOU NEW HERE?\n\nTYPE Y for [YES] and N for [NO]";
    String player_saved = "Player data saved.";

    //GAME-NUMERIC-VARS
    int train_min_xp =        20;                    //minimum XP earned through training
    int train_max_xp =        600;                   //maximum XP earned through training
    int train_energy_cost =   85;                    //energy cost for training
    int lvlup_atk =           25;                    //attack  increment on level up.
    int lvlup_def =           25;                    //defense increment on level up.
    int fight_win_max_xp =    180;                   //maximum xp earned by winning a fight.
    int fight_win_min_xp =    50;                    //minimum xp earned by winning a fight.
    int fight_win_max_money = 500;                   //maximum money earned by winning a fight.
    int fight_win_min_money = 75;                    //minimum money earned by winning a fight.
    int fight_lose_xp_fixed = 50;                    //fixed decrement in xp by losing a fight.
    int shop_energy_1 =       150;                   //Energy   I   item.
    int shop_energy_2 =       350;                   //Energy   II  item.
    int shop_attack_1 =       35;                    //Attack   I   item.
    int shop_attack_2 =       60;                    //Attack   II  item.
    int shop_def_1 =          30;                    //Defence  I   item.
    int shop_def_2 =          55;                    //Defence  II  item.


    //GAME-STRING-VARS
    String low_energy = "You don't have much energy left! Go to shop and buy some potions!";
}
