package helloworld.demo.com.stockapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    //LIST CREATION
    ArrayList<Contact> contactlist;
    Context context;

    //CLASS CONSTRUCTOR
    public CustomAdapter(Context context, ArrayList<Contact> contactlist) {
        this.context = context;
        this.contactlist = contactlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.text_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Contact m;
        m = contactlist.get(position);
        holder.mItemno.setText(" ITEMNO : " + m.getItemNo());
        holder.mItem.setText(" ITEM : " + m.getItem());
        holder.mVariant.setText(" VARIANT : " + m.getVariant());
        holder.mInventory.setText(" INVENTORY : " + m.getInventory());
        holder.mPrice1.setText(" PRICE(1PM-10PM) : " + m.getPrice1());
        holder.mPrice2.setText(" PRICE(10PM-1PM) : " + m.getPrice2());
    }

    @Override
    public int getItemCount() {
        return contactlist.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mItemno;
        public TextView mItem;
        public TextView mVariant;
        public TextView mInventory;
        public TextView mPrice1;
        public TextView mPrice2;
        public RelativeLayout mRelativeLayout;

        public ViewHolder(View v) {
            super(v);
            mItemno = (TextView) v.findViewById(R.id.listitem1);
            mItem = (TextView) v.findViewById(R.id.listitem2);
            mVariant = (TextView) v.findViewById(R.id.listitem3);
            mInventory = (TextView) v.findViewById(R.id.listitem4);
            mPrice1 = (TextView) v.findViewById(R.id.listitem5);
            mPrice2 = (TextView) v.findViewById(R.id.listitem6);
            mRelativeLayout = (RelativeLayout) v.findViewById(R.id.rl);
        }

    }
}

