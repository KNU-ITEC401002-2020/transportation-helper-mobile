package com.example.favorite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 즐겨찾기 추가한 역
        ArrayList<String> list = new ArrayList<>();
            list.add("동대구 복합 환승센터") ;
            list.add("경북대학교 정문");
        }

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.recycler1) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        adaptercd adapter = new adaptercd(list) ;
        recyclerView.setAdapter(adapter) ;
    }
}