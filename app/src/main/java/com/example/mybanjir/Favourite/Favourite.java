package com.example.mybanjir.Favourite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mybanjir.Database.Basin;
import com.example.mybanjir.Database.Favourites;
import com.example.mybanjir.Database.Location;
import com.example.mybanjir.Database.Rainfall;
import com.example.mybanjir.Database.Saved;
import com.example.mybanjir.Database.Waterlvl;
import com.example.mybanjir.DatabaseTool.DBHandler;
import com.example.mybanjir.R;

/*
    - Favourite Activity -

    Display all favourite locations and provide interface to add/remove favourites
 */
public class Favourite extends AppCompatActivity {
    public static boolean changesmade = false;
    static Favourite favAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        favAct = Favourite.this;
        setFav();
    }

    /*
        Instantiate Event Handler when clickable views are clicked
     */
    public void Clicked(View v){
        FavouriteEventHandler handler = new FavouriteEventHandler(v, Favourite.this, getApplicationContext());
    }

    /*
        if changes are made to favourites, update page
     */
    @Override
    protected void onResume() {
        super.onResume();
        if(changesmade){
            setFav();
            changesmade = false;
        }
    }

    /*
        Change layout to editing mode
     */
    public void editMode(){
        TextView remove1 = (TextView) findViewById(R.id.Fav1Remove);
        TextView remove2 = (TextView) findViewById(R.id.Fav2Remove);
        TextView remove3 = (TextView) findViewById(R.id.Fav3Remove);
        ImageView addbutton = (ImageView) findViewById(R.id.AddFav);
        TextView editbutton = (TextView) findViewById(R.id.EditFav);
        ConstraintLayout fav1box = (ConstraintLayout) findViewById(R.id.Fav1);
        ConstraintLayout fav2box = (ConstraintLayout) findViewById(R.id.Fav2);
        ConstraintLayout fav3box = (ConstraintLayout) findViewById(R.id.Fav3);

        editbutton.setText("Cancel");

        remove1.setVisibility(View.VISIBLE);
        remove2.setVisibility(View.VISIBLE);
        remove3.setVisibility(View.VISIBLE);
        addbutton.setVisibility(View.GONE);
        fav1box.setClickable(false);
        fav2box.setClickable(false);
        fav3box.setClickable(false);
   }

    /*
        Create layout of page based on database
     */
    public void setFav(){
        DBHandler dbh = new DBHandler(getApplicationContext());
        Saved saved = dbh.findSaved("Favourites");
        int savedvalue = saved.getValue();

        // Get views
        TextView favedit = (TextView) findViewById(R.id.EditFav);
        ImageView favadd = (ImageView) findViewById(R.id.AddFav);
        ConstraintLayout fav1container = (ConstraintLayout) findViewById(R.id.Fav1);
        ConstraintLayout fav2container = (ConstraintLayout) findViewById(R.id.Fav2);
        ConstraintLayout fav3container = (ConstraintLayout) findViewById(R.id.Fav3);
        TextView remove1 = (TextView) findViewById(R.id.Fav1Remove);
        TextView remove2 = (TextView) findViewById(R.id.Fav2Remove);
        TextView remove3 = (TextView) findViewById(R.id.Fav3Remove);

        //reset all views
        favedit.setText("Edit");
        favedit.setVisibility(View.GONE);
        favadd.setVisibility(View.GONE);
        fav1container.setVisibility(View.GONE);
        fav2container.setVisibility(View.GONE);
        fav3container.setVisibility(View.GONE);
        remove1.setVisibility(View.GONE);
        remove2.setVisibility(View.GONE);
        remove3.setVisibility(View.GONE);
        fav1container.setClickable(true);
        fav2container.setClickable(true);
        fav3container.setClickable(true);

        //if no favourites are set, hide edit function
        if(savedvalue == 1){
            favedit.setVisibility(View.GONE);
        }else{
            favedit.setVisibility(View.VISIBLE);
        }

        //if favourites set are full, hide add function
        if(savedvalue == 4){
            favadd.setVisibility(View.GONE);
        }else{
            favadd.setVisibility(View.VISIBLE);
        }

        // Set contents for Favourite location 1
        if(savedvalue >= 2){
            fav1container.setVisibility(View.VISIBLE);
            TextView fav1title = (TextView) findViewById(R.id.Fav1Title);
            TextView fav1weather = (TextView) findViewById(R.id.Fav1Weather);
            TextView fav1temp = (TextView) findViewById(R.id.Fav1Temp);
            TextView fav1Water = (TextView) findViewById(R.id.Fav1WL);
            TextView fav1Rain = (TextView) findViewById(R.id.Fav1RF);
            ImageView fav1color = (ImageView) findViewById(R.id.Fav1Color);
            ImageView weathericon = (ImageView) findViewById(R.id.fav1icon);

            Favourites fav1 = dbh.findFavourites(1);
            Location fav1location = dbh.findLocation(fav1.getFavLocationID());
            Basin fav1basin = dbh.findBasin(fav1location.getLocationBasin());
            Waterlvl fav1WL = dbh.findWaterlvl(fav1basin.getBasinID());
            Rainfall fav1RF = dbh.findRainfall(fav1basin.getBasinID());
            int fav1status = fav1basin.getBasinStatus();

            fav1title.setText(fav1location.getLocationName());
            fav1weather.setText(fav1basin.getBasinWeather());
            fav1temp.setText(Float.toString(fav1basin.getBasinTemp()) + "°C");
            fav1Water.setText(Float.toString(fav1WL.getBasinWL()) + " m");
            fav1Rain.setText(Float.toString(fav1RF.getBasinRF()) + " mm");
            int color1 = Color.parseColor("#5cf436");
            int color2 = Color.parseColor("#f4ab36");
            int color3 = Color.parseColor("#f43636");

            switch (fav1status){
                case 1:
                    fav1color.setColorFilter(color1);
                    break;
                case 2:
                    fav1color.setColorFilter(color2);
                    break;
                case 3:
                    fav1color.setColorFilter(color3);
                    break;
                default:
                    break;
            }

            String w = fav1basin.getBasinWeather();
            switch (w){
                case "Cloudy":
                    weathericon.setImageResource(R.drawable.cloudy);
                    break;
                case "Rainy":
                    weathericon.setImageResource(R.drawable.raining);
                    break;
                case "Thunderstorm":
                    weathericon.setImageResource(R.drawable.thunderstorm);
                    break;
                case "Sunny":
                    weathericon.setImageResource(R.drawable.sunny);
                    break;
                default:
                    break;
            }

        }
        //Set content for favourites location 2
        if(savedvalue >= 3){
            fav2container.setVisibility(View.VISIBLE);
            TextView fav2title = (TextView) findViewById(R.id.Fav2Title);
            TextView fav2weather = (TextView) findViewById(R.id.Fav2Weather);
            TextView fav2temp = (TextView) findViewById(R.id.Fav2Temp);
            TextView fav2Water = (TextView) findViewById(R.id.Fav2WL);
            TextView fav2Rain = (TextView) findViewById(R.id.Fav2RF);
            ImageView fav2color = (ImageView) findViewById(R.id.Fav2Color);
            ImageView weathericon = (ImageView) findViewById(R.id.fav2icon);

            Favourites fav2 = dbh.findFavourites(2);
            Location fav2location = dbh.findLocation(fav2.getFavLocationID());
            Basin fav2basin = dbh.findBasin(fav2location.getLocationBasin());
            Waterlvl fav2WL = dbh.findWaterlvl(fav2basin.getBasinID());
            Rainfall fav2RF = dbh.findRainfall(fav2basin.getBasinID());
            int fav2status = fav2basin.getBasinStatus();

            fav2title.setText(fav2location.getLocationName());
            fav2weather.setText(fav2basin.getBasinWeather());
            fav2temp.setText(Float.toString(fav2basin.getBasinTemp()) + "°C");
            fav2Water.setText(Float.toString(fav2WL.getBasinWL()) + " m");
            fav2Rain.setText(Float.toString(fav2RF.getBasinRF()) + " mm");
            int color1 = Color.parseColor("#5cf436");
            int color2 = Color.parseColor("#f4ab36");
            int color3 = Color.parseColor("#f43636");

            switch (fav2status){
                case 1:
                    fav2color.setColorFilter(color1);
                    break;
                case 2:
                    fav2color.setColorFilter(color2);
                    break;
                case 3:
                    fav2color.setColorFilter(color3);
                    break;
                default:
                    break;
            }

            String w = fav2basin.getBasinWeather();
            switch (w){
                case "Cloudy":
                    weathericon.setImageResource(R.drawable.cloudy);
                    break;
                case "Rainy":
                    weathericon.setImageResource(R.drawable.raining);
                    break;
                case "Thunderstorm":
                    weathericon.setImageResource(R.drawable.thunderstorm);
                    break;
                case "Sunny":
                    weathericon.setImageResource(R.drawable.sunny);
                    break;
                default:
                    break;
            }

        }
        // Set contents for Favourite location 3
        if(savedvalue >= 4){
            fav3container.setVisibility(View.VISIBLE);
            TextView fav3title = (TextView) findViewById(R.id.Fav3Title);
            TextView fav3weather = (TextView) findViewById(R.id.Fav3Weather);
            TextView fav3temp = (TextView) findViewById(R.id.Fav3Temp);
            TextView fav3Water = (TextView) findViewById(R.id.Fav3WL);
            TextView fav3Rain = (TextView) findViewById(R.id.Fav3RF);
            ImageView fav3color = (ImageView) findViewById(R.id.Fav3Color);

            Favourites fav3 = dbh.findFavourites(3);
            Location fav3location = dbh.findLocation(fav3.getFavLocationID());
            Basin fav3basin = dbh.findBasin(fav3location.getLocationBasin());
            Waterlvl fav3WL = dbh.findWaterlvl(fav3basin.getBasinID());
            Rainfall fav3RF = dbh.findRainfall(fav3basin.getBasinID());
            int fav3status = fav3basin.getBasinStatus();
            ImageView weathericon = (ImageView) findViewById(R.id.fav3icon);

            fav3title.setText(fav3location.getLocationName());
            fav3weather.setText(fav3basin.getBasinWeather());
            fav3temp.setText(Float.toString(fav3basin.getBasinTemp()) + "°C");
            fav3Water.setText(Float.toString(fav3WL.getBasinWL()) + " m");
            fav3Rain.setText(Float.toString(fav3RF.getBasinRF()) + " mm");
            int color1 = Color.parseColor("#5cf436");
            int color2 = Color.parseColor("#f4ab36");
            int color3 = Color.parseColor("#f43636");

            switch (fav3status){
                case 1:
                    fav3color.setColorFilter(color1);
                    break;
                case 2:
                    fav3color.setColorFilter(color2);
                    break;
                case 3:
                    fav3color.setColorFilter(color3);
                    break;
                default:
                    break;
            }

            String w = fav3basin.getBasinWeather();
            switch (w){
                case "Cloudy":
                    weathericon.setImageResource(R.drawable.cloudy);
                    break;
                case "Rainy":
                    weathericon.setImageResource(R.drawable.raining);
                    break;
                case "Thunderstorm":
                    weathericon.setImageResource(R.drawable.thunderstorm);
                    break;
                case "Sunny":
                    weathericon.setImageResource(R.drawable.sunny);
                    break;
                default:
                    break;
            }

        }

    }

}