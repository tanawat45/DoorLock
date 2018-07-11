package th.co.banana.doorlock.history;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import th.co.banana.doorlock.R;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private MainAdapterListenner listenner;
    private Context context;

    public interface MainAdapterListenner{
        void clickRoom();
    }

    public HistoryAdapter(MainAdapterListenner listenner){
        this.listenner = listenner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history_name_and_time, parent, false);

        context = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position % 2 == 0){
            holder.linearHistory.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
        }
        holder.tvNamelastname.setText("ธนวัฒน์ กลมกลอม");
        holder.time.setText("13:00");
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout linearHistory;
        TextView tvNamelastname;
        TextView time;

        public ViewHolder(View itemView) {
            super(itemView);

            linearHistory = itemView.findViewById(R.id.linear_history);
            tvNamelastname = itemView.findViewById(R.id.tv_name_lastname);
            time = itemView.findViewById(R.id.tv_time);

            linearHistory.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
