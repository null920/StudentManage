# 运行项目请按照以下步骤
1. 先创建一个数据库，在<mark>src/main/resources/sql</mark>目录下有数据表的sql文件，您可以直接在您的数据库中运行；
2. 根据自己电脑的环境，修改位于<mark>src/main/resources</mark>目录下的<mark>application.properties</mark>文件，主要修改数据库配置中的<mark>username</mark>、<mark>password</mark>和<mark>url</mark>。
3. 然后等待依赖导入完成，应该就可以运行了。
4. 初始用户名和密码都为<mark>root</mark>,因为有些样式文件是访问的在线的，所以第一次访问可能加载有点慢。