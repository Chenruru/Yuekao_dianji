package test.bwie.com.yuekao_dianji;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * date: 2017/5/27
 * author:陈茹
 * 类的用途:
 */

public class Myreclerviewadapter extends RecyclerView.Adapter<Myreclerviewadapter.Myviewholder>{
    private Context context;
    private List<Userbean.OthersBean> others;

    public Myreclerviewadapter(Context context, List<Userbean.OthersBean> others) {
        this.context = context;
        this.others = others;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        Myviewholder holder = new Myviewholder(LayoutInflater.from(
                context).inflate(R.layout.item_recler,
                null));
        return holder;
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {

        holder.text1.setText(others.get(position).getName());
        holder.text2.setText(others.get(position).getDescription());
        ImageLoader.getInstance().displayImage(others.get(position).getThumbnail(),holder.image_view);

    }

    @Override
    public int getItemCount() {
        return others.size();
    }


    class Myviewholder extends RecyclerView.ViewHolder{

         ImageView image_view;
         TextView text1;
         TextView text2;

        public Myviewholder(View itemView) {
            super(itemView);
            image_view = (ImageView) itemView.findViewById(R.id.image_view);
            text1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);
        }




    }
}
