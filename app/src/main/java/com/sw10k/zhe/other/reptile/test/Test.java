package com.sw10k.zhe.other.reptile.test;

import android.os.AsyncTask;

import com.sw10k.zhe.other.reptile.bean.CommonException;
import com.sw10k.zhe.other.reptile.bean.NewsItem;
import com.sw10k.zhe.other.reptile.biz.NewsItemBiz;
import com.sw10k.zhe.other.reptile.csdn.Constant;

import java.util.ArrayList;
import java.util.List;


public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.test01();
    }

    public void test01() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                List<NewsItem> newsItems = new ArrayList<>();
                NewsItemBiz biz = new NewsItemBiz();
                try {
                    newsItems = biz.getNewsItems(Constant.NEWS_TYPE_CHENGXUYUAN, 1);
                } catch (CommonException e) {
                    e.printStackTrace();
                }
                for (NewsItem item : newsItems) {
                    System.out.println(item);
                }
            }
        }).start();
    }

    //	@org.junit.Test
    public void test02() {

        final int currentPage = 1;

        NewsAsyncTask task = new NewsAsyncTask(currentPage);
        task.execute();
    }

    class NewsAsyncTask extends AsyncTask<String, Integer, List<NewsItem>> {

        private int currentPage;

        public NewsAsyncTask(int currentPage) {
            this.currentPage = currentPage;
        }

        @Override
        protected List<NewsItem> doInBackground(String... params) {
            List<NewsItem> newsItems = new ArrayList<>();
            try {
                final NewsItemBiz biz = new NewsItemBiz();
                /**
                 * 业界
                 */
                System.out.println("-----------业界-----------");
                newsItems = biz.getNewsItems(Constant.NEWS_TYPE_YEJIE, currentPage);
                for (NewsItem item : newsItems) {
                    System.out.println(item);
                }

                /**
                 * 程序员杂志
                 */
                System.out.println("-----------程序员-----------");
                newsItems = biz.getNewsItems(Constant.NEWS_TYPE_CHENGXUYUAN, currentPage);
                for (NewsItem item : newsItems) {
                    System.out.println(item);
                }

                /**
                 * 研发
                 */
                System.out.println("-----------研发-----------");
                newsItems = biz.getNewsItems(Constant.NEWS_TYPE_YANFA, currentPage);
                for (NewsItem item : newsItems) {
                    System.out.println(item);
                }


                /**
                 * 移动
                 */
                System.out.println("-------------移动---------");
                newsItems = biz.getNewsItems(Constant.NEWS_TYPE_YIDONG, currentPage);
                for (NewsItem item : newsItems) {
                    System.out.println(item);
                }
                System.out.println("-------------结束---------");
            } catch (CommonException e) {
                e.printStackTrace();
            }
            return newsItems;
        }

        @Override
        protected void onPostExecute(List<NewsItem> s) {
            super.onPostExecute(s);
        }
    }


}
//<div class="unit">
//<h1><a href="http://www.csdn.net/article/2014-07-25/2820877" target="_blank" >微视、美拍等的春天，不是短视频应用的春天</a></h1>
//<h4>发表于<span class="ago">2014-07-25 16:52</span>|<span class="view_time">690次阅读</span>|<span class="num_recom">6条评论</span></h4>
//<dl>
//	<dt>
//							<a href="http://www.csdn.net/article/2014-07-25/2820877" target="_blank"><img src="http://cms.csdnimg.cn/article/201407/25/53d21abd54a77.jpg" alt="" /></a>
//							</dt>
//	<dd>微视、美拍等短视频应用最近很火，它们都已经在App Store社交免费榜靠前。它们的流行，能证明短视频应用的春天到了吗？小谦认为，非也。只有解决4G网络问题、分享问题以及拍摄优化问题后，它的春天才会真正到来。</dd>
//</dl>
//<div class="tag"><a href="http://www.csdn.net/tag/%E5%B0%8F%E8%B0%A6/news" target="_blank">小谦</a><a href="http://www.csdn.net/tag/%E5%BE%AE%E8%A7%86/news" target="_blank">微视</a><a href="http://www.csdn.net/tag/%E7%A7%92%E6%8B%8D/news" target="_blank">秒拍</a><a href="http://www.csdn.net/tag/%E7%BE%8E%E5%9B%BE%E7%A7%80%E7%A7%80/news" target="_blank">美图秀秀</a><a href="http://www.csdn.net/tag/%E7%BE%8E%E6%8B%8D/news" target="_blank">美拍</a><a href="http://www.csdn.net/tag/%E5%BE%AE%E4%BF%A1/news" target="_blank">微信</a><a href="http://www.csdn.net/tag/%E5%BA%94%E7%94%A8/news" target="_blank">应用</a><a href="http://www.csdn.net/tag/%E7%9F%AD%E8%A7%86%E9%A2%91/news" target="_blank">短视频</a></div>
//</div>

