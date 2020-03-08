package com.example.vegabalanceapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vegabalanceapp.AddProductActivity;
import com.example.vegabalanceapp.Constants;
import com.example.vegabalanceapp.R;
import com.example.vegabalanceapp.models.SingleItemModel;

import java.util.List;
import java.util.Map;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private List<SingleItemModel> itemsList;
    private Context mContext;
    private Integer sectionIndex;

//    private View.OnClickListener onItemClickListener;



    public SectionListDataAdapter(Context context, List<SingleItemModel> itemsList, Integer sectionIndex) {
        this.itemsList = itemsList;
        this.mContext = context;
        this.sectionIndex = sectionIndex;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleItemModel singleItem = itemsList.get(i);
//        singleItem

        holder.idTextView.setText(singleItem.getId().toString());
        holder.tvTitle.setText(singleItem.getName());
        holder.itemImage.setImageResource(singleItem.getImageResId());


       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);

    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;
        protected TextView idTextView;


        public SingleItemRowHolder(View view) {
            super(view);
            view.setTag(this);
//            view.setOnClickListener(onItemClickListener);


            this.idTextView = view.findViewById(R.id.idTextView);
            this.tvTitle =  view.findViewById(R.id.tvTitle);
            this.itemImage =  view.findViewById(R.id.itemImage);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    callAddProductIntent(v, getAdapterPosition());
//                    Integer x = getAdapterPosition();
//                    Toast.makeText(v.getContext(), String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();


                }
            });


        }

    }

    /*
    public void setOnItemClickListener(View.OnClickListener clickListener){
        onItemClickListener = clickListener;
    }
    */

    private void callAddProductIntent(View v, Integer itemPosition) {
        Intent goToAddProductActivityIntent = new Intent(mContext, AddProductActivity.class);
        TextView idTextView = v.findViewById(R.id.idTextView);



        SingleItemModel product = findProductInList(idTextView.getText().toString());

        goToAddProductActivityIntent.putExtra(Constants.PRODUCT_KEY, product);
        goToAddProductActivityIntent.putExtra(Constants.SECTION_INDEX, sectionIndex);
        goToAddProductActivityIntent.putExtra(Constants.ITEM_INDEX, itemPosition);

        Activity origin = (Activity)mContext;
        origin.startActivityForResult(goToAddProductActivityIntent, Constants.ADD_PRODUCT_ACTIVITY_CODE);
    }



    private SingleItemModel findProductInList(String id) {

        for(SingleItemModel product : itemsList) {
            if(product.getId()==Integer.valueOf(id))
                return product;
        }

        return null;
    }



//    itemsList
}