package template.myapplication;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.List;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<Item> items;
    private Context context;
    private View itemView;

    public CardAdapter(List<Item> items, Context context){
        this.items = items;
        this.context = context;

    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        return new CardViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        final Item item = items.get(position);

        holder.header.setText(item.getHeader());
        holder.content.setText(item.getContent());
        holder.content.post(() -> {
            int lineCount = holder.content.getLineCount();
            if(lineCount <= 4)
                holder.showMore.setVisibility(View.GONE);
        });
        holder.icon.setImageResource(item.getDrawable());

            if((position == 2 || position == 5 )) {
                NativeAdActivity nativeAdActivity = new NativeAdActivity(context, itemView);
                nativeAdActivity.loadNativeAd();
            }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView header, content;
        Button showMore;
        View line_header;
        RelativeLayout category_layout;
        ImageView icon,share,copy;
        public CardViewHolder(View view) {
            super(view);
            header = view.findViewById(R.id.list_header);
            category_layout = view.findViewById(R.id.innerLayout);
            content = view.findViewById(R.id.list_content);
            showMore = view.findViewById(R.id.btShowmore);
            line_header = view.findViewById(R.id.line_header);
            icon = view.findViewById(R.id.card_icon_image);
        }
    }
}

