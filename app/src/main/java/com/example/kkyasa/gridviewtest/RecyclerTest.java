package com.example.kkyasa.gridviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RecyclerTest extends AppCompatActivity {
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        rcv = (RecyclerView) findViewById(R.id.rcv);

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

        ElementDetails fn_ed1 = new ElementDetails();
        fn_ed1.setViewType(0);
        fn_ed1.setContentType("name");
        fn_ed1.setKey("First Name1");
        fn_ed1.setValue(getString(R.string.dummy_value));

        jsonMap.add(9, fn_ed1);

        ElementDetails ln_ed1 = new ElementDetails();
        ln_ed1.setViewType(0);
        ln_ed1.setContentType("name");
        ln_ed1.setKey("Last Name1");
        ln_ed1.setValue(getString(R.string.dummy_value));
        jsonMap.add(10, ln_ed1);

        ElementDetails gen_ed1 = new ElementDetails();
        gen_ed1.setViewType(1);
        ArrayList<String> cl1 = new ArrayList<>();
        cl1.add(0, "male1");
        cl1.add(1, "female1");
        gen_ed1.setContentList(cl1);
        gen_ed1.setKey("gender");
        jsonMap.add(11, gen_ed1);

        ElementDetails hno_ed1 = new ElementDetails();
        hno_ed1.setViewType(0);
        hno_ed1.setContentType("text");
        hno_ed1.setKey("hno1");
        hno_ed1.setValue(getString(R.string.dummy_value));
        jsonMap.add(12, hno_ed1);

        ElementDetails stno_ed1 = new ElementDetails();
        stno_ed1.setViewType(0);
        stno_ed1.setContentType("number");
        stno_ed1.setKey("stno1");
        stno_ed1.setValue(getString(R.string.dummy_value));
        jsonMap.add(13, stno_ed1);

        ElementDetails lndmrk_ed1 = new ElementDetails();
        lndmrk_ed1.setViewType(0);
        lndmrk_ed1.setContentType("text");
        lndmrk_ed1.setKey("landmark1");
        lndmrk_ed1.setValue(getString(R.string.dummy_value));
        jsonMap.add(14, lndmrk_ed1);

        ElementDetails zip_ed1 = new ElementDetails();
        zip_ed1.setViewType(0);
        zip_ed1.setContentType("number");
        zip_ed1.setKey("zipcode1");
        zip_ed1.setValue(getString(R.string.dummy_value));
        jsonMap.add(15, zip_ed1);

        ElementDetails email_ed1 = new ElementDetails();
        email_ed1.setViewType(1);
        email_ed1.setContentType("email");
        ArrayList c111 = new ArrayList();
        c111.add(0, "a@b.c1");
        c111.add(1, "x@y.z1");
        email_ed1.setContentList(c11);
        email_ed1.setValue(getString(R.string.dummy_value));
        email_ed1.setKey("email1");
        jsonMap.add(16, email_ed1);


        ElementDetails fruit_ed1 = new ElementDetails();
        fruit_ed1.setViewType(2);
        LinkedHashMap<String, Boolean> c112 = new LinkedHashMap<>();
        c112.put("apple1", false);
        c112.put("orange1", false);
        c112.put("mango1", false);
        c112.put("banana1", false);
        fruit_ed1.setMultiSelectContentList(c112);
        fruit_ed1.setValue(getString(R.string.dummy_value));
        fruit_ed1.setKey("Fruits1");
        jsonMap.add(17, fruit_ed1);


        final RecyclerAdapter adapter = new RecyclerAdapter(jsonMap,RecyclerTest.this);
        rcv.setAdapter(adapter);

        final GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        // actually VERTICAL is the default,
        // just remember: LinearLayoutManager
        // supports HORIZONTAL layout out of the box
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // you can set the first visible item like this:
        layoutManager.scrollToPosition(0);
        rcv.setLayoutManager(layoutManager);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int a;
                switch (adapter.getItemViewType(position)) {
                    case 0:
                        a =1;
                        break;
                    case 1:
                        a =2;
                        break;
                    default:
                        a= 3;
                        break;
                }
                return a>layoutManager.getSpanCount() ? layoutManager.getSpanCount() : a;
            }
        });

        // allows for optimizations if all items are of the same size:
        rcv.setHasFixedSize(true);
    }
}
