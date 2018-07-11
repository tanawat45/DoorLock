package th.co.banana.doorlock.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import th.co.banana.doorlock.R;
import th.co.banana.doorlock.base.BaseFragment;
import th.co.banana.doorlock.history.HistoryActivity;

public class RoomFragment extends BaseFragment {

    @BindView(R.id.open)
    TextView tvopen;

    @BindView(R.id.close)
    TextView tvclose;

    public static RoomFragment newInstance() {
        RoomFragment fragment = new RoomFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_room;
    }

    @Override
    protected void onViewBind() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            getActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }
    Boolean stateCheck = true;
    @OnClick(R.id.tb_lock)
    void onclick(){
        if (stateCheck == false){
            tvclose.setVisibility(View.VISIBLE);
            tvopen.setVisibility(View.GONE);
//            Toast.makeText(getContext(), "Lock", Toast.LENGTH_SHORT).show();
            stateCheck = true;
        }else if (stateCheck == true){
            tvclose.setVisibility(View.GONE);
            tvopen.setVisibility(View.VISIBLE);
//            Toast.makeText(getContext(), "Unlock", Toast.LENGTH_SHORT).show();
            stateCheck = false;
        }
    }

    @OnClick(R.id.btn_history)
    void onclickHistory(){
        Intent intent = new Intent(getActivity(), HistoryActivity.class);
        startActivity(intent);
    }
}
