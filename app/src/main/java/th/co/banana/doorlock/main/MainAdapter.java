package th.co.banana.doorlock.main;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import th.co.banana.doorlock.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private MainAdapterListenner listenner;
    private int adapterPosition = 1;

    public interface MainAdapterListenner{
        void clickRoom(String name, int adapterPosition);
    }

    public MainAdapter(MainAdapterListenner listenner){
        this.listenner = listenner;
    }

    public void setAdapterPosition(int position){
        this.adapterPosition = position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_room, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.roomName.setText("Room " + (position + 1));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CardView cvRoom;
        LinearLayout linearBackground;
        TextView roomName;

        public ViewHolder(View itemView) {
            super(itemView);

            cvRoom = itemView.findViewById(R.id.cv_room);
            linearBackground = itemView.findViewById(R.id.linear_background);
            roomName = itemView.findViewById(R.id.tv_room_name);

            cvRoom.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listenner.clickRoom("Room " , getAdapterPosition()+1);
        }
    }
}
