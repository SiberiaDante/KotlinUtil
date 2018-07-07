# KotlinUtil



#### KActivityMangerUtil
```
addActivity(activity: AppCompatActivity):       向栈中添加Activity
removeActivit(activity: AppCompatActivity):     移除栈中的Activity
getTopActivity();                               获取栈顶Activity
finishActivity(activity: AppCompatActivity):    销毁指定的Activity
finishAllActivity():                            销毁栈中的所有Activity
exitApp(context: Context):                      退出APP
```
#### KDateUtil
```
getTimeStamp():                                         获取时间戳（秒）
getTimeStampMillis():                                   获取时间戳（毫秒）
getCurrentYear():                                       获取当前年份
getCurrentMonth():                                      获取当前月份
getCurrentDay():                                        获取当前月份中的天
getCurrentHours():                                      获取当天的时
getCurrentMinutes():                                    获取分
getCurrentSeconds():                                    获取秒
getDateTime(format: String):                            获取时间，默认格式：yyyy-MM-dd HH:mm:ss
getTimeStampToDate(timestamp: Long, format: String):    指定格式和时间戳获取时间
getTotalDaysOfMonth(year: Int, month: Int):             获取某一年的某一月总共多少天
getConstellation(month: Int, day: Int):                 获取星座

```
#### KDeviceUtil
```
getContactsList():              获取设备联系人信息
getDeviceBuild():               获取设备厂商
getDeviceMobileNumber():        读取设备手机号码
getDeviceModel():               设备型号
getDeviceName():                设备名
getDeviceSystemVersionName():   设备系统版本名
getDeviceType():                设备类型
getSDKVersionCode():            设备系统SDK版本号
getSDKVersionName():            读取系统SDK版本名
getSIMCardOperatorCode():       设备SIM卡运营商码
getSIMCardOperatorName():       设备SIM卡运营商名
getSIMCardOperatorNameCN():     设备SIM卡运营商名
isDeviceRooted():               检查设备是否Root
isSIMCardReady():               设备SIM卡是否准备好
```
#### KNetworkUtil
```
isNetConneted(context: Context):        判断网络是否连接
isWifiNetConnected(context: Context):   判断是否无线网络连接
isPhoneNetConnected(context: Context):  判断是否手机网络连接
```
#### KTransitionUtil
```
getDensity(activity: AppCompatActivity):        获取屏幕密度
dip2px(context: Context, dipValue: Float):      dip转px
px2dip(context: Context, pxValue: Float):       px转dip
px2sp(context: Context, spValue: Float):        px转sp
sp2px(context: Context, pxValue: Float):        sp转px
```

#### KTimerUtil
```
isNotFastClick():防止快速点击
isNotFastClick(time: Int):防止快速点击
```