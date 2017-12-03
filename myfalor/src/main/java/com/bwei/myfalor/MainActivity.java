package com.bwei.myfalor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bwei.myfalor.back.CallBack;
import com.bwei.myfalor.bean.BannerBean;
import com.bwei.myfalor.utils.OkhttpUtils;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Banner banShow;
    private List<String> images=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banShow = (Banner) findViewById(R.id.ban_show);
        initData();
    }

    private void initData() {
        OkhttpUtils okhttpUtils=new OkhttpUtils();
        okhttpUtils.get("http://120.27.23.105/ad/getAd", BannerBean.class, new CallBack() {

            @Override
            public void onSuccess(Object o) {
                BannerBean bannerBean= (BannerBean) o;
                final List<BannerBean.DataBean> data = bannerBean.getData();
                for (int i = 0; i < data.size(); i++) {
                    images.add(data.get(i).getIcon());
                }
                banShow.setImageLoader(new GliderImageloader() );
                banShow.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        int type = data.get(position).getType();
                        if (type==0){
                            Intent intent = new Intent(MainActivity.this, WebActivity.class);
                            String url = data.get(position).getUrl().toString();
                            intent.putExtra("url",url);
                            startActivity(intent);
                        }else {
                            Toast.makeText(MainActivity.this,"我要跳转到商品详情页",Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                banShow.setDelayTime(2000);
                banShow.setImages(images);
                banShow.isAutoPlay(true);
                banShow.start();

            }

            @Override
            public void onFailed(Exception e) {
                Toast.makeText(MainActivity.this,""+e,Toast.LENGTH_SHORT).show();;
            }
        });

    }
}
