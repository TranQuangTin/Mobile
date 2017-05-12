package QuangTin.com.homework03;

import java.util.ArrayList;

/**
 * Created by mac on 2/16/17.
 */

public class DATABASE {

    public String[] text = {"Watercress Salad ",
            "Fish Stew", "Lemon Meringue Pie", "Spinach and Artichoke Quiche",
    };
    public Integer[] icon = {R.drawable.salad, R.drawable.fishstew, R.drawable.lemon,R.drawable.spinach
   };

    public class DbRecord {
        public String text;
        public Integer icon;

        public DbRecord(String text, Integer icon) {
            this.text = text;
            this.icon = icon;
        }
    }

    public ArrayList<DbRecord> dbList = new ArrayList<DbRecord>();

    public DATABASE(){
        for (int i=0; i<text.length; i++){
            dbList.add(new DbRecord(text[i], icon[i]));
        }
    }
}
