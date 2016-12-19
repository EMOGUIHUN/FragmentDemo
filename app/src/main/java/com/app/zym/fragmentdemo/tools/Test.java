package com.app.zym.fragmentdemo.tools;

import java.util.List;

/**
 * Created by Administrator on 2016/12/12.
 */

public class Test {

    public List<LunboItem> lunbo;
    public List<MeinvItem> meinv;

    public class LunboItem{
        public String id;
        public String gid;
        public String username;
        public String name;
        public String age;
        public String gname;
        public String header;
        public String pic;
        public String type;
        public String hotValue;
        public String userType;
    }

    public class MeinvItem{
        public String title;
        public String gid;
        public List<MeinvList> list;
    }

    public class MeinvList{
        public String id;
        public String gid;
        public String username;
        public String name;
        public String age;
        public String gname;
        public String header;
        public String type;
        public String hotValue;
        public String userType;
    }
}
