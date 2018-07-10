package th.co.banana.doorlock.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import th.co.banana.doorlock.R;
import th.co.banana.doorlock.base.BaseFragment;
import th.co.banana.doorlock.login.LoginActivity;
import th.co.banana.doorlock.room.RoomActivity;

public class MainFragment extends BaseFragment implements MainAdapter.MainAdapterListenner{

    private MainAdapter adapter;

    @BindView(R.id.rv_room)
    RecyclerView rvRoom;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        adapter = new MainAdapter(this);
        rvRoom.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void clickRoom() {

    }

    @OnClick(R.id.test)
    void onclick(){
        Intent intent = new Intent(getActivity(), RoomActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_logout)
    void onclickLogOut(){
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
