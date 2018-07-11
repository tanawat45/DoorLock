package th.co.banana.doorlock.mqtt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import th.co.banana.doorlock.R;
import th.co.banana.doorlock.main.MainFragment;

public class MqttActivity extends AppCompatActivity {

    MqttAndroidClient mqttAndroidClient;

    final String serverUri = "tcp://m10.cloudmqtt.com:18771";
    final String clientId = "Android";
    String subscriptionTopic = "test";
    String publishTopic = "test";
    String publishMessage = "test test test";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.ro_area)
    RelativeLayout ro_area;

    @BindView(R.id.et_subscribeTo)
    EditText et_subscribeTo;

    @BindView(R.id.et_publishTo)
    EditText et_publishTo;

    @BindView(R.id.et_messageToSend)
    EditText et_messageToSend;

    @BindView(R.id.tv_messageArrived)
    TextView tv_messageArrived;

    @BindView(R.id.btn_subscribe)
    Button btn_subscribe;

    @BindView(R.id.btn_publish)
    Button btn_publish;

    private View AppHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt);

        ButterKnife.bind(this);
        initInstance();


    }

    @SuppressLint("ClickableViewAccessibility")
    private void initInstance() {
        setToolBar();
        setupMqttClient();
        btn_subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEditTextSubscribe();

                subscriptionTopic = et_subscribeTo.getText().toString();
                subscribeToTopic();
            }
        });

        btn_publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEditTextPublish();

                publishTopic = et_publishTo.getText().toString();
                publishMessage = et_messageToSend.getText().toString();
                publishMessage();
            }
        });

        ro_area.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard(v);
                return false;
            }
        });



    }

    private void validateEditTextPublish() {

        if(et_publishTo.length() == 0){
            Toast("ใส่ Topic ก่อนนนน");
        }

        else  if(et_messageToSend.length() == 0){
            Toast("ใส่ message ก่อนนนน");
        }
    }

    private void validateEditTextSubscribe() {
        if(et_subscribeTo.length() == 0){
            Toast("ใส่ subscribe topic ก่อนนนนน");
        }

    }

    private void Toast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
                .show();
    }

    protected void hideKeyboard(View view)
    {
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private String getDate() {
        //        DateFormat df = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        //        String date = df.format(Calendar.getInstance().getTime());

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

        return date;
    }

    private void setToolBar() {
        setSupportActionBar(toolbar);
        //        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //        getSupportActionBar().setHomeButtonEnabled(true);
        setTitle("Main Room");
    }

    private void setupMqttClient() {
        mqttAndroidClient = new MqttAndroidClient(getApplicationContext(), serverUri, clientId);
        mqttAndroidClient.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean reconnect, String serverURI) {
                if (reconnect) {
                    addToHistory("[CON] Reconnected to : " + serverURI);
                } else {
                    addToHistory("[CON] Connected to: " + serverURI);
                }
                // subscribeToTopic();
            }

            @Override
            public void connectionLost(Throwable cause) {
                addToHistory("The Connection was lost.");
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {

                //et_showMessage.setText(topic + " => " + new String(message.getPayload()) + "\n");

                Log.v("AOF", "Message from MQTT has arrive.");

                tv_messageArrived.setText(topic + " => " + new String(message.getPayload()) + "\n");

                addToHistory("Incoming message: " + new String(message.getPayload()));


            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });

        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();

        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setUserName("nhuivzzk");
        mqttConnectOptions.setPassword("a2Lw91WSoAhD".toCharArray());
        mqttConnectOptions.setCleanSession(false);



        try {
            mqttAndroidClient.connect(mqttConnectOptions, null, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Log.d("AOF","SUCCESS");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d("AOF","Fail");
                }
            });
        } catch (MqttException ex) {
            ex.printStackTrace();
        }
    }

    private void addToHistory(String mainText) {

        Log.d("AOF", "[LOG:] addToHistory: " + mainText);

    }

    public void subscribeToTopic() {
        try {
            mqttAndroidClient.subscribe(subscriptionTopic, 0, null, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    addToHistory("Subscribed!");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    addToHistory("Failed to subscribe");
                }
            });
        } catch (MqttException ex) {
            System.err.println("Exception whilst subscribing");
            ex.printStackTrace();
        }
    }

    public void publishMessage() {
        byte[] encodePayload = new byte[0];

        try {
            MqttMessage message = new MqttMessage();
            encodePayload = publishMessage.getBytes();
            message.setPayload(encodePayload);
            mqttAndroidClient.publish(publishTopic, message);

            addToHistory("Message Published");
            if (!mqttAndroidClient.isConnected()) {
                //  addToHistory(mqttAndroidClient.getBufferedMessageCount() + " messages in buffer.");
                addToHistory(  " messages in buffer.");

            }
        } catch (MqttException e) {
            System.err.println("Error Publishing: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
