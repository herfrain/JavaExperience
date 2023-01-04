package SerializableUtil;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KryoSerializerTest {

    @Test
    void test() throws SerializeException {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.state = 1;
        rpcRequest.id = 2;
        rpcRequest.value = 3;

        KryoSerializer kryoSerializer = new KryoSerializer();
        byte[] bytes = kryoSerializer.serialize(rpcRequest);
        System.out.println(Arrays.toString(bytes));

        RpcRequest object = kryoSerializer.deserialize(bytes, RpcRequest.class);
        System.out.println(object);
    }
}