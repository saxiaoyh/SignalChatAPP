//package com.example.endtoendencryptionsystem.widget;
//
//import android.content.Context;
//import android.graphics.Paint;
//import android.text.Spannable;
//import android.text.SpannableString;
//import android.text.SpannableStringBuilder;
//import android.text.TextPaint;
//import android.text.TextUtils;
//import android.text.style.ClickableSpan;
//import android.util.AttributeSet;
//import android.view.View;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.core.content.ContextCompat;
//
//import com.example.endtoendencryptionsystem.R;
//import com.bc.wechat.entity.MomentsComment;
//import com.bc.wechat.moments.bean.ExplorePostPinglunBean;
//import com.bc.wechat.moments.spannable.CircleMovementMethod;
//import com.bc.wechat.moments.spannable.ClickableSpan1;
//import com.bc.wechat.utils.CollectionUtils;
//
//import java.util.List;
//
//
///**
// * 朋友圈评论列表
// *
// * @author zhou
// */
//public class CommentsView extends LinearLayout {
//
//    private Context mContext;
//    private List<MomentsComment> mCommentList;
//    private CommentListener onCommentListener;
//
//    public CommentsView(Context context) {
//        this(context, null);
//    }
//
//    public CommentsView(Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public CommentsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        setOrientation(VERTICAL);
//        this.mContext = context;
//    }
//
//    public void setData(List<MomentsComment> commentList) {
//        this.mCommentList = commentList;
//    }
//
//
//    public void setOnCommentListener(CommentListener onCommentListener) {
//        this.onCommentListener = onCommentListener;
//    }
//
//
//    public void notifyDataSetChanged() {
//        removeAllViews();
//        if (CollectionUtils.isEmpty(mCommentList)) {
//            return;
//        }
//        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        layoutParams.setMargins(0, 10, 0, 10);
//        for (int i = 0; i < mCommentList.size(); i++) {
//            View view = getView(i);
//            if (view == null) {
//                throw new NullPointerException("listview item layout is null, please check getView()...");
//            }
//            addView(view, i, layoutParams);
//        }
//    }
//
//    private View getView(final int position) {
//        final MomentsComment item = mCommentList.get(position);
////        UserBean userBean = new UserBean();
////        UserBean replyUser;
////        if (!TextUtils.isEmpty(item.getAltuserid()) && !TextUtils.isEmpty(item.getAltnickname())) {
////            userBean.setUserId(item.getAltuserid());
////            userBean.setUserName(item.getAltnickname());
////            item.setReplyUser(userBean);
////        }
////        replyUser = item.getReplyUser();
////        boolean hasReply = false;   // 是否有回复
////        if (replyUser != null) {
////            hasReply = true;
////        }
//        TextView textView = new TextView(mContext);
//        textView.setTextSize(15);
//        textView.setTextColor(0xff686868);
//        SpannableStringBuilder builder = new SpannableStringBuilder();
////
////        UserBean userComBean = new UserBean();
////        if (item.getUserid() != 0 && item.getUsernickname() != null) {
////            userComBean.setUserId(item.getUserid() + "");
////            userComBean.setUserName(item.getUsernickname());
////            item.setCommentsUser(userComBean);
////        }
////
////        UserBean comUser = item.getCommentsUser();
////
////        String name = comUser.getUserName();
//        if (!TextUtils.isEmpty(item.getReplyToUserId())) {
//            builder.append(setClickableSpan(item.getUserNickName(), item.getUserId()));
//            builder.append("回复");
//            builder.append(setClickableSpan(item.getReplyToUserNickName(), item.getReplyToUserId()));
//        } else {
//            builder.append(setClickableSpan(item.getUserNickName(), item.getUserId()));
//        }
//        builder.append(" : ");
//        builder.append(setClickableSpanContent(textView, item.getContent(), position, item));
//        textView.setText(builder);
//        // 设置点击背景色
//        textView.setHighlightColor(getResources().getColor(android.R.color.transparent));
//        textView.setMovementMethod(new CircleMovementMethod(0xffcccccc, 0xffcccccc));
//        return textView;
//    }
//
//    /**
//     * 设置评论内容点击事件
//     *
//     * @param item
//     * @param position
//     * @return
//     */
//    public SpannableString setClickableSpanContent(final View view, final String item, final int position, final MomentsComment momentsComment) {
//        final SpannableString string = new SpannableString(item);
//        ClickableSpan1 span = new ClickableSpan1() {
//            @Override
//            public void onClick(View widget) {
//                if (onCommentListener != null) {
//                    onCommentListener.CommentClick(view, position, momentsComment);
//                }
//            }
//
//            @Override
//            public void onLongClick(View widget) {
//                if (onCommentListener != null) {
//                    onCommentListener.CommentLongClick(view, position, momentsComment);
//                }
//            }
//
//            @Override
//            public void updateDrawState(TextPaint ds) {
//                super.updateDrawState(ds);
//                // 设置显示的内容文本颜色
//                ds.setColor(0xff686868);
//                ds.setUnderlineText(false);
//            }
//        };
//        string.setSpan(span, 0, string.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return string;
//    }
//
//    /**
//     * 设置评论用户名字点击事件
//     * <p>
//     * //     * @param item
//     * //     * @param bean
//     * //     * @return
//     */
//    public SpannableString setClickableSpan(final String item, final String userId) {
//        final SpannableString string = new SpannableString(item);
//        ClickableSpan span = new ClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//                if (onCommentListener != null) {
//                    onCommentListener.toUser(userId);
//                }
//            }
//
//            @Override
//            public void updateDrawState(TextPaint paint) {
//                super.updateDrawState(paint);
//                // 设置显示的用户名文本颜色
//                paint.setColor(ContextCompat.getColor(getContext(), R.color.navy_blue));
//                paint.setStyle(Paint.Style.FILL_AND_STROKE);
//                // 控制字体加粗的程度
//                paint.setStrokeWidth(0.8f);
//                paint.setUnderlineText(false);
//            }
//        };
//
//        string.setSpan(span, 0, string.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return string;
//    }
//
//
//    public interface onItemLongClickListener {
//        void onItemLongClick(ExplorePostPinglunBean bean);
//    }
//
//    public interface CommentListener {
//        void CommentClick(View view, int position1, MomentsComment momentsComment);
//
//        void CommentLongClick(View view, int position1, MomentsComment momentsComment);
//
//        void toUser(String userid);
//    }
//
//}