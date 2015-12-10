package com.example.kkyasa.gridviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by kkyasa on 11/20/2015.
 */
public class RecyclerAdapter
        extends RecyclerView.Adapter
        <RecyclerAdapter.ListItemViewHolder> {

    private List<ElementDetails> items;
    Context mContext;


    RecyclerAdapter(ArrayList<ElementDetails> modelData,Context mContext) {
        if (modelData == null) {
            throw new IllegalArgumentException("modelData must not be null");
        }
        items = modelData;
        this.mContext = mContext;
    }

    public ElementDetails getItem(int position) {
        return items.get(position);
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_product_view, viewGroup, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder viewHolder, int position) {
        String key = ((ElementDetails) getItem(position)).getKey();
        final ElementDetails elementDetail = (ElementDetails) getItem(position);

        switch (getItemViewType(position)) {
            case 0:
                viewHolder.tv_lv.setText(key);
                for (int j = 0; j < viewHolder.fm_lv.getChildCount(); j++) {
                    viewHolder.fm_lv.removeViewAt(j);
                }
                viewHolder.fm_lv.removeAllViews();
                if (viewHolder.fm_lv.getChildCount() == 0) {
                    viewHolder.et_lv = new EditText(mContext);
                    if (elementDetail.getValue().equalsIgnoreCase(mContext.getString(R.string.dummy_value))) {
                        viewHolder.et_lv.setText("");
                    } else {
                        viewHolder.et_lv.setText(elementDetail.getValue());
                    }
                    viewHolder.et_lv.setTag(elementDetail);
                    viewHolder.et_lv.addTextChangedListener(new GenericTextWatcher(viewHolder.et_lv));
                    viewHolder.fm_lv.addView(viewHolder.et_lv);
                }

                break;
            case 1:
                viewHolder.tv_lv.setText(key);
                for (int j = 0; j < viewHolder.fm_lv.getChildCount(); j++) {
                    viewHolder.fm_lv.removeViewAt(j);
                }
                viewHolder.fm_lv.removeAllViews();
                if (viewHolder.fm_lv.getChildCount() == 0) {
                    viewHolder.rg_lv = new RadioGroup(mContext);
                }
                viewHolder.rg_lv.setTag(R.id.rg_object, elementDetail);
                viewHolder.rg_lv.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        elementDetail.setIsEntered(true);
                        elementDetail.setValue(i + "");
                    }
                });
                viewHolder.fm_lv.addView(viewHolder.rg_lv);
                ArrayList<String> rg_cl = elementDetail.getContentList();
                viewHolder.rg_lv.setOrientation(LinearLayout.VERTICAL);
                for (int j = 0; j < viewHolder.rg_lv.getChildCount(); j++) {
                    viewHolder.rg_lv.removeViewAt(j);
                }
                viewHolder.rg_lv.removeAllViews();
                if (viewHolder.rg_lv.getChildCount() == 0) {
                    for (int i2 = 0; i2 < rg_cl.size(); i2++) {
                        RadioButton rdbtn = new RadioButton(mContext);
                        rdbtn.setText(rg_cl.get(i2));
                        rdbtn.setId(i2);
                        if (elementDetail.isEntered()) {
                            if (rdbtn.getId() == Integer.parseInt(elementDetail.getValue()))
                                rdbtn.setChecked(true);
                        }
                        viewHolder.rg_lv.addView(rdbtn);
                    }
                }
                break;
            case 2:
                viewHolder.tv_lv.setText(key);
                final LinkedHashMap<String, Boolean> cb_cl = elementDetail.getMultiSelectContentList();
                final String[] mKeys = (String[]) cb_cl.keySet().toArray(new String[cb_cl.size()]);
                for (int j = 0; j < viewHolder.fm_lv.getChildCount(); j++) {
                    viewHolder.fm_lv.removeViewAt(j);
                }
                viewHolder.fm_lv.removeAllViews();
                if (viewHolder.fm_lv.getChildCount() == 0) {
                    for (int i2 = 0; i2 < cb_cl.size(); i2++) {
                        CheckBox cbbtn = new CheckBox(mContext);
                        cbbtn.setText(mKeys[i2]);
                        cbbtn.setId(i2);
                        if (cb_cl.get(mKeys[i2]))
                            cbbtn.setChecked(true);
                        else
                            cbbtn.setChecked(false);
                        cbbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                                for (int j = 0; j < cb_cl.size(); j++) {
                                    if (compoundButton.getText().equals(mKeys[j])) {
                                        if (b)
                                            cb_cl.put(mKeys[j], true);
                                        else
                                            cb_cl.put(mKeys[j], false);
                                    }
                                }

                                elementDetail.setMultiSelectContentList(cb_cl);
                            }
                        });
                        viewHolder.fm_lv.addView(cbbtn);
                    }
                }
                break;

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public final static class ListItemViewHolder extends RecyclerView.ViewHolder {
        EditText et_lv;
        Spinner spin_lv;
        RadioGroup rg_lv;
        TextView tv_lv;
        LinearLayout fm_lv;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            tv_lv = (TextView) itemView.findViewById(R.id.tv_gv);
            fm_lv = (LinearLayout) itemView.findViewById(R.id.linear_lv);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getViewType();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    private class GenericTextWatcher implements TextWatcher {

        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            ElementDetails ed = (ElementDetails) view.getTag();
            String text = charSequence.toString();
            if (text.equalsIgnoreCase("")) {
                ed.setValue(mContext.getString(R.string.dummy_value));
            } else {
                ed.setValue(text);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }
}
