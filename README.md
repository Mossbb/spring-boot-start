## 项目名称

> 快速创建spring boot项目,包含一些基础依赖和代码规范

## 项目说明

> 项目整合了mybatis/redisTemplate以及完善了相关的配置类,修改各个环境的application.properties,将mysql和redis连接信息补充完整<br/>
> 项目整合了logback日志,有需求修改logback-spring.xml文件即可

## 子模块说明

> api:对外提供RPC接口，包括请求、返回参数及接口的定义<br/>
> common:本工程用到的一些通用方法其中包含utils等等<br/>
> dao:数据库交互层，统一使用MybatisX生成对应目录，有需要自定义的为确保不被自动生成覆盖，自定义扩展Mapper类<br/>
> manager:数据逻辑层，主要用于从各种不同中间件、三方系统获取数据，组装DTO<br/>
> remote:远程调用服务，包含RPC调用以及一些三方调用服务统一入口<br/>
> service:系统逻辑层<br/>
> web:controller层<br/>

## 子模块依赖说明

> api:不依赖任何子模块,对外提供二方包也只打包这个模块<br/>
> common:不依赖任何子模块<br/>
> dao:不依赖任何子模块<br/>
> manager:依赖dao,common层<br/>
> remote:依赖common层<br/>
> service:依赖api,common,manager,dao,remote层<br/>
> web:依赖service层<br/>

## 规范说明

> controller/api层返回接口统一用com.ryytn.start.common.Result封装返回
> 分页使用Result<PageResult<T>>返回
> 业务异常直接抛出com.ryytn.start.common.BizException

## 版本变更说明
### 2023.03.10
> 1. 集成xxl-job，新增job启动模块
> 2. 删除分页结果类，统一使用hutool中的PageResult
> 3. dao模块统一使用MybatisX插件生成对应的domain、mapper、service以及mapper.xml文件，无特殊情况不手动编写代码
> 4. 废弃druid框架，使用hikari框架
> 5. http远程调用工具统一使用forest框架，参考[Forest:声明式HTTP客户端框架](https://forest.dtflyx.com/)


