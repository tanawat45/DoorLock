package th.co.banana.doorlock.register;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import th.co.banana.doorlock.R;
import th.co.banana.doorlock.base.BaseFragment;

public class RegisterFragment extends BaseFragment {

    @BindView(R.id.et_email)
    EditText et_email;

    @BindView(R.id.et_password)
    EditText et_password;

    @BindView(R.id.et_name)
    EditText et_name;

    @BindView(R.id.et_lastname)
    EditText et_lastName;

    @BindView(R.id.et_phone)
    EditText et_phone;

    @BindView(R.id.spinner_position)
    Spinner spinner_position;

    @BindView(R.id.iv_profilePicture)
    ImageView iv_profilePicture;

    @BindView(R.id.ro_pictureProfile)
    RelativeLayout ro_profilePicture;

    public static final int PICK_IMAGE = 1;
    private Uri uri;


    public RegisterFragment(){
        //required empty public constructor
    }

    public static RegisterFragment newInstance() {
        Bundle args = new Bundle();

        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){

        }
        setHasOptionsMenu(true);
        initInstance();



    }

    private void initInstance() {
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.tb_menu_done, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            getActivity().finish();
        }

        else if (item.getItemId() == R.id.tb_menu_done){
            checkEditText();

        }
        return super.onOptionsItemSelected(item);
    }

    private void checkEditText() {

        if(et_email.length() == 0){
            Toast("กรุณากรอกอีเมล์");
        }
        else if (et_password.length() == 0){
            Toast("กรุณากรอกรหัสผ่าน");
        }
        else if (et_name.length() == 0){
            Toast("กรุณากรอกชื่อ");
        }
        else if (et_lastName.length() == 0){
            Toast("กรุณากรอกนามสกุล");
        }
        else if (et_phone.length() == 0){
            Toast("กรุณากรอกเบอร์โทรศัพท์");
        }
        else {
            Toast("สมัครเรียบร้อยแล้ว");
            getActivity().finish();
        }
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_register;
    }

    @Override
    protected void onViewBind() {

//        et_email.setMaxLines(1);
//        et_password.setMaxLines(1);
//        et_name.setMaxLines(1);
//        et_lastName.setMaxLines(1);
//        et_phone.setMaxLines(1);
//        et_position.setMaxLines(1);


        et_email.setImeOptions(EditorInfo.IME_ACTION_DONE);
        et_password.setImeOptions(EditorInfo.IME_ACTION_DONE);
        et_name.setImeOptions(EditorInfo.IME_ACTION_DONE);
        et_lastName.setImeOptions(EditorInfo.IME_ACTION_DONE);
        et_phone.setImeOptions(EditorInfo.IME_ACTION_DONE);

        String[] position = getResources().getStringArray(R.array.position_choices);
        ArrayAdapter<String> adapterPosition = new ArrayAdapter<String>(getContext(),android.R.layout.simple_dropdown_item_1line, position);
        spinner_position.setAdapter(adapterPosition);


    }

    @OnClick(R.id.ro_pictureProfile)
    void onClickPhoto(){

        final Intent intent = getActivity().getIntent();
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooseIntent = Intent.createChooser(getIntent, "Select Image");
        chooseIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, pickIntent);

        startActivityForResult(pickIntent, PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1){
            if(requestCode == Activity.RESULT_OK){
                uri = data.getData();

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
                    iv_profilePicture.setImageBitmap(bitmap);
                    Log.v("AOF", "Set profile picture success");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void Toast(String text){
        Toast.makeText(getContext(),text, Toast.LENGTH_SHORT)
                .show();

    }


}
