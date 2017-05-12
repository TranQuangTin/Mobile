package QuangTin.com.homework03;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {

    //DATABASE db_records;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listview);

        //fake db
        List database = new DATABASE().dbList;

        CustomDatabaseAdapter adapter = new CustomDatabaseAdapter(this, database, R.layout.item_view);
        listView.setAdapter(adapter);
    }

}