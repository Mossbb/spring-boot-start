## 项目名称

> 快速创建spring boot项目,包含一些基础依赖和代码规范

## 项目说明

> 项目整合了mybatis/redisTemplate以及完善了相关的配置类,修改各个环境的application.properties,将mysql和redis连接信息补充完整<br/>
> 项目整合了logback日志,有需求修改logback-spring.xml文件即可

## 子模块说明

> api:对外提供RPC接口<br/>
> common:本工程用到的一些通用方法其中包含utils等等<br/>
> dao:数据库交互层<br/>
> manager:数据逻辑层<br/>
> remote:远程调用服务,包含RPC调用以及一些三方调用服务统一入口<br/>
> service:系统逻辑层<br/>
> web:controller层<br/>

## 子模块依赖说明

> api:不依赖任何子模块,对外提供二方包也只打包这个模块<br/>
> common:不依赖任何子模块<br/>
> dao:不依赖任何子模块<br/>
> manager:依赖dao,common层<br/>
> remote:依赖common层<br/>
> service:依赖api,common,manager,remote层<br/>
> web:依赖service层<br/>

## 规范说明

> controller/api层返回接口统一用com.ryytn.start.common.Result封装返回
> 分页使用Result<PaginationResult<T>>返回
> 业务异常直接抛出com.ryytn.start.com.ryytn.start.common.BizException


