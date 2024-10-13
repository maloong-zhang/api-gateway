package ae.zerotone.gateway.rpc;

import ae.zerotone.gateway.rpc.dto.XReq;

public interface IActivityBooth {

  String sayHi(String str);

  String insert(XReq req);

  String test(String str, XReq req);
}
