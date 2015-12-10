package com.example.kkyasa.gridviewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by kkyasa on 10/8/2015.
 */
public class BlockingListView extends ListView{
    private boolean mBlockLayoutChildren;

    public BlockingListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setBlockLayoutChildren(boolean block) {
        mBlockLayoutChildren = block;
    }

    @Override
    protected void layoutChildren() {
        if (!mBlockLayoutChildren) {
            super.layoutChildren();
        }
    }
}
