package com.example.favorite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<String> list = new ArrayList<>();
            list.add("동대구 복합 환승센터") ;
            list.add("경북대학교 정문");
        }

        RecyclerView recyclerView = findViewById(R.id.recycler1) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;
        adaptercd adapter = new adaptercd(list) ;
        recyclerView.setAdapter(adapter) ;
    }
}
