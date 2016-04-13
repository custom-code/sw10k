package com.zhe.core.mvp;

/**
 * Created by zhe on 16/3/10.
 */
public interface View {
    void showLoading(String message);

    void hideLoading(boolean sucess);

    void showActionLabel(String message);

    void hideActionLabel();
}
