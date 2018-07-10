package th.co.banana.doorlock.historyroom;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import th.co.banana.doorlock.R;
import th.co.banana.doorlock.base.BaseFragment;

public class HistoryRoomFragment extends BaseFragment {

    public static HistoryRoomFragment newInstance() {
        HistoryRoomFragment fragment = new HistoryRoomFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_history_room;
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
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }



}
