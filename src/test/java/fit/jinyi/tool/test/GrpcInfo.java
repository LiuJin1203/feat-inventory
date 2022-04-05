package fit.jinyi.tool.test;


/**
 * @author liujin
 * @date 2020/8/3
 * @since JDK8
 */
public class GrpcInfo {
    /**
     * 远程服务接口类
     */
    Class serviceApiClass;
    /**
     * 端口
     */
    int port;
    /**
     * IP地址
     */
    String ip;
    /**
     * 服务名
     */
    String serviceName ;
    /**
     * 与serviceName之间建立固定规则联系
     */
    Class grpcServiceClass ;

    public GrpcInfo() {
    }

    /**
     * 获取 远程服务接口类
     *
     * @return serviceApiClass 远程服务接口类
     */
    public Class getServiceApiClass() {
        return this.serviceApiClass;
    }

    /**
     * 设置 远程服务接口类
     *
     * @param serviceApiClass 远程服务接口类
     */
    public void setServiceApiClass(Class serviceApiClass) {
        this.serviceApiClass = serviceApiClass;
    }

    /**
     * 获取 端口
     *
     * @return port 端口
     */
    public int getPort() {
        return this.port;
    }

    /**
     * 设置 端口
     *
     * @param port 端口
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * 获取 IP地址
     *
     * @return ip IP地址
     */
    public String getIp() {
        return this.ip;
    }

    /**
     * 设置 IP地址
     *
     * @param ip IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取 服务名
     *
     * @return serviceName 服务名
     */
    public String getServiceName() {
        return this.serviceName;
    }

    /**
     * 设置 服务名
     *
     * @param serviceName 服务名
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * 获取 与serviceName之间建立固定规则联系
     *
     * @return grpcServiceClass 与serviceName之间建立固定规则联系
     */
    public Class getGrpcServiceClass() {
        return this.grpcServiceClass;
    }

    /**
     * 设置 与serviceName之间建立固定规则联系
     *
     * @param grpcServiceClass 与serviceName之间建立固定规则联系
     */
    public void setGrpcServiceClass(Class grpcServiceClass) {
        this.grpcServiceClass = grpcServiceClass;
    }

    @Override
    public String toString() {
        return "GrpcInfo{" +
                "serviceApiClass=" + serviceApiClass +
                ", port=" + port +
                ", ip='" + ip + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", grpcServiceClass=" + grpcServiceClass +
                '}';
    }
}
