package com.example.vegabalanceapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vegabalanceapp.R;
import com.example.vegabalanceapp.models.Plate;
import com.example.vegabalanceapp.models.SingleItemModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;


import java.util.List;

public class PlateRecyclerViewAdapter extends RecyclerView.Adapter<PlateRecyclerViewAdapter.ItemRowHolder> {


    private List<Plate> plates;
    private Context context;

    public PlateRecyclerViewAdapter(Context context, List<Plate> plates) {
        this.plates = plates;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_plate_card_view, parent, false);
        ItemRowHolder itemRowHolder = new ItemRowHolder(v);
        return itemRowHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ItemRowHolder holder, int position) {

        final Plate plate = plates.get(position);

        holder.descriptionTextView.setText(plate.getDescription());
        holder.nameTextView.setText(plate.getName());

        List<SingleItemModel> ingredients = plate.getIngredients();
        for(final SingleItemModel item : ingredients){
            final Chip chip = new Chip(context);
            chip.setText(item.getName() + "( " + item.getPortion().toString() + " )");
            chip.setCloseIconVisible(true);

            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if(isChecked){

                    }else{

                    }

                }
            });

            holder.ingredientsChipGroup.addView(chip);
        }

    }

    @Override
    public int getItemCount() {
        return (null!=plates? plates.size(): 0);
    }



    public class ItemRowHolder extends RecyclerView.ViewHolder{

        protected TextView nameTextView;
        protected TextView descriptionTextView;
        protected ChipGroup ingredientsChipGroup;


        public ItemRowHolder(@NonNull View itemView) {
            super(itemView);

            this.nameTextView = itemView.findViewById(R.id.plate_name_textView);
            this.descriptionTextView = itemView.findViewById(R.id.plate_description_editText);
            this.ingredientsChipGroup = itemView.findViewById(R.id.plate_ingredients_chip_group);
        }
    }
}
