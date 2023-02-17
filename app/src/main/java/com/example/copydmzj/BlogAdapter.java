package com.example.copydmzj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


public class BlogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<JianShuBlogTest> blogList;
    private Context context;

    public BlogAdapter(List<JianShuBlogTest> blogList, Context context) {
        this.blogList = blogList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        /**
         * 主要负责把加载子项的布局
         * 将xml定义的布局实例化为view对象
         */
        View view = LayoutInflater.from(context).inflate(R.layout.blog_item, viewGroup, false);
        //new BlogViewHolder
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        //主要负责绑定数据
//        ((ContentViewHolder) holder).tvItem.setText(mList.get(position));
        ContentViewHolder holder = (ContentViewHolder) viewHolder;
        final JianShuBlogTest blogTest = blogList.get(position);
        holder.title.setText(blogTest.getTitle());
        holder.content.setText(blogTest.getAbs());
        holder.paid.setText(blogTest.getLike());
        holder.nick.setText(blogTest.getName());
        holder.paid.setText(blogTest.getPaid());

        //图像加载
        Glide.with(context)
                .load(blogTest.getImg())
                .into(holder.img);
    }


    @Override
    public int getItemCount() {
        //返回集合的数量
        return blogList.size();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {

        public TextView title, content, paid, nick, like;
        public ImageView img;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.blog_title);
            content = (TextView) itemView.findViewById(R.id.blog_content);
            paid = (TextView) itemView.findViewById(R.id.blog_paid);
            nick = (TextView) itemView.findViewById(R.id.blog_name);
            like = (TextView) itemView.findViewById(R.id.blog_like);
            img = (ImageView) itemView.findViewById(R.id.blog_img);

        }
    }
}
