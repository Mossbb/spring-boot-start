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

### 2023.03.27
> 1. springboot版本从2.4.13降至2.4.2（为了配合Nacos版本兼容问题）
> 2. 规范业务异常类型，code限制为7种类型，避免滥用（参考：BizExceptionEnums）
> 3. 规范redis中key的使用规范（参考：RedisKeyEnum、TestController）
> 4. 集成Nacos，所有需变更配置迁移至Nacos（动态配置参考：DynamicConfig，配置变更监听参考：NacosCommonConfigListener & NacosConfig）
> 5. 添加统一业务实现入口（参考：AbstractAction）
> 6. 开启SpringUtil的支持，参考：EnableSpringUtil

### 2023.04.11
> 1. 添加全局异常处理（参考：GlobalExceptionConfig），并且基础异常类型及自定义异常编码扩展（参考：ErrorBaseEnum）
> 2. 支持i18n（参考：MessageUtil & LocaleConfig & validation_zh.properties）
> 3. 添加相关参数异常校验案例（参考：UserAddOrUpdateReq）
> 4. 添加Action执行模式，确保service代码清晰，方便抽象（参考：AbstractAction）

### 2023.05.08
> 1. web项目添加jasypt加密配置，加密nacos中的数据库、动态配置等配置，具体参考
> 2. 新增LikeEscapeInterceptor、PaginationInnerInterceptor、MyMetaObjectHandler等mybatis拦截器，用于like关键字转义以及分页
> 3. 修改@MapperScan扫描路径，否则会导致Mapper接口代理无效

### 2023.05.12
> 1. 拆分bootstrap.yml部分配置内容至application.yml，只保留springcloud部分配置
> 2. 集成dubbo2.7.23，完善dubbo相关starter配置和注释，添加dubbo service和reference的测试（具体参考DubboUserService）
