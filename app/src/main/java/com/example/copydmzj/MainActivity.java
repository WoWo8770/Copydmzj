package com.example.copydmzj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Observable;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private List<JianShuBlogTest> blogTestList;
    private RecyclerView mRecyclerView;
    private BlogAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化所有参数
        initView();

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
    }

    private void showBlog (List<JianShuBlogTest> blogs) {
        mAdapter = new BlogAdapter(this, blogTestList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void connectJianShu() {
        blogTestList = new ArrayList<>();
        Observable.create(new ObservableOnSubscribe<List<JianShuBlogTest>>(){

        })
    }
}
