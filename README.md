# KotlinUtil



#### KActivityMangerUtil
```
addActivity(activity: AppCompatActivity):向栈中添加Activity
removeActivit(activity: AppCompatActivity):移除栈中的Activity
getTopActivity();获取栈顶Activity
finishActivity(activity: AppCompatActivity):销毁指定的Activity
finishAllActivity():销毁栈中的所有Activity
exitApp(context: Context):退出APP
```
#### KDateUtil
```
getTimeStamp():获取时间戳（秒）
getTimeStampMillis():获取时间戳（毫秒）
```
#### KNetworkUtil
```
isNetConneted(context: Context):判断网络是否连接
isWifiNetConnected(context: Context):判断是否无线网络连接
isPhoneNetConnected(context: Context):判断是否手机网络连接
```
#### KTransitionUtil
```
dip2px(context: Context, dipValue: Float)：dip转px
px2dip(context: Context, pxValue: Float)：px转dip
```