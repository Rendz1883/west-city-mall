package io.github.ireflux.westcitymall.util.GlobalInterceptor;


import cn.hutool.json.JSONObject;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GloablExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e){
        String message = e.getMessage();
        if (message==null ||message.equals("")){
            message="服务器报错";
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("message",message);
        return jsonObject;

    }
}
