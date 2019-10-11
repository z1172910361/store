package com.shop.store.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shop.store.R;
import com.shop.store.model.bean.ShopDetailBean;

import java.util.List;

/*
 *作者:SeeHeart 2019/9/28 8:42
 */
public class ShopDetailQuestionAdapter extends RecyclerView.Adapter<ShopDetailQuestionAdapter.ShopDetailQuestionHolder> {

    private List<ShopDetailBean.DataBeanX.IssueBean> questionList;
    private Context context;

    public ShopDetailQuestionAdapter(List<ShopDetailBean.DataBeanX.IssueBean> questionList, Context context) {
        this.questionList = questionList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShopDetailQuestionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shopdetail_question, viewGroup, false);
        return new ShopDetailQuestionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopDetailQuestionHolder shopDetailQuestionHolder, int i) {
        shopDetailQuestionHolder.questionTv.setText(questionList.get(i).getQuestion());
        shopDetailQuestionHolder.answerTv.setText(questionList.get(i).getAnswer());
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class ShopDetailQuestionHolder extends RecyclerView.ViewHolder{
        TextView questionTv;
        TextView answerTv;
        public ShopDetailQuestionHolder(@NonNull View itemView) {
            super(itemView);
            questionTv = itemView.findViewById(R.id.shopDetail_question_questionTv);
            answerTv = itemView.findViewById(R.id.shopDetail_question_answerTv);
        }
    }
}
