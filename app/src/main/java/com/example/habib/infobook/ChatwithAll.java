package com.example.habib.infobook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ChatwithAll extends AppCompatActivity {
    String id=" ";
    DatabaseReference reference1, reference2;

    ImageView sendButton;
    EditText messageArea;

    ListView listView;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatwith_all);
        sendButton=(ImageView)findViewById(R.id.sendmessage);
        messageArea=(EditText)findViewById(R.id.editText);

        listView=(ListView)findViewById(R.id.list);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);




        final FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
        FirebaseDatabase.getInstance().getReference().child("Users").addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> dataSnapshots = dataSnapshot.getChildren().iterator();

                while (dataSnapshots.hasNext()) {
                    DataSnapshot dataSnapshotChild = dataSnapshots.next();

                    if(dataSnapshotChild.getKey().toString().equals(currentFirebaseUser.getUid().toString())){
                       id=(String)dataSnapshotChild.child("userId").getValue();
                        takeName(id);
                        break;

                    }

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void takeName(final String current_user_id){

        String chatWith = getIntent().getStringExtra("id");


        reference1 = FirebaseDatabase.getInstance().getReference("Users").child("message").child(current_user_id+"_"+chatWith);
        reference2 = FirebaseDatabase.getInstance().getReference("Users").child("message").child(chatWith+"_"+current_user_id);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageArea.getText().toString();
                if(!messageText.equals("")){
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("message", messageText);
                    map.put("user", current_user_id);
                    reference1.push().setValue(map);
                    reference2.push().setValue(map);
                    messageArea.setText("");
                }
            }
        });
        reference1.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               // Toast.makeText(getApplicationContext(),dataSnapshot.child("message").getValue().toString(),Toast.LENGTH_LONG).show();
                String message=(String)dataSnapshot.child("message").getValue();
                String user=(String)dataSnapshot.child("user").getValue();
                //check=check+message+"\n";
                if(user!=null&&user.equals(current_user_id.toString())){
                    message="You"+"\n"+message;
                    list.add(message);
                    adapter.notifyDataSetChanged();


                }
                else {
                    message=user+"\n"+message;
                    list.add(message);
                    adapter.notifyDataSetChanged();
                }


            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        }


        );

    }
}
