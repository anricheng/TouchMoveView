package chou.aric.mytest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;

/**
 *
 * Created by aric on 16/7/28.
 */
public class MoveAbleView extends ImageView {
    private int lastX;
    private int lastY;
    Scroller mScroller;

    public MoveAbleView(Context context) {
        super(context);
        mScroller=new Scroller(context);


    }

    public MoveAbleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller=new Scroller(context);
    }

    public MoveAbleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller=new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if(mScroller.computeScrollOffset()){//代表尚没有完成整个的滑动过程,需要继续调用invalidate 方法去重绘画;
            ( (View)getParent() ).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }

        @Override
    public boolean onTouchEvent(MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_UP:
            case 5:
                ViewGroup parent = (ViewGroup) getParent();
                mScroller.startScroll(parent.getScrollX(),parent.getScrollY(),-parent.getScrollX(),-parent.getScrollY());
                invalidate();


                break;
            case MotionEvent.ACTION_DOWN:
                lastX = rawX;
                lastY = rawY;
                break;
//            case MotionEvent.ACTION_MOVE:
//                int offsetX = rawX - lastX;
//                int offsetY = rawY - lastY;
//
//                switch (5) {
//
//                    case 1:
//
//                        int left = getLeft()+offsetX;
//                        int top= getTop()+offsetX;
//                        int right = getRight()+offsetX;
//                        int bottom = getBottom()+offsetY;
//
//                        if (getPaddingLeft()<0){
//                            left=0; right=getMeasuredHeight();
//                        }
//
//                        if (getPaddingTop()<0){
//                            top=0;bottom=getMeasuredHeight();
//                        }
//
//
//                        layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
//                        break;
//                    case 2:
//                        offsetLeftAndRight(offsetX);
//                        offsetTopAndBottom(offsetY);
//                        break;
//                    case 3:
//                        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
//                        layoutParams.leftMargin = getLeft()+offsetX;
//                        layoutParams.topMargin = getTop()+offsetY;
//                        setLayoutParams(layoutParams);
//                        break;
//                    case 4:
//                        ((View) getParent()).scrollBy(-offsetX, -offsetY);
//                        break;
//
//                }
//                lastY = rawY;
//                lastX = rawX;
//                break;

        }

        return true;
    }

}
