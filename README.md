# 晨域电表代理服务

本项目通过调用晨域物联科技[管理后台][cnyiot-boss]接口，实现电量信息查询功能。

## 如何使用

### 配置
```yaml
cnyiot:
    # 用户名
    username: 19xxxxxxxxx
    # 密码，默认123456
    password: xxx
    # 调用秘钥
    key: xxxx
```
### 强烈建议
先登录官方提供的平台，测试账号信息，以下方式任选其一即可
- 微信小程序搜索`晨域智控平台`
- 支付宝搜索`晨域智控生活缴费`
- 管理后台[晨域物联科技][cnyiot-boss]

### 接口
本项目提供了三个接口

接口名称 | 请求类型 |接口路径
-- |-----| --
获取电表基本信息 | GET | /meterInfo/{key}
获取电表实时信息 | GET | /meterInstant/{key}
获取电表当月用电视图| GET | /meterMonthInfo/{key}

## 实现原理
![call-flow.png](img%2Fcall-flow.png)


[cnyiot-boss]: https://www.zk.cnyiot.com/cn
