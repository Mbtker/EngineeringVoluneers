package mbtkerteam.com.engvolunteered.Helpers;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mbtkerteam.com.engvolunteered.MothqFragment;
import mbtkerteam.com.engvolunteered.R;

public class CategoriesAdapters extends RecyclerView.Adapter<CategoriesAdapters.ViewHolder> {


    private ArrayList<VideosCategoriesModel> CategoriesList;
    private Context context;

    int selected_position = 0;


    public CategoriesAdapters(Context context, ArrayList<VideosCategoriesModel> CategoriesList) {
        this.CategoriesList = CategoriesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.MyCategoryName.setText("");

        holder.MyCategoryName.setText(CategoriesList.get(position).Name);

        holder.MyCategoryName.setBackgroundResource(selected_position == position ? R.drawable.category_item_style_selected : R.drawable.category_item_style);
        holder.MyCategoryName.setTextColor(selected_position == position ? Color.parseColor("#000000") : Color.parseColor("#717171"));

        holder.MyCategoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == RecyclerView.NO_POSITION) return;

                // Updating old as well as new positions
                notifyItemChanged(selected_position);
                selected_position = position;
                notifyItemChanged(selected_position);

                MothqFragment.initData();
            }
        });
    }

    @Override
    public int getItemCount() {
        return CategoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView MyCategoryName;

        public ViewHolder(View itemView) {
            super(itemView);

            MyCategoryName = itemView.findViewById(R.id.MyCategoryName);

        }


    }


}
