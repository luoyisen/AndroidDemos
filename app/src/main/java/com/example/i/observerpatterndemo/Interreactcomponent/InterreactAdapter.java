package com.example.i.observerpatterndemo.Interreactcomponent;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.i.observerpatterndemo.R;

import java.util.ArrayList;

/**
 * Created by I on 2017/8/23.
 */

public class InterreactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public OnItemClickListener onItemClickListener;
    public ArrayList<String> mData;

    public enum ITEM_TYPE {
        ITEM1,
        ITEM2
    }

    public InterreactAdapter(ArrayList<String> mData) {

        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Returns the ordinal of this enumeration constant (its position
         *  in its enum declaration, where the initial constant is assigned
         *  an ordinal of zero).
         */
        if (viewType == ITEM_TYPE.ITEM1.ordinal()) {
            return new interreactViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_interreact_type1, parent, false));
        } else {
            return new interreactViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_interreact_type2, parent, false));

        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof interreactViewHolder1) {
            ((interreactViewHolder1) holder).button.setText(mData.get(position));
            /**
             * 这里的item里面有一个button，如果要为整个itemView设置点击事件，就要：
             * 1.将button设置为不可点击，否则事件不会传递到itemview，或者：
             * 2.自定义button，重写ontouchevent()方法，使得其返回值为false，表示button不处理事件，由button的上级viewgroup来处理，或者：
             * 3.自定义relativelayout，重写dispatchtouchevent()方法，时期返回值为false，表示不再分发事件
             */
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        int pos = holder.getLayoutPosition();
                        onItemClickListener.onItemClick(holder.itemView, pos);
                    }
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onItemClickListener != null) {
                        int pos = holder.getLayoutPosition();
                        onItemClickListener.onItemLongClick(holder.itemView, pos);
                    }
                    return true;//返回true表示事件被消费了
                }
            });
        } else if (holder instanceof interreactViewHolder2) {
            ((interreactViewHolder2) holder).textview.setText(mData.get(position));

        }
    }

    @Override
    public int getItemViewType(int position) {
        //Enum类提供了一个ordinal()方法，返回枚举类型的序数，这里ITEM_TYPE.ITEM1.ordinal()代表0， ITEM_TYPE.ITEM2.ordinal()代表1
        return position % 2 == 0 ? ITEM_TYPE.ITEM1.ordinal() : ITEM_TYPE.ITEM2.ordinal();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }


    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class interreactViewHolder1 extends RecyclerView.ViewHolder {

        Button button;

        public interreactViewHolder1(View itemView) {
            super(itemView);
            button = (Button) itemView.findViewById(R.id.button_show);
        }
    }

    public static class interreactViewHolder2 extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView textview;

        public interreactViewHolder2(View itemView) {
            super(itemView);
            imageview = (ImageView) itemView.findViewById(R.id.faceimage);
            textview = (TextView) itemView.findViewById(R.id.phonenumber);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int pisition);
    }
}
