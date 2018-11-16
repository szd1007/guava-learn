## 编译module命令
>1. javac --module-path appmodules -d appmodules/appstart appsrc/appstart/module-info.java appsrc/appstart/appstart/mymodappdemo/MyModAppDemo.java

>2. javac -d appmodules --module-source-path appsrc appsrc/appstart/appstart/mymodappdemo/MyModAppDemo.java 

## 运行

 >1. java --module-path appmodules -m appstart/appstart.mymodappdemo.MyModAppDemo