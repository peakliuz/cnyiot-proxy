# 晨域电表代理服务

本项目通过调用晨域物联科技[管理后台][cnyiot-boss]接口，实现电量信息查询功能。

## 如何使用



```bash
docker run -d -p 6232:6232 -e USERNAME=xxx -e PASSWORD=123456 -e KEY=xxx peakliuz/cnyiot-proxy
```
- USERNAME： 用户名(电表号)
- USERNAME： 密码，默认123456
- KEY：调用秘钥，通过接口调用时传入

### 强烈建议
先登录官方提供的平台，测试账号信息，以下方式任选其一即可
- 微信小程序搜索`晨域智控平台`
- 支付宝搜索`晨域智控生活缴费`
- 管理后台[晨域物联科技][cnyiot-boss]

### 接口
本项目提供了三个接口

调用可以用`http://localhost:6232/路径`

接口名称 | 请求类型 |接口路径 | 备注
-- |-----| ----- | -----
获取电表基本信息 | GET | /meterInfo/{key} |
获取电表实时信息 | GET | /meterInstant/{key}| 调用频率别太高,官方限制了,10s以上就行
获取电表当月用电视图| GET | /meterMonthInfo/{key}

## 实现原理
![call-flow.png](img%2Fcall-flow.png)


[cnyiot-boss]: https://www.zk.cnyiot.com/cn
