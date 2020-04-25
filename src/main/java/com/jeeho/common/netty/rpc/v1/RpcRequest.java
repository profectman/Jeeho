package com.jeeho.common.netty.rpc.v1;

public class RpcRequest {
    private String id;

    private String serviceName;

    private String methodName;

    private double param1;

    private double param2;

    public RpcRequest() {
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

    public double getParam1() {
        return param1;
    }

    public void setParam1(double param1) {
        this.param1 = param1;
    }

    public double getParam2() {
        return param2;
    }

    public void setParam2(double param2) {
        this.param2 = param2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RpcRequest)) return false;

        RpcRequest that = (RpcRequest) o;

        if (Double.compare(that.getParam1(), getParam1()) != 0) return false;
        if (Double.compare(that.getParam2(), getParam2()) != 0) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getServiceName() != null ? !getServiceName().equals(that.getServiceName()) : that.getServiceName() != null)
            return false;
        return getMethodName() != null ? getMethodName().equals(that.getMethodName()) : that.getMethodName() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getServiceName() != null ? getServiceName().hashCode() : 0);
        result = 31 * result + (getMethodName() != null ? getMethodName().hashCode() : 0);
        temp = Double.doubleToLongBits(getParam1());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getParam2());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "id='" + id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", param1=" + param1 +
                ", param2=" + param2 +
                '}';
    }
}

