package com.example.kkyasa.gridviewtest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = (ListView) findViewById(R.id.lv);

        ArrayList<ElementDetails> jsonMap;

        jsonMap = new ArrayList<ElementDetails>();
        ElementDetails fn_ed = new ElementDetails();
        fn_ed.setViewType(0);
        fn_ed.setContentType("name");
        fn_ed.setKey("First Name");
        fn_ed.setValue(getString(R.string.dummy_value));

        jsonMap.add(0, fn_ed);

        ElementDetails ln_ed = new ElementDetails();
        ln_ed.setViewType(0);
        ln_ed.setContentType("name");
        ln_ed.setKey("Last Name");
        ln_ed.setValue(getString(R.string.dummy_value));
        jsonMap.add(1, ln_ed);

        ElementDetails gen_ed = new ElementDetails();
        gen_ed.setViewType(1);
        ArrayList<String> cl = new ArrayList<>();
        cl.add(0, "male");
        cl.add(1, "female");
        gen_ed.setContentList(cl);
        gen_ed.setKey("gender");
        jsonMap.add(2, gen_ed);

        ElementDetails hno_ed = new ElementDetails();
        hno_ed.setViewType(0);
        hno_ed.setContentType("text");
        hno_ed.setKey("hno");
        hno_ed.setValue(getString(R.string.dummy_value));
        jsonMap.add(3, hno_ed);

        ElementDetails stno_ed = new ElementDetails();
        stno_ed.setViewType(0);
        stno_ed.setContentType("number");
        stno_ed.setKey("stno");
        stno_ed.setValue(getString(R.string.dummy_value));
        jsonMap.add(4, stno_ed);

        ElementDetails lndmrk_ed = new ElementDetails();
        lndmrk_ed.setViewType(0);
        lndmrk_ed.setContentType("text");
        lndmrk_ed.setKey("landmark");
        lndmrk_ed.setValue(getString(R.string.dummy_value));
        jsonMap.add(5, lndmrk_ed);

        ElementDetails zip_ed = new ElementDetails();
        zip_ed.setViewType(0);
        zip_ed.setContentType("number");
        zip_ed.setKey("zipcode");
        zip_ed.setValue(getString(R.string.dummy_value));
        jsonMap.add(6, zip_ed);

        ElementDetails email_ed = new ElementDetails();
        email_ed.setViewType(1);
        email_ed.setContentType("email");
        ArrayList c11 = new ArrayList();
        c11.add(0, "a@b.c");
        c11.add(1, "x@y.z");
        email_ed.setContentList(c11);
        email_ed.setValue(getString(R.string.dummy_value));
        email_ed.setKey("email");
        jsonMap.add(7, email_ed);


        ElementDetails fruit_ed = new ElementDetails();
        fruit_ed.setViewType(2);
        LinkedHashMap<String, Boolean> c12 = new LinkedHashMap<>();
        c12.put("apple", false);
        c12.put("orange", false);
        c12.put("mango", false);
        c12.put("banana", false);
        fruit_ed.setMultiSelectContentList(c12);
        fruit_ed.setValue(getString(R.string.dummy_value));
        fruit_ed.setKey("Fruits");
        jsonMap.add(8, fruit_ed);

        percentListAdapter listAdapter = new percentListAdapter(jsonMap);
        lv.setAdapter(listAdapter);


    }


    private class percentListAdapter extends BaseAdapter {
        ViewHolder viewHolder;
        ArrayList<ElementDetails> jsonMap;
        ArrayList<ItemDetails> ids;
        JSONObject json;
        String[] mKeys;

        public percentListAdapter(ArrayList<ElementDetails> jsonMap) {
            this.jsonMap = jsonMap;
        }

        @Override
        public int getCount() {
            return jsonMap.size();
        }

        @Override
        public Object getItem(int i) {
            return jsonMap.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public int getViewTypeCount() {
            return 3;
        }

        @Override
        public int getItemViewType(int position) {
            return ((ElementDetails) getItem(position)).getViewType();
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                viewHolder = new ViewHolder();
                view = inflater.inflate(R.layout.list_product_view, viewGroup, false);
                viewHolder.tv_lv = (TextView) view.findViewById(R.id.tv_gv);
                viewHolder.fm_lv = (LinearLayout) view.findViewById(R.id.linear_lv);
                view.setTag(R.id.viewHolder, viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag(R.id.viewHolder);
            }
            String key = ((ElementDetails) getItem(i)).getKey();
            final ElementDetails elementDetail = (ElementDetails) getItem(i);
            view.setTag(R.id.object, elementDetail);

            switch (getItemViewType(i)) {
                case 0:
                    viewHolder.tv_lv.setText(key);
                    for (int j = 0; j < viewHolder.fm_lv.getChildCount(); j++) {
                        viewHolder.fm_lv.removeViewAt(j);
                    }
                    viewHolder.fm_lv.removeAllViews();
                    if (viewHolder.fm_lv.getChildCount() == 0) {
                        viewHolder.et_lv = new EditText(MainActivity.this);
                        if (elementDetail.getValue().equalsIgnoreCase(getString(R.string.dummy_value))) {
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
                        viewHolder.rg_lv = new RadioGroup(MainActivity.this);
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
                            RadioButton rdbtn = new RadioButton(MainActivity.this);
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
                            CheckBox cbbtn = new CheckBox(MainActivity.this);
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
            return view;
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
                    ed.setValue(getString(R.string.dummy_value));
                } else {
                    ed.setValue(text);
                }
            }

            public void afterTextChanged(Editable editable) {
            }
        }
    }


    static class ViewHolder {
        EditText et_lv;
        Spinner spin_lv;
        RadioGroup rg_lv;
        TextView tv_lv;
        LinearLayout fm_lv;
    }
}
