package com.example.vegabalanceapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vegabalanceapp.R;
import com.example.vegabalanceapp.models.SectionDataModel;
import com.example.vegabalanceapp.models.SingleItemModel;


import java.util.List;
import java.util.Map;


public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.ItemRowHolder> {

        private List<SectionDataModel> dataList;
        private Context mContext;


        public RecyclerViewDataAdapter(Context context, List<SectionDataModel> dataList) {
            this.dataList = dataList;
            this.mContext = context;
        }

        @Override
        public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
            ItemRowHolder mh = new ItemRowHolder(v);
            return mh;
        }

        @Override
        public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {


            final String sectionName = dataList.get(i).getHeaderTitle();

            List singleSectionItems = dataList.get(i).getAllItemsInSection();

            itemRowHolder.itemTitle.setText(sectionName);

            SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems, i);

            itemRowHolder.recycler_view_list.setHasFixedSize(true);
            itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);


            itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);



       /*  itemRowHolder.recycler_view_list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        //Allow ScrollView to intercept touch events once again.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                // Handle RecyclerView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });*/

            itemRowHolder.btnMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();



                }
            });







       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
        }

        @Override
        public int getItemCount() {
            return (null != dataList ? dataList.size() : 0);
        }

    public void updateItem(SingleItemModel item, Integer sectionIndex, Integer itemIndex) {



    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

            protected TextView itemTitle;

            protected RecyclerView recycler_view_list;

            protected Button btnMore;



            public ItemRowHolder(View view) {
                super(view);

                this.itemTitle = view.findViewById(R.id.itemTitle);
                this.recycler_view_list =  view.findViewById(R.id.recycler_view_list);
                this.btnMore=  view.findViewById(R.id.btnMore);


            }

        }


        public void modifyItem(SingleItemModel item){
            //will call
        }


    }
