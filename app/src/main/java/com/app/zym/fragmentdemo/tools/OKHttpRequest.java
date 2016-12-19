package com.app.zym.fragmentdemo.tools;

import android.app.Activity;
import android.widget.Toast;

import com.app.zym.fragmentdemo.request.HttpRequest;
import com.app.zym.fragmentdemo.request.HttpRequestCallback;
import com.app.zym.fragmentdemo.request.RequestParams;
import com.app.zym.fragmentdemo.request.ResponseData;

import okhttp3.Headers;
import okhttp3.Response;

/**
 * Created by zymapp on 2016/9/26.
 */

public class OKHttpRequest {
    public interface AsyncRequest {  //回调接口
        /****
         * 网络请求回调方法
         * @param isSuccess     网络请求是否成功
         * @param json          服务器返回的json数据
         * @param tag           标识哪一个网络请求
         */
        void callBack(boolean isSuccess, String json, int tag);
    }
    private AsyncRequest asyncRequest;

    /****
     * 默认的构造方法
     */
    public OKHttpRequest(AsyncRequest asyncRequest){
        this.asyncRequest = asyncRequest;
    }

    /***
     * 发送网络请求(自动显示加载状态)
     * @param context   请求Activity
     * @param url       请求URL
     * @param params    请求参数
     */
    public void post(final Activity context, String url, RequestParams params){
        HttpRequest.post(url, params, new HttpRequestCallback() {
            @Override
            protected void onSuccess(Headers headers, Response httpResponse, String response, int tag) {
                asyncRequest.callBack(true,response, tag);
            }

            @Override
            public void onFailure(ResponseData rd, Headers headers, Response httpResponse, String response, int tag) {
                if (rd.getCode()== TIME_OUT) {
                    Toast.makeText(context, "链接超时,稍后再试!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, tag + "请求错误", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFinish() {
            }
        });
    }

    /***
     * 发送网络请求(自动显示加载状态)  使用配置文件中的默认请求地址
     * @param context
     * @param params
     */
    public void post(Activity context, RequestParams params){
        post(context, "", params);
    }


    /***
     * 发送网络请求（没有加载状态）
     * @param url       请求URL
     * @param params    请求参数
     */
    public void post(String url,RequestParams params){
        HttpRequest.post(url, params, new HttpRequestCallback() {
            @Override
            protected void onSuccess(Headers headers, Response httpResponse, String response, int tag) {
                asyncRequest.callBack(true, response, tag);
            }

            @Override
            public void onFailure(ResponseData rd, Headers headers, Response httpResponse, String response, int tag) {
                asyncRequest.callBack(false, response, tag);
            }

            @Override
            public void onFinish() {

            }
        });
    }

    /***
     * 发送网络请求（没有加载状态）  使用配置文件中的默认请求地址
     * @param params        请求参数
     */
    public void post(RequestParams params){
        post("", params);
    }

}
