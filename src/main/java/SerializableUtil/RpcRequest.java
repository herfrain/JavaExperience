package SerializableUtil;

public class RpcRequest {
    int state;
    int id;
    int value;

    @Override
    public String toString() {
        return "RpcRequest{" +
                "state=" + state +
                ", id=" + id +
                ", value=" + value +
                '}';
    }
}
