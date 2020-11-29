package com.kgc.movie.tools;


import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class JuheDemo {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    //配置您申请的KEY
    //9d20ea2ceae55b992cf4e5ad32cb6601
    //e6a1137fb5ab17e9493e31e26ec520d8
    public static final String APPKEY ="086ad1a7857d69cc57f516356d7338e0";

    //1.按关键字检索影片信息
    public static Object getRequest1(String title){
        String result =null;
        JSONObject object=null;
        String url ="http://v.juhe.cn/movie/index";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("title",title);//需要检索的影片标题,utf8编码的urlencode
        params.put("smode","");//<font color=red>是否精确查找，精确:1 模糊:0  默认1</font>
        params.put("pagesize","");//<font color=red>每次返回条数，默认20,最大50</font>
        params.put("offset","");//<font color=red>偏移量，默认0,最大760</font>
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json

        try {
            result =net(url, params, "GET");
            object = JSONObject.fromObject(result);//字符串转json
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.get("result");
    }

    //2.检索周边影院
    public static Object getRequest2(String lat,String lon){
        String result =null;
        JSONObject object=null;
        String url ="http://v.juhe.cn/movie/cinemas.local";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("lat",lat);//纬度，百度地图坐标系
        params.put("lon",lon);//经度，百度地图坐标系
        params.put("radius",3000);//检索半径(米)，最大3000
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json

        try {
            result =net(url, params, "GET");
            object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.get("result");
    }

    //3.关键字影院检索
    public static Object getRequest3(Integer cityId){
        String result =null;
        JSONObject object=null;
        String url ="http://v.juhe.cn/movie/cinemas.search";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("cityid",cityId);//城市ID
        params.put("keyword","");//关键字，urlencode utf8
        params.put("page","");//页数，默认1
        params.put("pagesize","");//每页返回条数，默认20
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json

        try {
            result =net(url, params, "GET");
            object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.get("result");
    }

    //4.影院上映影片信息   查询影城专用
    public static Object getRequest4(int cinemaId){
        String result =null;
        JSONObject object=null;
        String url ="http://v.juhe.cn/movie/cinemas.movies";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("cinemaid",cinemaId);//影院ID
        params.put("movieid","");//指定电影ID，默认全部电影
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json

        try {
            result =net(url, params, "GET");
            object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.get("result");
    }

    //4.影院上映影片信息
    public static Object getRequest4(int cinemaid,int movieid){
        String result =null;
        JSONObject object=null;
        String url ="http://v.juhe.cn/movie/cinemas.movies";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("cinemaid",cinemaid);//影院ID
        params.put("movieid",movieid);//指定电影ID，默认全部电影
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json

        try {
            result =net(url, params, "GET");
            object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.get("result");
    }

    //5.今日放映影片
    public static Object getRequest5(int cityId){
        String result =null;
        JSONObject object=null;
        String url ="http://v.juhe.cn/movie/movies.today";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("cityid",cityId);//城市ID
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json

        try {
            result =net(url, params, "GET");
            object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                //	error_code	int	返回码
                // 	movieId	string	电影ID
                // 	movieName	string	影片名称
                // 	pic_url	string	影片图片
                System.out.println(object.get("error_code")+"\t"+object.get("movieId")+"\t"+object.get("movieName")+"\t"+object.get("pic_url")+"\t"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.get("result");
    }

    //6.支持城市列表
    public static void getRequest6(){
        String result =null;
        String url ="http://v.juhe.cn/movie/citys";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json

        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //7.影片上映影院查询
    public static Object getRequest7(int movieId,int cityId){
        String result =null;
        JSONObject object=null;
        String url ="http://v.juhe.cn/movie/movies.cinemas";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("cityid",cityId);//城市ID
        params.put("movieid",movieId);//影片ID
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json

        try {
            result =net(url, params, "GET");
            object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.get("result");
    }

    //8.按影片ID检索影片信息
    public static Object getRequest8(int movieId){
        String result =null;
        JSONObject object=null;
        String url ="http://v.juhe.cn/movie/query";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("movieid",movieId);//需要检索的影片id
        params.put("key",APPKEY);//应用APPKEY(应用详细页查询)
        params.put("dtype","");//返回数据的格式,xml/json，默认json

        try {
            result =net(url, params, "GET");
            object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.get("result");
    }



    public static void main(String[] args) {
//        int cityId=2;//北京
//        getRequest5(2);
        getRequest1("信条");
    }

    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
