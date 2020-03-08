package com.example.vegabalanceapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.vegabalanceapp.adapters.RecyclerViewDataAdapter;
import com.example.vegabalanceapp.models.SectionDataModel;
import com.example.vegabalanceapp.models.SingleItemModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SelectProductActivity extends AppCompatActivity {

    List<SectionDataModel> allSampleData;

    Integer sectionId = 0;
    Integer itemId = 0;
    SingleItemModel item;

    RecyclerViewDataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);

        allSampleData = new ArrayList<>();



        //createDummyData();
        createProductData();


        RecyclerView my_recycler_view = findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);
        adapter = new RecyclerViewDataAdapter(this, allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Constants.ADD_PRODUCT_ACTIVITY_CODE){

            if(resultCode == RESULT_OK){

                item = (SingleItemModel) data.getSerializableExtra(Constants.PRODUCT_KEY);
                Integer sectionIndex = data.getIntExtra(Constants.SECTION_INDEX,0);
                Integer itemIndex = data.getIntExtra(Constants.ITEM_INDEX, 0);

                Toast.makeText(this, "[" +sectionIndex + "][" + itemIndex + "] " + item.toString(), Toast.LENGTH_SHORT).show();
                //use this only if you want to update the items in any section
                //adapter.updateItem(item, sectionIndex, itemIndex);
            }
            if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "was cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent goingBackIntent = new Intent();
        goingBackIntent.putExtra(Constants.PRODUCT_KEY, item);
        setResult(RESULT_OK, goingBackIntent);
        finish();
//        super.onBackPressed();
    }

    private void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel(++itemId, "Item " + j, "URL " + j, 0.0,  R.drawable.android, i));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }

    private void createProductData(){
        /*******First group *********/
        SectionDataModel group1 = new SectionDataModel();
        group1.setHeaderTitle("Green Veggies");

        List<SingleItemModel> productsGroup1 = new ArrayList<>();

        productsGroup1.add(new SingleItemModel(++itemId, "Broccoli ", "One portion is equal to 300g (around 3 heads)", 0.0, R.drawable.android, ++sectionId));
        productsGroup1.add(new SingleItemModel(++itemId, "Cucumber ", "My mother knows about it", 0.0, R.drawable.android, sectionId));

        group1.setAllItemsInSection(productsGroup1);

        allSampleData.add(group1);

        /*******Second group *********/
        SectionDataModel group2 = new SectionDataModel();
        group2.setHeaderTitle("Meat");

        List<SingleItemModel> productsGroup2 = new ArrayList<>();

        productsGroup2.add(new SingleItemModel(++itemId, "Sausages ", "I can't stop eating it", 0.0, R.drawable.logotransbet, ++sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Picanha ", "Yummy", 0.0, R.drawable.android, sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Kangaroo", "once you try you'll never forget it", 0.0, R.drawable.logotransbet, sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Chorizo ", "I can't stop eating it", 0.0, R.drawable.logotransbet, sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Ribs ", "Yummy", 0.0, R.drawable.android, sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Shanks", "once you try you'll never forget it", 0.0, R.drawable.logotransbet, sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Beef", "Beef once you try you'll never forget it", 0.0, R.drawable.logotransbet, sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Loin", "Loin once you try you'll never forget it", 0.0, R.drawable.logotransbet, sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Chuck", "Chuck once you try you'll never forget it", 0.0, R.drawable.logotransbet, sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Round", "Round once you try you'll never forget it", 0.0, R.drawable.logotransbet, sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Roast Beef", "Roast once you try you'll never forget it", 0.0, R.drawable.logotransbet, sectionId));
        productsGroup2.add(new SingleItemModel(++itemId, "Ranch steak", "Ranch once you try you'll never forget it", 0.0, R.drawable.logotransbet, sectionId));

        group2.setAllItemsInSection(productsGroup2);

        allSampleData.add(group2);

    }



}
