package com.example.vegabalanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vegabalanceapp.models.SingleItemModel;

import java.io.Serializable;

public class AddProductActivity extends AppCompatActivity {

    EditText portionEditText;
    ImageView productImageView;
    SingleItemModel product;
    Integer sectionIndex;
    Integer itemIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        Intent activityThatCalled = getIntent();
        product = (SingleItemModel)activityThatCalled.getSerializableExtra(Constants.PRODUCT_KEY);
        sectionIndex = activityThatCalled.getIntExtra(Constants.SECTION_INDEX,0);
        itemIndex = activityThatCalled.getIntExtra(Constants.ITEM_INDEX, 0);

        Log.i("DAD", product.toString());

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        portionEditText = findViewById(R.id.portionEditText);
        productImageView = findViewById(R.id.productImageView);


        nameTextView.setText(product.getName());
        descriptionTextView.setText(product.getDescription());
        productImageView.setImageResource(product.getImageResId());

    }

    public void addToPlate(View view) {
        String portionValue = portionEditText.getText().toString();
        if(!portionValue.isEmpty()) {
            Double portion = Double.valueOf(portionValue);
            product.setPortion(portion);
        }
        Intent goingBackIntent = new Intent();
        goingBackIntent.putExtra(Constants.PRODUCT_KEY, product);
        goingBackIntent.putExtra(Constants.SECTION_INDEX, sectionIndex);
        goingBackIntent.putExtra(Constants.ITEM_INDEX, itemIndex);
        setResult(RESULT_OK, goingBackIntent);
        finish();

    }

    public void cancel(View view) {

        setResult(RESULT_CANCELED);
        finish();
    }
}
