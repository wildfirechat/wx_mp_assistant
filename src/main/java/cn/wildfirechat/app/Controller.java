package cn.wildfirechat.app;

import cn.wildfirechat.pojos.SendMessageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private Service mService;

    //接收公众号消息
    @PostMapping(value = "/in/wx")
    public Object onReceiveWXData(@RequestBody String payload) {
        System.out.println("Receive wx data:" + payload);
        mService.onReceiveWXData(payload);
        return "OK";
    }

    //接收机器人的回调
    @PostMapping(value = "/robot/recvmsg", produces = "application/json;charset=UTF-8"   )
    public Object recvMsg(@RequestBody SendMessageData messageData) {
        mService.onReceiveMessage(messageData);
        return "OK";
    }

    //微信公众号开启 "服务器配置" 使用。详情参考 https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Access_Overview.html
    @GetMapping(value = "/in/wx")
    public Object onGetWXData(@RequestParam("echostr") String event) {
        System.out.println("Receive wx data:" + event);
        return event;
    }

}
