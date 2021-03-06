# LexianManager
乐鲜电商平台全套系统开发，涉及技术java SpringMVC+MyBatis+Angualr1.3+jQuery+bootstrap3.0+Android+ReatNative

goal： **实现后端+前端+安卓端+ios**

# 所用技术

### 后端：

* java springMVC

### 前端：

* angular1.3
* bootstrap3.0
* React-Native

### 数据库：

* myBatis

### 项目运行界面

##### 后台登录界面：

![http://osnk57csd.bkt.clouddn.com/%E7%81%AB%E7%8B%90%E6%88%AA%E5%9B%BE_2017-07-10T15-53-43.329Z.png](http://osnk57csd.bkt.clouddn.com/%E7%81%AB%E7%8B%90%E6%88%AA%E5%9B%BE_2017-07-10T15-53-43.329Z.png)

##### 后台系统界面

![http://osnk57csd.bkt.clouddn.com/%E7%81%AB%E7%8B%90%E6%88%AA%E5%9B%BE_2017-07-10T15-53-06.419Z.pn](http://osnk57csd.bkt.clouddn.com/%E7%81%AB%E7%8B%90%E6%88%AA%E5%9B%BE_2017-07-10T15-53-06.419Z.png)


目前进度：

  完成数据库搭建，后端与前端基本框架搭建。 前端使用angular构建单页应用，登录界面基本完成，实现登录功能
  
  *项目会不断更新直至完成，预计工时1周内完成网页版与后台，一周半完成安卓与ios端开发*

### 7.10 更新：

后端：

1. 完善登录功能，登录之后，后退回到登录界面，后端会清除相关session，避免影响下一次登录的状态
2. 登录成功后，再进入其他链接（如登录界面），登录状态下，会自动被过滤器捕获并跳到后台登录界面
3. 修改数据库数据，因为需求是每个不同的角色登录进入后台系统之后，菜单栏只会显示其角色的权限对应的菜单列表，但是后台查询返回的数据中，除了超级管理员角色外，其他角色都只是直接返回子项，并没有返回子项对应的大项。经过前后端协调沟通，决定修改数据库数据。增加相应的父项映射。

前端：

1. 完成左侧菜单栏的动态创建，根据用户的权限（后端返回的权限列表）进行动态的创建（angular实现）
2. 完成左侧菜单栏的动画交互，包括手风琴效果（bootstrap实现），点击某项active，并展开该项，同时其他大项折叠。一开始实现的想的是像jq实现选项卡，进行dom操作，后来发现bootstrap的手风琴插件，默认的就会为其他折叠项添加collapsed类，而展开项没有，就可以根据这个进行选中样式的设置（选中的项不会有collapsed类）。 而且如果按原来思路进行dom操作，要添加active类比较麻烦，因为html结构较为复杂，点击事件的target可能是a标签，strong标签，或者i标签（图标）。
3. 完善左列菜单栏的高度问题。因为父div与左右两个子div都是内容撑开，当其中一方超长时，会把父div撑开，希望另一个子div也跟着适应父div的高度。就用到了双飞翼布局与圣杯布局里的手法。具体解决方法是：

* 父div设置为`overflow:hidden`;
* 子div分别设置`padding-bottom:9999px; margin-bottom:-9999px`;

### 7.11更新

前端：

1. 与后端协调后决定代码重构，将管理端后台界面左侧并为一个controller，并重新设计接口，方便获取数据；
2. 将常用方法设封装成service，如http，还有一些数据转换等，controller代码减轻很多，赏心悦目；（顺便弄懂了angular中的$q的使用）
3. 完成退出登录，修改密码功能开发。包括修改密码时的输入验证（使用angular）
4. 完成权限模块的一级界面的数据展示，数据从数据库获取。
5. 将模块页面中的style抽离，整体完善html代码。

后端：

1. 配合前端完善接口设计
2. 完成分页功能

### 7.12更新

前端： 

1. 基本完成所有模块的一级路由界面的数据展示，完成各个一级路由与界面的连接。
2. 为每个模块添加分页。封装成指令。
3. 添加模态框，封装成指令
4. 增加welcome页面。
5. 因为order模块的几个获取数据都是类似的，只是返回数值的state不同（未付款，已付款，已发货等）故封装成一个service。

今日遇到的小坑：*angular的指令，元素的话不能含有大写（不能驼峰），注释的话注意空格！*

如： `<confirmdeletemodal></confirmdeletemodal>` , 

     <!-- directive:confirmdeletemodal -->
     <div></div>

### 7.13 更新

前端：

1. 完成查看角色信息模块的添加，修改，和添加菜单功能。
2. 搭建查看后台用户的二级路由。
3. 完成板块管理的一级交互

今日遇到的坑：

1. angular 里面的forEach是不能跳出循环的，无论是break还是return，都不生效，也不报错。（据说是因为所有的条件语句都会降低指令缓存和流水线的性能，听说c#也是如此。迭代过程不允许更改容器本身（删减元素），不允许break

*解决办法*， 设置一个布尔值，只有满足某条件，进入if，然后在if中设置布尔值，然后此后，因为不满足布尔值，所以无法进入if，变相实现了“跳出循环” 因为此后的循环都没有意义，进入不了if。

2. js数组方法：`splice()`和`slice()`，前者会改变原数组，而后者不会，前者接收三个参数，实现替换，操作等功能，而后者主要实现的是删除，接收两个参数。

### 7.14 更新

1. 使用angular的过滤器重构一些循环，优化代码
2. 测试调bug添加角色菜单功能，修复添加菜单角色功能后不生效的问题


### 环境搭建

为了方便大家导入我们的项目并跑起来：

开发的环境是eclipse java ee + mysql

**注意修改数据库配置文件**，在java资源下config的db.properies文件，修改用户名密码为自己的数据库的。

记得导入数据，数据文件在db目录下的.sql文件中，在数据库中执行sql脚本即可完成数据导入。

最后如果项目导入报错，有可能是由于.class文件问题，只需要把build目录下的.class文件删掉即可（毕竟是编译文件，重新编译即可，而且在我的环境下编译的.class文件下可能到了各位的电脑中环境不一样，而会导致报错。） 

> 希望能帮到各位~

**欢迎star与关注(￣▽￣)~**
