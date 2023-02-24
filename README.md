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

## 高版本的JDK需要下载并配置额外Jar包

Jar包 可以从链接下载或直接从项目中的`lib`文件夹中复制。

1. [tools.jar(下载链接)](http://www.java2s.com/Code/Jar/t/Downloadtools21jar.htm) 

    下载后将其放在 `%JAVA_HOME%/lib/`[^1] 中，命名为 `tools.jar`。
    `apt-mirror-api依赖` 需要在 `%JAVA_HOME%/lib/`中的名为`tools.jar`的jar包。

2. [jnlp(下载链接)](http://repo.anahata.uno/artifactory/anahata-public/javax/jnlp/jnlp/7.0/jnlp-7.0.jar)

    下载后将其放在 `%JAVA_HOME%/lib/`[^1] 中，无需修改命名。

> 保证版本、名称与maven中的配置信息一致即可。

[^1]:java安装的目录中的`lib`文件夹
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
