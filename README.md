#  Think in Java Example By Maven

对所有文件进行了整理。保证其在IDEA中可以直接运行单个文件。

1. 通过Maven进行包管理。有部分特殊包需要进行单独下载，并配置。
2. 对编译报错的内容进行了注释，并使用`TODO`进行标明。
3. 路径错误后续会进行修改。

## 环境

JDK 17.0.6

Maven 3.8.7

Windows 10 22H2 19045.2486

IDEA 2022.3.2

## 修改Maven配置

maven 中的镜像设置，只对中央仓库进行镜像代理。否则会影响pom.xml文件中配置的仓库。

```xml
<mirror>
    <id>aliyunmaven</id>
    <mirrorOf>central</mirrorOf>
    <name>阿里云公共仓库</name>
    <url>https://maven.aliyun.com/repository/public</url>
</mirror>
```

## 加载 Maven 依赖

在IDEA中加载所有Maven依赖
