package com.example.i.AndroidDemos.constant.bean;

import java.util.List;

/**
 * Created by I on 2017/8/30.
 */

public class CategoryDataModel {

    private LinkBean link;
    private List<DataBean> data;

    public LinkBean getLink() {
        return link;
    }

    public void setLink(LinkBean link) {
        this.link = link;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class LinkBean {

        private String prev;
        private String next;

        public String getPrev() {
            return prev;
        }

        public void setPrev(String prev) {
            this.prev = prev;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }
    }

    public static class DataBean {

        private String key;
        private String small;
        private String big;
        private int down;
        private String down_stat;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getBig() {
            return big;
        }

        public void setBig(String big) {
            this.big = big;
        }

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public String getDown_stat() {
            return down_stat;
        }

        public void setDown_stat(String down_stat) {
            this.down_stat = down_stat;
        }
    }
}

