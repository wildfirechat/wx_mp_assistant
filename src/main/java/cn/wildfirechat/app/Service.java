package cn.wildfirechat.app;


import cn.wildfirechat.pojos.SendMessageData;

public interface Service {
    void onReceiveWXData(String payload);
    void onReceiveMessage(SendMessageData messageData);
}
