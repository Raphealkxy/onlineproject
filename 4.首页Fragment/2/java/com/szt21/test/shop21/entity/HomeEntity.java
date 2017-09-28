package com.szt21.test.shop21.entity;

import java.util.List;

/**
 * www.itszt.com
 * Created by 958122683@qq.com on 2017/6/29.
 */

public class HomeEntity {
    
    /**
     * response : home
     * home_classlist : [{"id":"1","pic":"http://192.168.1.236/images/home/gallery1/1.png","title":"限时抢购","type":"1"},{"id":"2","pic":"http://192.168.1.236/images/home/gallery1/2.png","title":"促销快报","type":"2"},{"id":"3","pic":"http://192.168.1.236/images/home/gallery1/3.png","title":"新品上架","type":"3"},{"id":"4","pic":"http://192.168.1.236/images/home/gallery1/4.png","title":"热门单品","type":"4"},{"id":"5","pic":"http://192.168.1.236/images/home/gallery1/5.png","title":"推荐品牌","type":"5"}]
     * home_banner : [{"id":"1","pic":"http://192.168.1.236/images/home/gallery/1.png","title":"活动1"},{"id":"2","pic":"http://192.168.1.236/images/home/gallery/2.png","title":"活动2"},{"id":"3","pic":"http://192.168.1.236/images/home/gallery/3.png","title":"活动3"},{"id":"4","pic":"http://192.168.1.236/images/home/gallery/4.png","title":"活动4"},{"id":"5","pic":"http://192.168.1.236/images/home/gallery/5.png","title":"活动5"}]
     */
    
    private String response;
    private List<HomeClasslistEntity> home_classlist;
    private List<HomeBannerEntity> home_banner;
    
    public String getResponse() {
        return response;
    }
    
    public void setResponse(String response) {
        this.response = response;
    }
    
    public List<HomeClasslistEntity> getHome_classlist() {
        return home_classlist;
    }
    
    public void setHome_classlist(List<HomeClasslistEntity> home_classlist) {
        this.home_classlist = home_classlist;
    }
    
    public List<HomeBannerEntity> getHome_banner() {
        return home_banner;
    }
    
    public void setHome_banner(List<HomeBannerEntity> home_banner) {
        this.home_banner = home_banner;
    }
    
    public static class HomeClasslistEntity {
        /**
         * id : 1
         * pic : http://192.168.1.236/images/home/gallery1/1.png
         * title : 限时抢购
         * type : 1
         */
        
        private String id;
        private String pic;
        private String title;
        private String type;
        
        public String getId() {
            return id;
        }
        
        public void setId(String id) {
            this.id = id;
        }
        
        public String getPic() {
            return pic;
        }
        
        public void setPic(String pic) {
            this.pic = pic;
        }
        
        public String getTitle() {
            return title;
        }
        
        public void setTitle(String title) {
            this.title = title;
        }
        
        public String getType() {
            return type;
        }
        
        public void setType(String type) {
            this.type = type;
        }
    }
    
    public static class HomeBannerEntity {
        /**
         * id : 1
         * pic : http://192.168.1.236/images/home/gallery/1.png
         * title : 活动1
         */
        
        private String id;
        private String pic;
        private String title;
        
        public String getId() {
            return id;
        }
        
        public void setId(String id) {
            this.id = id;
        }
        
        public String getPic() {
            return pic;
        }
        
        public void setPic(String pic) {
            this.pic = pic;
        }
        
        public String getTitle() {
            return title;
        }
        
        public void setTitle(String title) {
            this.title = title;
        }
    }
}
