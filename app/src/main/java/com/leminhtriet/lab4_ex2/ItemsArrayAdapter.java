package com.leminhtriet.lab4_ex2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class ItemsArrayAdapter extends ArrayAdapter<String> {

  private Context context;
  private int layoutToBeInflated;
  private List<String> items;

  public ItemsArrayAdapter(@NonNull Context context, int resource,
      @NonNull List<String> items) {
    super(context, resource, items);
    this.items = items;
    this.context = context;
    layoutToBeInflated = resource;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @NonNull
  @Override
  public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    ItemViewHolder holder;

    View row = convertView;
    if (row == null) {

      LayoutInflater inflater = ((Activity) context).getLayoutInflater();
      row = inflater.inflate(layoutToBeInflated, null);

      holder = new ItemViewHolder();
      holder.tvItemName = row.findViewById(R.id.tv_item);
      holder.btnRemove = row.findViewById(R.id.btn_remove);

      row.setTag(holder);
    } else {
      holder = (ItemViewHolder) row.getTag();
    }
    String item = items.get(position);
    holder.tvItemName.setText(item);

    holder.btnRemove.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        items.remove(position);
        notifyDataSetChanged();
      }
    });
    row.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(context,
            "Bạn vừa chọn Item " + position, Toast.LENGTH_SHORT).show();
      }
    });
    return row;
  }

  public class ItemViewHolder {
    TextView tvItemName;
    Button btnRemove;
  }
}
