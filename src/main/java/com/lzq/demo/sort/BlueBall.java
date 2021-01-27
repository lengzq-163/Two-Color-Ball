package com.lzq.demo.sort;

import java.util.*;

/**
 * @Author: zq_leng
 * @Description: 双色球-蓝球
 * @Time: 9:59 2021/1/27
 */
public class BlueBall {

    public static void getModelList(){
        //创建键值
        Map<String,List<Integer>> map = new LinkedHashMap<String, List<Integer>>();
        //生成对应号码和型号对应键值
        for(int i=1;i<=16;i++){
            String model = i%3+""+(i<10?i%3:(i-10)%3);
            List<Integer> list = map.get(model);
            if(list==null){
                list = new ArrayList<Integer>();
            }
            list.add(i);
            map.put(model,list);
        }
        //遍历
        Set<String> models = map.keySet();
        for(String model:models){
            StringBuilder sb = new StringBuilder(model+":");
            for(Integer num:map.get(model)){
                sb.append(num+",");
            }
            sb.replace(sb.length()-1,sb.length(),"");
            System.out.println(sb.toString());
        }
    }
}
