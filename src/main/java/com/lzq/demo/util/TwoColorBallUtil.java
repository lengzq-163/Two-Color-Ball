package com.lzq.demo.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.lzq.demo.entity.TwoColorBall;
import com.lzq.demo.http.HttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @Author: zq_leng
 * @Description: 双色球模拟代码
 * @Time: 17:16 2021/1/26
 */
public class TwoColorBallUtil {
    public static void main(String[] args) {
        //打印蓝球型号分组
//        BlueBall.getModelList();
//        getDataFromBeiBei();
//        getDataFrom500("03001","21011");
        getNewestPeriods();
    }

    /**
     * 从500网获取数据
     * @param start 起始期数
     * @param end 截止期数
     */
    public static List<TwoColorBall> getDataFrom500(String start,String end){
        //创建开奖星期数组
        String[] weeks = {"日","四","二"};
        //获取当前日期,判断当前星期
        Calendar cl = Calendar.getInstance();
        //日-1,一-2,二-3,三-4,四-5,五-6,六-7
        int weekDay = cl.get(Calendar.DAY_OF_WEEK);
        //创建星期数组的索引初始值
        int weekIndex = -1;
        if(weekDay<3){
            weekIndex = 0;
        }else if(weekDay<5){
            weekIndex=2;
        }else {
            weekIndex=1;
        }
        String url = "http://datachart.500.com/ssq/history/newinc/history.php?start="+start+"&end="+end;
        //header parameters
        String cookie= "BAIDU_SSP_lcr=https://www.baidu.com/link?url=z210SIAlOwCOwJqjJc2KFHJcqRNLedJ890l4fAgw3Pm&wd=&eqid=f6e9bff8000976ae0000000660110221; sdc_session=1611727397954; seo_key=baidu%7C%7Chttps://www.baidu.com/link?url=z210SIAlOwCOwJqjJc2KFHJcqRNLedJ890l4fAgw3Pm&wd=&eqid=f6e9bff8000976ae0000000660110221; _jzqa=1.1677740907244220200.1611727398.1611727398.1611727398.1; _jzqc=1; _jzqy=1.1611727398.1611727398.1.jzqsr=baidu.-; _jzqckmp=1; Hm_lvt_4f816d475bb0b9ed640ae412d6b42cab=1611727398; __utma=63332592.1320817600.1611727399.1611727399.1611727399.1; __utmz=63332592.1611727399.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; __utmc=63332592; __utmt=1; ck_RegUrl=zx.500.com; ck_RegFromUrl=http%3A//zx.500.com/; _qzjc=1; bdshare_firstime=1611727462237; WT_FPC=id=undefined:lv=1611727720478:ss=1611727462185; sdc_userflag=1611727397955::1611727720481::7; Hm_lpvt_4f816d475bb0b9ed640ae412d6b42cab=1611727721; _qzja=1.1134358788.1611727462221.1611727462221.1611727462222.1611727501662.1611727720570.0.0.0.5.1; _qzjb=1.1611727462221.5.0.0.0; _qzjto=5.1.0; _jzqb=1.7.10.1611727398.1; __utmb=63332592.14.9.1611727742036; CLICKSTRN_ID=171.214.197.71-1611727398.379333::F22E7DAEB7E0F1A557A9758D4D8E1165; motion_id=1611727780771_0.7386317843182983";
        String host="datachart.500.com";
        String referer= "http://datachart.500.com/ssq/history/history.shtml";
        String result = HttpClient.doGet(url, cookie, host, referer);
        //获取dom内容
        Document document = Jsoup.parse(result);
        //根据id获取数据节点
        Element tdata = document.getElementById("tdata");
        //获取数据节点的所有子节点
        Elements elements = tdata.getElementsByClass("t_tr1");
        //创建数据列表
        List<TwoColorBall> list = new ArrayList<TwoColorBall>();
        //空判断
        if(elements!=null&&elements.size()>0){
            for(Element element:elements){
                //获取第一个子节点
                Element firstChild  = element.children().first();
                //获取子节点内容
                String code = firstChild.text();
                //获取红球
                StringBuilder sb = new StringBuilder();
                //接下来6个节点的内容都是红球
                int index = 0;
                while (index++<6){
                    Element child = element.child(index);
                    sb.append(child.text()).append(",");
                }
                //替换最后一个逗号,并赋值给红球
                String red = sb.replace(sb.length()-1,sb.length(),"").toString();
                //获取蓝球
                String blue = element.child(index).text();
                //获取开奖日期
                String date = element.children().last().text();
                list.add(new TwoColorBall(code,blue,red,weeks[weekIndex++],date));
                //重置星期索引
                if(weekIndex==3){
                    weekIndex=0;
                }
            }
        }
        return list;
    }

