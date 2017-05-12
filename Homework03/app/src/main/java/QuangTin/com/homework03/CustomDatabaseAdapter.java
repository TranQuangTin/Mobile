package QuangTin.com.homework03;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomDatabaseAdapter extends BaseAdapter {

    Context context;
    int layoutToBeInflated;
    List<DATABASE.DbRecord> dbList;

    public CustomDatabaseAdapter(Context context, List<DATABASE.DbRecord> dbList, int resource) {
        this.context = context;
        this.dbList = dbList;
        layoutToBeInflated = resource;
    }

    @Override
    public int getCount() {
        return dbList.size();
    }

    @Override
    public DATABASE.DbRecord getItem(int i) {
        return dbList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final MyViewHolder holder;
        View row = view;

        if (row == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutToBeInflated, null);
            holder = new MyViewHolder();

            holder.tx1 = (TextView) row.findViewById(R.id.tx);
            holder.img = (ImageView) row.findViewById(R.id.img);
            holder.btnH = (Button) row.findViewById(R.id.btnHighRes);

            row.setTag(holder);
        } else {
            holder = (MyViewHolder) row.getTag();
        }

        DATABASE.DbRecord dbRec = getItem(i);
        holder.tx1.setText(dbRec.text);
        holder.img.setImageResource(dbRec.icon);

        holder.btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(context, "Loading Image...", Toast.LENGTH_SHORT);
                toast.show();
                gotoImage(i);
            }
        });

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(context, "Getting recipe...", Toast.LENGTH_SHORT);
                toast.show();
                goToURL(i);
            }
        });

        return row;
    }

    public void gotoImage(int id){
        //Meatball: http://images.media-allrecipes.com/userphotos/250x250/695024.jpg
        //Chicken: http://food.fnr.sndimg.com/content/dam/images/food/fullset/2010/12/14/1/EI1F02_Chicken-Parmesan_s4x3.jpg.rend.hgtvcom.616.462.jpeg
        //Pancake: http://food.fnr.sndimg.com/content/dam/images/food/fullset/2016/10/11/0/FNK_YOP-Green-Herb-Pancake-with-Ricotta-and-Red-Chile-Oil_s4x3.jpg.rend.hgtvcom.616.462.jpeg
        //Salmon: http://food.fnr.sndimg.com/content/dam/images/food/fullset/2011/8/23/0/BX0505H_roasted-salmon-with-green-herbs_s4x3.jpg.rend.hgtvcom.616.462.jpeg
        //Velvet: http://food.fnr.sndimg.com/content/dam/images/food/fullset/2013/11/27/0/FN_Red-Velvet-Heart-Pancakes_s4x3.jpg.rend.hgtvcom.616.462.jpeg
        //Pork: http://food.fnr.sndimg.com/content/dam/images/food/fullset/2012/4/11/0/0164738_02_pork-chops-on-grill_s4x3.jpg.rend.hgtvcom.616.462.jpeg

        String link="";

        switch (id){
            case 0:
                link = "http://assets.simplyrecipes.com/wp-content/uploads/2017/04/28144305/2017-05-10-Watercress-Salad-3.jpg";
                break;
            case 1:
                link = "http://assets.simplyrecipes.com/wp-content/uploads/2017/04/19163957/2017-05-08-FishStewGinger-6.jpg";
                break;
            case 2:
                link = "http://assets.simplyrecipes.com/wp-content/uploads/2016/05/lemon-meringue-pie-vertical-b-1600.jpg";
                break;
            case 3:
                link = "http://assets.simplyrecipes.com/wp-content/uploads/2015/03/spinach-artichoke-quiche-closeup-vertical-600.jpg";
                break;

        }

        //Chrome custom tabs
        //CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        //CustomTabsIntent customTabsIntent = builder.build();
        //customTabsIntent.launchUrl(context, Uri.parse(link));

        //Web browser
        Uri uri = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

    public void goToURL(int id){
        //Chicken: http://www.foodnetwork.com/recipes/giada-de-laurentiis/chicken-parmesan-recipe
        //Meatball: http://allrecipes.com/recipe/217899/mozzarella-stuffed-pesto-turkey-meatballs/?internalSource=staff%20pick&referringContentType=home%20page&clickId=cardslot%203
        //Pancake: http://www.foodnetwork.com/recipes/food-network-kitchen/green-herb-pancakes-with-ricotta-and-red-chile-oil
        //Salmon: http://www.foodnetwork.com/recipes/ina-garten/roasted-salmon-with-green-herbs-recipe
        //Velvet: http://www.foodnetwork.com/recipes/food-network-kitchen/red-velvet-heart-pancakes
        //Pork: http://www.foodnetwork.com/recipes/patrick-and-gina-neely/shake-n-shimmy-pork-chops-recipe

        String link="";

        switch (id){
            case 0:
                link = "http://www.simplyrecipes.com/recipes/watercress_salad_with_strawberries_and_feta/";
                break;
            case 1:
                link = "http://www.simplyrecipes.com/recipes/fish_stew_with_ginger_and_tomatoes/";
                break;
            case 2:
                link = "http://www.simplyrecipes.com/recipes/lemon_meringue_pie/";
                break;
            case 3:
                link = "http://www.simplyrecipes.com/recipes/spinach_and_artichoke_quiche/";
                break;

        }

        //Chrome custom tabs
        //CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        //CustomTabsIntent customTabsIntent = builder.build();
        //customTabsIntent.launchUrl(context, Uri.parse(link));

        //Web browser
        Uri uri = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }


}
