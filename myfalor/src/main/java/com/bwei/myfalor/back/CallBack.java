package com.bwei.myfalor.back;

/**
 * author:Created by QiZhiWei on 2017/12/2.
 */

public interface CallBack {
    void onSuccess(Object o);
    void onFailed(Exception e);
}
