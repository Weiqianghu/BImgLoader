package com.huweiqiang.butil.load;

import com.huweiqiang.butil.request.LoadRequest;

/**
 * Description ${Desc}
 * Author huweiqiang
 * Date 2016/9/9.
 */
public interface LoadImage {
    void loadImg(LoadRequest loadRequest);

    void next(LoadRequest loadRequest);
}
