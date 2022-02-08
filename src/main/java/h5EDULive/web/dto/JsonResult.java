package h5EDULive.web.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import h5EDULive.dao.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSON返回
 * @Author ZhangRongrong
 */
public class JsonResult {
    public static JSONObject strToJson(String str) {
        Map<String,Object> suc = new HashMap<>();
        suc.put("data", str);
        return new JSONObject(suc);
    }

    public static JSONObject objToJson(Object object)
    {
        return JSON.parseObject(JSON.toJSONString(object));
    }

    public static JSONArray listToJson(List list)
    {
        return JSON.parseArray(JSON.toJSONString(list));
    }
}
