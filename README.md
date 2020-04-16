# 野火IM机器人应用之公众号助手
微信公众号助手。客户在微信公众号的私聊和留言都转发到野火IM中的指定用户，用户回复转发给对应的微信客户。

## 实现原理
1. 在公众号后台开启服务功能，所有的事件都会发送到当前服务。
2. 当前服务检查微信用户是否存在影子机器人，如果不存在则从微信获取用户信息然后在野火IM中创建一个。创建的机器人指定回调地址为当前服务
3. 当前服务使用影子机器人的账户给管理员发送消息
4. 管理员回复给机器人的消息回调到当前服务。
5. 当前服务把消息通过微信api发送到对应客户。
> 注意是每个微信用户，都对应一个在野火IM中的机器人（也叫影子机器人）。

## 修改配置
找到配置文件```application.properties```，修改下面配置。
```
server.port=8000

## 机器人回调地址，注意带上path
robot.callback=http://192.168.2.4/robot/recvmsg

## 管理员账户
admin.admin_id=cgc8c8VV

## server api 地址及密钥
admin.url=http://192.168.2.15:18080
admin.secret=123456

## 机器人前缀
robot.shadow_prefix=RB_

## 信息的信息
wx.app_id=wxe450c4b0dc5c8bda
wx.secret=07f063a940b7334b29d3f9e5c413722c
wx.token=imtesttest
wx.aeskey=jufVF5k3oxaQGX2E9fenJzdEnc5DZ34LHB411qAgW9I

## 订阅的欢迎语
wx.subscribe_welcome=欢迎关注！
```

## 编译
```
mvn package
```

## 运行
在```target```目录找到```wx_mp_assistant-0.1.jar```，拷贝到具有公网IP的服务器上，然后执行下面语句：
```
java -jar wx_mp_assistant-0.1.jar
```
>> 在linux机器上，为了防止关掉终端后退出，可以用nohup命令执行，例如 ```nohup java -jar wx_mp_assistant-0.1.jar &```

## 配置公众号后台
开启公众号后台服务功能，填写各种信息

## LICENSE
UNDER MIT LICENSE. 详情见LICENSE文件
