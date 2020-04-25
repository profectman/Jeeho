package com.jeeho.common.netty.rpc.v1;

public class RpcResponse {

    private String id;

    private String serviceName;

    private String methodName;

    private String cause;

    private double result;

    public RpcResponse() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RpcResponse)) return false;

        RpcResponse that = (RpcResponse) o;

        if (Double.compare(that.getResult(), getResult()) != 0) return false;
        if (!getId().equals(that.getId())) return false;
        if (!getServiceName().equals(that.getServiceName())) return false;
        if (!getMethodName().equals(that.getMethodName())) return false;
        return getCause().equals(that.getCause());
    }

    @Override
    public int hashCode() {
        int result1;
        long temp;
        result1 = getId().hashCode();
        result1 = 31 * result1 + getServiceName().hashCode();
        result1 = 31 * result1 + getMethodName().hashCode();
        result1 = 31 * result1 + getCause().hashCode();
        temp = Double.doubleToLongBits(getResult());
        result1 = 31 * result1 + (int) (temp ^ (temp >>> 32));
        return result1;
    }

    @Override
    public String toString() {
        return "RpcResponse{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", cause='" + cause + '\'' +
                ", result=" + result +
                '}';
    }
}
