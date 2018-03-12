package com.example.habib.infobook;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_setting_Fragment extends Fragment {

    View profilesetting;

    private static final int PICK_IMAGE_REQUEST = 234;


    //ImageView
    private ImageView imageView;

    FirebaseUser user;

    //a Uri object to store file path
    private Uri filePath;

    private StorageReference mStorageRef;


    public Profile_setting_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        profilesetting=inflater.inflate(R.layout.fragment_profile_setting_, container, false);

        imageView=(ImageView)profilesetting.findViewById(R.id.profileImage);
        Button username_change_button=(Button)profilesetting.findViewById(R.id.change);
        Button save=(Button)profilesetting.findViewById(R.id.save);
        final EditText editText_username=(EditText)profilesetting.findViewById(R.id.userName);
        TextView textViewEmail=(TextView)profilesetting.findViewById(R.id.profile_email);
        final TextView textViewId=(TextView)profilesetting.findViewById(R.id.profile_id);



        editText_username.setEnabled(false);
        mStorageRef = FirebaseStorage.getInstance().getReference();

        user = FirebaseAuth.getInstance().getCurrentUser();

        StorageReference storageReference=mStorageRef.child(user.getUid().toString()+".jpg");

        Toast.makeText(getContext(), storageReference.toString(), Toast.LENGTH_LONG).show();

        File localFile = null;
        try {
            localFile = File.createTempFile("image","jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final File finalLocalFile = localFile;
        storageReference.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...
                        imageView.setImageURI(Uri.fromFile(finalLocalFile));

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle failed download
                // ...
            }
        });




        String user_email=user.getEmail().toString();
        textViewEmail.setText(user_email.toString());


        FirebaseDatabase.getInstance().getReference().child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> dataSnapshots = dataSnapshot.getChildren().iterator();
                List<Profile_item> profile_items = new ArrayList<>();
                while (dataSnapshots.hasNext()) {
                    DataSnapshot dataSnapshotChild = dataSnapshots.next();
                    if(dataSnapshotChild.getKey().toString().equals(user.getUid().toString())) {
                        String userName1 = (String) dataSnapshotChild.child("userName").getValue();
                        String userId1 = (String) dataSnapshotChild.child("userId").getValue();
                        textViewId.setText(userId1.toString());
                        editText_username.setText(userName1.toString());

                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        username_change_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText_username.setEnabled(true);


            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadFile();

                FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid()).child("userName").setValue(editText_username.getText().toString());
                editText_username.setEnabled(false);


            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();

            }
        });






        return profilesetting;
    }

    private void uploadFile() {
        //if there is a file to upload
        if (filePath != null) {
            //displaying a progress dialog while upload is going on
            final ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Uploading");
            progressDialog.show();

            StorageReference riversRef = mStorageRef.child(user.getUid().toString()+".jpg");
            riversRef.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //if the upload is successfull
                            //hiding the progress dialog
                            progressDialog.dismiss();

                            //and displaying a success toast
                            Toast.makeText(getContext(), "File Uploaded ", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            //if the upload is not successfull
                            //hiding the progress dialog
                            progressDialog.dismiss();

                            //and displaying error message
                            Toast.makeText(getContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            //calculating progress percentage
                            //double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

                            //displaying percentage in progress dialog
                            //progressDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                        }
                    });
        }

    }


    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
