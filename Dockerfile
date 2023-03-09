FROM --platform=linux/amd64 registry.cn-hangzhou.aliyuncs.com/ryytn-r3-uat/openjdk:8-jdk
COPY start-web/target/start-web.jar /home/admin/start-web.jar

EXPOSE 8080
ENV APP_NAME=start
## 环境变量
ENV APP_PROFILE=online

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

#ENV JAVA_OPTS="-javaagent:/skywalking/agent/skywalking-agent.jar"
## jvm 参数自行修改
ENV JAVA_OPTS="-Dfile.encoding=UTF-8 -Dspring.jmx.enabled=false -Dspring.profiles.active=${APP_PROFILE} -Dskywalking.collector.backend_service=${SW_AGENT_COLLECTOR_BACKEND_SERVICES} -Dskywalking.agent.authentication=${SW_AGENT_AUTHENTICATION} -Xms2g -Xmx4g -Xss256k -XX:MetaspaceSize=256M -XX:NewRatio=2 -XX:SurvivorRatio=4 -XX:+UseConcMarkSweepGC -XX:ConcGCThreads=4 -XX:ParallelGCThreads=4 -XX:+CMSScavengeBeforeRemark -XX:PretenureSizeThreshold=64m -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=60 -XX:CMSMaxAbortablePrecleanTime=5000 -XX:+CMSParallelRemarkEnabled -XX:+ParallelRefProcEnabled -XX:-OmitStackTraceInFastThrow"
## 启动参数
CMD [ "sh", "-c", "java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /home/admin/${APP_NAME}.jar" ]