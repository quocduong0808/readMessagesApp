package quongduong.readmessagesapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.DataViewHolder> {
    private List<Messages> messages;
    private Context context;

    public RecyclerDataAdapter(Context context, List<Messages> messages){
        this.context = context;
        this.messages = messages;
    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_name, parent,false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        String mess = messages.get(position).getMess();
        holder.tvMess.setText(mess);
    }


    @Override
    public int getItemCount() {
        return messages == null?0:messages.size();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView tvMess;
        public DataViewHolder(View itemView) {
            super(itemView);
            tvMess = (TextView) itemView.findViewById(R.id.tv_mess);
        }
    }

}
