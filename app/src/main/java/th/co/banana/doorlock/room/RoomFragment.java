package th.co.banana.doorlock.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import th.co.banana.doorlock.R;
import th.co.banana.doorlock.base.BaseFragment;
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
        return R.layout.fragment_main;
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
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
