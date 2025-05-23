//package com.example.endtoendencryptionsystem.widget;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.drawable.Drawable;
//import android.text.Spannable;
//import android.text.SpannableString;
//import android.text.SpannableStringBuilder;
//import android.text.style.ImageSpan;
//import android.util.AttributeSet;
//import android.view.View;
//
//import androidx.annotation.NonNull;
//import androidx.core.content.ContextCompat;
//
//import com.bc.wechat.R;
//import com.bc.wechat.entity.User;
//import com.bc.wechat.moments.spannable.CircleMovementMethod;
//import com.bc.wechat.moments.spannable.SpannableClickable;
//import com.bc.wechat.utils.CollectionUtils;
//
//import java.util.List;
//
///**
// * 朋友圈点赞列表
// *
// * @author zhou
// */
//public class MomentsLikeListView extends androidx.appcompat.widget.AppCompatTextView {
//
//    private int itemColor;
//    private int itemSelectorColor;
//    private List<User> mLikeUserList;
//    private OnItemClickListener onItemClickListener;
//
//    public OnItemClickListener getOnItemClickListener() {
//        return onItemClickListener;
//    }
//
//    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }
//
//    public MomentsLikeListView(Context context) {
//        super(context);
//    }
//
//    public MomentsLikeListView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        initAttrs(attrs);
//    }
//
//    public MomentsLikeListView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        initAttrs(attrs);
//    }
//
//    private void initAttrs(AttributeSet attrs) {
//        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.MomentsLikeListView, 0, 0);
//        try {
//            // textview的默认颜色
//            itemColor = typedArray.getColor(R.styleable.MomentsLikeListView_item_color,
//                    ContextCompat.getColor(getContext(), R.color.navy_blue));
//            itemSelectorColor = typedArray.getColor(R.styleable.MomentsLikeListView_item_selector_color,
//                    ContextCompat.getColor(getContext(), R.color.praise_item_selector_default));
//
//        } finally {
//            typedArray.recycle();
//        }
//    }
//
//    public List<User> getData() {
//        return mLikeUserList;
//    }
//
//    public void setData(List<User> likeUserList) {
//        this.mLikeUserList = likeUserList;
//        notifyDataSetChanged();
//    }
//
//    public void notifyDataSetChanged() {
//        SpannableStringBuilder builder = new SpannableStringBuilder();
//        if (!CollectionUtils.isEmpty(mLikeUserList)) {
//            //添加点赞图标
//            builder.append(setImageSpan());
//            User item;
//            for (int i = 0; i < mLikeUserList.size(); i++) {
//                item = mLikeUserList.get(i);
//                if (item != null) {
//                    builder.append(setClickableSpan(item.getUserNickName(), i));
//                    if (i != (mLikeUserList.size() - 1)) {
//                        builder.append(",");
//                    }
//                }
//            }
//        }
//        setText(builder);
//        setMovementMethod(new CircleMovementMethod(itemSelectorColor));
//    }
//
//    private SpannableString setImageSpan() {
//        String text = "  ";
//        SpannableString imgSpanText = new SpannableString(text);
//        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.icon_like);
//        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//        ImageSpan imageSpan = new ImageSpan(drawable);
//        imgSpanText.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        return imgSpanText;
//    }
//
//    @NonNull
//    private SpannableString setClickableSpan(String textStr, final int position) {
//        SpannableString subjectSpanText = new SpannableString(textStr);
//        subjectSpanText.setSpan(new SpannableClickable(itemColor) {
//                                    @Override
//                                    public void onClick(View widget) {
//                                        if (onItemClickListener != null) {
//                                            onItemClickListener.onClick(position);
//                                        }
//                                    }
//                                }, 0, subjectSpanText.length(),
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return subjectSpanText;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//    }
//
//    public interface OnItemClickListener {
//        void onClick(int position);
//    }
//
//}