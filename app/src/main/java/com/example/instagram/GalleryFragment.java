package com.example.instagram;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.model.Post;


public class GalleryFragment extends Fragment {
    ImageView imageView1;
    ImageView imageView;
    Button button;
    EditText editText;
    Uri image;
    Uri image1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
            super.onViewCreated(view, savedInstanceState);

            imageView = view.findViewById(R.id.image_gallery);
            imageView1 = view.findViewById(R.id.image_gallery1);
            button = view.findViewById(R.id.button);
            editText = view.findViewById(R.id.edit_text);


        imageView.setOnClickListener(view1 -> {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 2);
            });
        imageView1.setOnClickListener(view1 -> {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Post post = new Post(image, editText.getText().toString(), image1);
                    System.out.println(post);
                }
            });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            if (requestCode==2) {
                image = data.getData();
                imageView.setImageURI(image);
            }
            if (requestCode==1){
                imageView1.setImageURI(data.getData());
            }

        }
    }
}