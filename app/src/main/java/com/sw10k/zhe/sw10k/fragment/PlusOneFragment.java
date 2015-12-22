package com.sw10k.zhe.sw10k.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.plus.PlusOneButton;
import com.sw10k.zhe.sw10k.R;
import com.sw10k.zhe.sw10k.listener.OnFragmentInteractionListener;

public class PlusOneFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    private final String PLUS_ONE_URL = "http://developer.android.com";

    private String mParam1;
    private String mParam2;

    private PlusOneButton mPlusOneButton;
    private VideoView mVideoView;
    private MediaController controller;
    private Button play;

    private OnFragmentInteractionListener mListener;
    private Context context;
    private Display display;

    public static PlusOneFragment newInstance(String param1, String param2) {
        PlusOneFragment fragment = new PlusOneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public PlusOneFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);
        mPlusOneButton = (PlusOneButton) view.findViewById(R.id.plus_one_button);
        mVideoView = (VideoView) view.findViewById(R.id.video_view);
        controller = new MediaController(context);
        mVideoView.setMediaController(controller);
        controller.setMediaPlayer(mVideoView);
        play = (Button) view.findViewById(R.id.button_play);
        play.setOnClickListener(this);
        display = getActivity().getWindowManager().getDefaultDisplay();
        setVideoViewSize();
        return view;
    }

    private void setVideoViewSize() {
        int vWidth = mVideoView.getWidth();
        int vHeight = mVideoView.getHeight();

        if (vWidth > display.getWidth() || vHeight > display.getHeight()) {
            float wRatio = (float) vWidth / (float) display.getWidth();
            float hRatio = (float) vHeight / (float) display.getHeight();

            //选择大的一个进行缩放
            float ratio = Math.max(wRatio, hRatio);

            vWidth = (int) Math.ceil((float) vWidth / ratio);
            vHeight = (int) Math.ceil((float) vHeight / ratio);

            //设置surfaceView的布局参数
            mVideoView.setLayoutParams(new LinearLayout.LayoutParams(vWidth, vHeight));
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        mPlusOneButton.initialize(PLUS_ONE_URL, PLUS_ONE_REQUEST_CODE);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_play:
                Uri uri = Uri.parse("http://hc.yinyuetai.com/uploads/videos/common/C610014F816532655555F87C505DC13F.flv?sc=42eae861de445ba2");
                mVideoView.setVideoURI(uri);
                mVideoView.requestFocus();
                mVideoView.start();
                break;
        }
    }
}
