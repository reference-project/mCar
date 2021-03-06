package com.hut.cwp.mcar.activitys.business.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hut.cwp.mcar.R;
import com.hut.cwp.mcar.activitys.business.bean.HistorysBean;

import java.util.List;

/**
 * Created by hutcwp.
 */

public class IllegalResultAdapter extends RecyclerView.Adapter<IllegalResultAdapter.ViewHolder> {

    private List<HistorysBean> datas;
    public IllegalResultAdapter(List<HistorysBean> datas) {
        this.datas =datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.z_item_illegal_result, parent, false);
        return new IllegalResultAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HistorysBean data = datas.get(position);
        holder.tvDate.setText(data.getOccur_date());
        holder.tvArea.setText(data.getOccur_area());
        holder.tvAct.setText(data.getInfo());
        holder.tvCode.setText(TextUtils.isEmpty(data.getCode())?"无": data.getCode());
        holder.tvFen.setText(TextUtils.isEmpty(data.getFen()+"" )?"无": data.getFen()+"");
        holder.tvMoney.setText(TextUtils.isEmpty(data.getMoney()+"")?"无": data.getMoney()+"");
        String handled= data.getStatus();
        if (TextUtils.isEmpty(data.getStatus())) {
            holder.tvHandled.setText("未知");
        } else {
            holder.tvHandled.setText(handled.equals("1")?"已处理":"未处理");
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView tvDate,tvArea,tvAct,tvCode,tvFen,tvMoney,tvHandled;
        public ViewHolder(View itemView) {
            super(itemView);
            tvDate= (TextView) itemView.findViewById(R.id.tv_illegal_result_date);
            tvArea= (TextView) itemView.findViewById(R.id.tv_illegal_result_area);
            tvAct= (TextView) itemView.findViewById(R.id.tv_illegal_result_act);
            tvCode= (TextView) itemView.findViewById(R.id.tv_illegal_result_code);
            tvFen= (TextView) itemView.findViewById(R.id.tv_illegal_result_fen);
            tvMoney= (TextView) itemView.findViewById(R.id.tv_illegal_result_money);
            tvHandled= (TextView) itemView.findViewById(R.id.tv_illegal_result_handled);
        }
    }
}
