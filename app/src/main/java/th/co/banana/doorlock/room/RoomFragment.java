package th.co.banana.doorlock.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.OnClick;
import th.co.banana.doorlock.R;
import th.co.banana.doorlock.base.BaseFragment;
import th.co.banana.doorlock.historyroom.HistoryRoomActivity;
import th.co.banana.doorlock.login.LoginActivity;
import th.co.banana.doorlock.main.MainActivity;
import th.co.banana.doorlock.main.MainFragment;

public class RoomFragment extends BaseFragment {

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

    @OnClick(R.id.btn_history)
    void onclickHistory(){
        Intent intent = new Intent(getActivity(), HistoryRoomActivity.class);
        startActivity(intent);
    }
}