    /**
     * 获取网页中最新一期的期数
     */
    public static String getNewestPeriods(){
        String url = "http://zx.500.com/ssq/";
        //header parameters
        String cookie= "BAIDU_SSP_lcr=https://www.baidu.com/link?url=z210SIAlOwCOwJqjJc2KFHJcqRNLedJ890l4fAgw3Pm&wd=&eqid=f6e9bff8000976ae0000000660110221; sdc_session=1611727397954; seo_key=baidu%7C%7Chttps://www.baidu.com/link?url=z210SIAlOwCOwJqjJc2KFHJcqRNLedJ890l4fAgw3Pm&wd=&eqid=f6e9bff8000976ae0000000660110221; _jzqa=1.1677740907244220200.1611727398.1611727398.1611727398.1; _jzqc=1; _jzqy=1.1611727398.1611727398.1.jzqsr=baidu.-; _jzqckmp=1; Hm_lvt_4f816d475bb0b9ed640ae412d6b42cab=1611727398; __utma=63332592.1320817600.1611727399.1611727399.1611727399.1; __utmz=63332592.1611727399.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; __utmc=63332592; __utmt=1; ck_RegUrl=zx.500.com; ck_RegFromUrl=http%3A//zx.500.com/; _qzjc=1; bdshare_firstime=1611727462237; WT_FPC=id=undefined:lv=1611727720478:ss=1611727462185; sdc_userflag=1611727397955::1611727720481::7; Hm_lpvt_4f816d475bb0b9ed640ae412d6b42cab=1611727721; _qzja=1.1134358788.1611727462221.1611727462221.1611727462222.1611727501662.1611727720570.0.0.0.5.1; _qzjb=1.1611727462221.5.0.0.0; _qzjto=5.1.0; _jzqb=1.7.10.1611727398.1; __utmb=63332592.14.9.1611727742036; CLICKSTRN_ID=171.214.197.71-1611727398.379333::F22E7DAEB7E0F1A557A9758D4D8E1165; motion_id=1611727780771_0.7386317843182983";
        String host="zx.500.com";
        String referer= "http://zx.500.com";
        String result = HttpClient.doGet(url, cookie, host, referer);
        //获取dom内容
        Document document = Jsoup.parse(result);
        //根据id获取节点
        Element element = document.getElementById("kj_expect");
        //获取最新期数
        return element.child(0).val();
    }

    /**
     * 从贝贝网获取数据
     */
    static void getDataFromBeiBei(){
        String url = "http://www.cwl.gov.cn/cwl_admin/kjxx/findDrawNotice?name=ssq&issueCount=&issueStart=&issueEnd=&dayStart=2013-01-01&dayEnd=2021-01-27&pageNo=";
        //header parameters
        String cookie= "UniqueID=ce3dVGqvhvbcpzX81611716189778; Sites=_21; _ga=GA1.3.1367651259.1611716190; _gid=GA1.3.1564585976.1611716190; 21_vq=2";
        String host="www.cwl.gov.cn";
        String referer= "http://www.cwl.gov.cn/kjxx/ssq/kjgg/";
        JsonObject jsonObject = new JsonParser().parse(HttpClient.doGet(url,cookie,host,referer)).getAsJsonObject();
        //成功
        if(jsonObject.get("state").getAsInt()==0){
            Gson gson = new Gson();
            //获取第一页数据
            List<TwoColorBall> list = gson.fromJson(jsonObject.get("result").getAsJsonArray(),new TypeToken<List<TwoColorBall>>() {}.getType());
            //获取总页数
            int pageCount = jsonObject.get("pageCount").getAsInt();
            int page = 1;
            while (page++<pageCount){
                jsonObject = new JsonParser().parse(HttpClient.doGet(url+page,cookie,host,referer)).getAsJsonObject();
                if(jsonObject.get("state").getAsInt()==0){
                    list.addAll(gson.fromJson(jsonObject.get("result").getAsJsonArray(),new TypeToken<List<TwoColorBall>>() {}.getType()));
                }
            }
        }
    }
}
