package com.example.vegabalanceapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.vegabalanceapp.adapters.RecyclerViewDataAdapter;
import com.example.vegabalanceapp.models.Plate;
import com.example.vegabalanceapp.models.SectionDataModel;
import com.example.vegabalanceapp.models.SingleItemModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


//    List<SectionDataModel> allSampleData;
    List<Plate> plates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //our code starts here
        plates = new ArrayList<Plate>();

        List<SingleItemModel> items = new ArrayList<>();
        items.add( new SingleItemModel(1, "Sausages ", "I can't stop eating it", 2.0, R.drawable.logotransbet, 0));
        items.add( new SingleItemModel(2, "Picanha ", "Yummy", 3.5, R.drawable.android, 0));

        Plate plate = new Plate(1, "mi plato", "Bacon doner boudin brisket corned beef alcatra landjaeger pancetta spare ribs capicola swine bresaola drumstick. Pancetta sausage short ribs ribeye ham ball tip.", items);

        plates.add(plate);

        items = new ArrayList<>();
        items.add(new SingleItemModel(3, "Round", "Round once you try you'll never forget it", 1.7, R.drawable.logotransbet, 0));
        items.add(new SingleItemModel(4, "Roast Beef", "Roast once you try you'll never forget it", 2.4, R.drawable.logotransbet, 0));
        items.add(new SingleItemModel(5, "Broccoli ", "One portion is equal to 300g (around 3 heads)", 0.5, R.drawable.android, 0));
        items.add(new SingleItemModel(6, "Cucumber ", "My mother knows about it", 0.7, R.drawable.android, 0));

        plate = new Plate(1, "My fatty meal", "Landjaeger shankle chicken kevin turkey doner filet mignon boudin pork loin jerky drumstick rump porchetta shank. Cupim picanha short ribs, pork loin boudin porchetta rump tongue hamburger doner chicken shank fatback bresaola.", items);
        plates.add(plate);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void goToCheckYourBalancedDiet(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();



        Intent goToSelectProduct = new Intent(this, SelectProductActivity.class);

        startActivityForResult(goToSelectProduct,Constants.SELECT_PRODUCT_ACTIVITY_CODE);
    }


    public void goToMyPlates(View view) {

        Intent goToMyPlates = new Intent(this, MyPlatesActivity.class);

        //pass the list of plates to the activity
        goToMyPlates.putExtra(Constants.PLATES_KEY, (ArrayList<Plate>)plates);

        startActivityForResult(goToMyPlates, Constants.MY_PLATES_ACTIVITY_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == Constants.SELECT_PRODUCT_ACTIVITY_CODE) {

            if (resultCode == RESULT_OK) {
                try {
                    SingleItemModel item = (SingleItemModel) data.getSerializableExtra(Constants.PRODUCT_KEY);

                    if(null == item) return;

                    Plate plate = plates.get(0);
                    List<SingleItemModel> ingredients = plate.getIngredients();
                    if(!ingredients.contains(item))
                        ingredients.add(item);
                    else{
                        for(SingleItemModel itemModel : ingredients){
                            if(item.equals(itemModel)){
                                itemModel.setPortion(itemModel.getPortion() + item.getPortion());
                                break;
                            }
                        }
                    }


                }catch (Exception e){

                }


            }
        }
        if(requestCode == Constants.MY_PLATES_ACTIVITY_CODE) {

            if (resultCode == RESULT_OK) {


            }
        }

    }
}
